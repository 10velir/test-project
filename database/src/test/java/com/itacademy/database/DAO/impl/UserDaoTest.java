package com.itacademy.database.DAO.impl;

import com.itacademy.database.config.DatabaseConfig;
import com.itacademy.database.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DatabaseConfig.class)
@Transactional
public class UserDaoTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void beanNotNullChecker() {
        assertNotNull(userRepository);
    }
}