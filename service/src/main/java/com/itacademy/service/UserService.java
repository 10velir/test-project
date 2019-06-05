package com.itacademy.service;

import com.itacademy.database.DAO.impl.UserDao;
import com.itacademy.database.DAO.impl.UserSearchFilter;
import com.itacademy.database.entities.User;

import java.util.List;

public class UserService {

    private static final UserService INSTANCE = new UserService();

    public final UserDao userDao = UserDao.getInstance();

    public static UserService getInstance() {
        return INSTANCE;
    }

    public List<User> getWithFilters(UserSearchFilter userSearchFilter) {

        return userDao.getWithFilters(userSearchFilter);
    }

    public List<User> getAll() {

        return userDao.getAll();
    }
}
