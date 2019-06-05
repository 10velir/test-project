package com.itacademy.database.DAO.impl;

import com.itacademy.database.DAO.BaseDao;
import com.itacademy.database.entities.Passport;
import com.itacademy.database.entities.User;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.Cleanup;
import org.hibernate.Session;

import java.util.List;

import static com.itacademy.database.entities.QPassport.passport;
import static com.itacademy.database.entities.QUser.user;
import static com.itacademy.database.util.SessionManager.getSession;

public class UserDao implements BaseDao<Integer, User> {

    private static final UserDao INSTANSE = new UserDao();

    public static UserDao getInstance() {
        return INSTANSE;
    }

    public List<User> getByName(String name) {

        @Cleanup Session session = getSession();
        return new JPAQuery<User>(session)
                .select(user)
                .from(user)
                .where(user.name.eq(name))
                .fetch();
    }

    public User getByLogin(String login) {

        @Cleanup Session session = getSession();
        return new JPAQuery<User>(session)
                .select(user)
                .from(user)
                .where(user.login.eq(login))
                .fetchOne();
    }

    public User getByPassportDetails(Passport userPassport) {

        @Cleanup Session session = getSession();
        return new JPAQuery<User>(session)
                .select(user)
                .from(user)
                .join(user.passport, passport)
                .where(passport.id.eq(userPassport.getId()))
                .fetchOne();
    }

    public List<User> getWithFilters(UserSearchFilter searchFilter) {

        @Cleanup Session session = getSession();
        JPAQuery<User> queryWithFilters = new JPAQuery<>(session);

        if (searchFilter.getName() != null) {
            queryWithFilters.where(user.name.eq(searchFilter.getName()));
        }
        if (searchFilter.getLogin() != null) {
            queryWithFilters.where(user.login.eq(searchFilter.getLogin()));
        }
        if (searchFilter.getEmail() != null) {
            queryWithFilters.where(user.contacts.email.eq(searchFilter.getEmail()));
        }
        if (searchFilter.getPhoneNumber() != null) {
            queryWithFilters.where(user.contacts.phoneNumber.eq(searchFilter.getPhoneNumber()));
        }
        if (searchFilter.getBirthDate() != null) {
            queryWithFilters.where(user.birthDate.eq(searchFilter.getBirthDate()));
        }
        if (searchFilter.getLimit() != null) {
            queryWithFilters.limit(searchFilter.getLimit());
        }
        if (searchFilter.getOffset() != null) {
            queryWithFilters.offset(searchFilter.getOffset());
        }
        queryWithFilters
                .select(user)
                .from(user);
        return queryWithFilters.fetch();
    }
}
