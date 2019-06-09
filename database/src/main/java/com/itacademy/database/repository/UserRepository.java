package com.itacademy.database.repository;

import com.itacademy.database.entity.Passport;
import com.itacademy.database.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long>, CustomUserRepository {

    Optional<User> findAllByName(String name);

    Optional<User> findByLogin(String login);

    Optional<User> findByPassport(Passport passport);
}
