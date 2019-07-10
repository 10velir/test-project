package com.itacademy.database.config;

import com.itacademy.database.entity.Car;
import com.itacademy.database.repository.CarRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DatabaseConfig.class)
@Transactional
public class DatabaseConfigTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private CarRepository carRepository;

    @Test
    public void checkProperty(){
    /*    Car car = carRepository.getById(10);
        car.setMaxSpeed(500);
        Car save = carRepository.save(car);
        Integer maxSpeed = save.getMaxSpeed();
        System.out.println(maxSpeed);
        Assert.assertNotNull(java.util.Optional.ofNullable(maxSpeed));*/
    }
}