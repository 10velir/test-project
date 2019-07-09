package com.itacademy.database.repository;

import com.itacademy.database.entity.Passport;
import com.itacademy.database.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long>, CustomUserRepository {

    Optional<User> findAllByName(String name);

    User findByLogin(String login);

    Optional<User> findByLoginAndPassword(String login, String password);

    Optional<User> findByPassport(Passport passport);

    @Query("select u from User u where u.login =:userName")
    User getUserByLogin(@Param("userName") String login);

    @Query(value = "SELECT * FROM rental_company.user_ where rental_company.user_.id= :userId",
            nativeQuery = true)
    User getById(@Param("userId") Long userId);
}
