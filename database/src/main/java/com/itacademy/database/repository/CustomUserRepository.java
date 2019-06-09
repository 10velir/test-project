package com.itacademy.database.repository;

import com.itacademy.database.entity.User;
import com.itacademy.database.fitler.UserSearchFilter;

import java.util.List;

public interface CustomUserRepository {

    List<User> getWithFilters(UserSearchFilter searchFilter);
}
