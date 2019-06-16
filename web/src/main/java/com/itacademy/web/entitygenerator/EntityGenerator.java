package com.itacademy.web.entitygenerator;

import com.itacademy.database.entity.Address;
import com.itacademy.database.entity.Passport;
import com.itacademy.database.entity.User;
import com.itacademy.database.entity.enumeration.Role;
import com.itacademy.database.entity.enumeration.UserStatus;

import java.time.LocalDate;

public class EntityGenerator {

    public User getUser() {

        User user = User.builder()
                .password("**********")
                .birthDate(LocalDate.now())
                .login("Jey1996")
                .name("Jey")
                .role(Role.USER)
                .status(UserStatus.ACTIVE)
                .build();

        Passport passport = Passport.builder()
                .series("KB")
                .number("2234234324")
                .owner(user)
                .build();

        Address address = Address.builder()
                .city("Minsk")
                .street("Nemiga")
                .build();

        user.setAddress(address);

        return user;
    }
}
