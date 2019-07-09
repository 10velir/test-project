package com.itacademy.service.service;

import com.itacademy.database.entity.User;
import com.itacademy.database.fitler.UserSearchFilter;
import com.itacademy.database.repository.AddressRepository;
import com.itacademy.database.repository.UserRepository;
import com.itacademy.service.dto.LoginDto;
import com.itacademy.service.dto.UserDto;
import com.itacademy.service.util.Mapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    public List<User> getWithFilters(UserSearchFilter userSearchFilter) {
        return userRepository.getWithFilters(userSearchFilter);
    }

    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    @Transactional
    public Optional<User> login(LoginDto loginDto) {
        return userRepository.findByLoginAndPassword(loginDto.getUsername(), loginDto.getPassword());
    }

    @Transactional
    public Optional<User> getByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    @Transactional
    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Transactional
    public User updateUser(User user, UserDto userDto) {
        Mapper.MapDtoToEntity(userDto, user, null);
        /*  user.setPassword(userDto.getPassword());
          user.setName(userDto.getName());
          user.setContacts(Contacts.builder()
                .email(userDto.getEmail())
                .phoneNumber(userDto.getPhoneNumber())
                .build());
        Address address = Address.builder()
                .city(userDto.getCity())
                .street(userDto.getStreet())
                .build();
        address.setUsers(Set.of(user));
        addressRepository.save(address);
        user.setAddress(address);*/

        return userRepository.save(user);
    }

    @Transactional
    public User register(User user) {
        return userRepository.save(user);
    }
}
