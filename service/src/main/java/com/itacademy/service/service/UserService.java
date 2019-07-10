package com.itacademy.service.service;

import com.itacademy.database.entity.Address;
import com.itacademy.database.entity.Contacts;
import com.itacademy.database.entity.User;
import com.itacademy.database.entity.enumeration.Role;
import com.itacademy.database.entity.enumeration.UserStatus;
import com.itacademy.database.fitler.UserSearchFilter;
import com.itacademy.database.repository.AddressRepository;
import com.itacademy.database.repository.UserRepository;
import com.itacademy.service.dto.LoginDto;
import com.itacademy.service.dto.UserDto;
import com.itacademy.service.util.Mapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
@Slf4j
@Transactional(readOnly = true)
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

    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Transactional
    public User updateUser(User user, UserDto userDto) {
        Mapper.MapDtoToEntity(userDto, user, List.of("login"));

        Address address = new Address();
        if(!userDto.getCity().equals("")) {
            address.setCity(userDto.getCity());
        }
        if(!userDto.getStreet().equals("")) {
            address.setStreet(userDto.getStreet());
        }
        address.setUsers(Set.of(user));
        addressRepository.save(address);
        user.setAddress(address);
        return userRepository.save(user);
    }

    @Transactional
    public User register(User user) {
        user.setRole(Role.USER);
        user.setStatus(UserStatus.ACTIVE);
        return userRepository.save(user);
    }
}
