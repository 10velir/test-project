package com.itacademy.database.config;

import com.itacademy.database.repository.CarRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DatabaseConfig.class)
@Transactional
public class DatabaseConfigTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private CarRepository carRepository;

    @Test
    public void checkProperty() {
        System.out.println();
    }
}