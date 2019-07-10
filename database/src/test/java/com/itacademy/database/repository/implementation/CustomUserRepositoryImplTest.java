package com.itacademy.database.repository.implementation;

import com.itacademy.database.config.DatabaseConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@Transactional
@ContextConfiguration(classes = DatabaseConfig.class)
public class CustomUserRepositoryImplTest {

    @Test
    public void getWithFilters() {
    }
}