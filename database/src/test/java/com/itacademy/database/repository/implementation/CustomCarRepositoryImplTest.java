package com.itacademy.database.repository.implementation;

import com.itacademy.database.config.DatabaseConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DatabaseConfig.class)
@Transactional
public class CustomCarRepositoryImplTest {


    @Test
    public void getWithFilters() {
    }
}
