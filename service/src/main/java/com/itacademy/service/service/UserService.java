package com.itacademy.service.service;

import com.itacademy.database.entity.User;
import com.itacademy.database.fitler.UserSearchFilter;
import com.itacademy.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public List<User> getWithFilters(UserSearchFilter userSearchFilter) {
        return userRepository.getWithFilters(userSearchFilter);
    }

    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    @Transactional
    public User login(String userName, String password) {
        User user = userRepository.save(User.builder()
                .login(userName)
                .password(password)
                .build());
        return user;
    }
}
