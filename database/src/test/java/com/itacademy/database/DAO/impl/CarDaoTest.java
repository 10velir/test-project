package com.itacademy.database.DAO.impl;

import com.itacademy.database.config.DatabaseConfig;
import com.itacademy.database.entity.Car;
import com.itacademy.database.repository.CarRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DatabaseConfig.class)
@Transactional
public class CarDaoTest {

    @Autowired
    private CarRepository carRepository;
/*
    @Test
    public void beanNotNullChecker() {
        assertNotNull(carRepository);
    }

    @Test
    public void saveCarChecker() {
        Car bmw = Car.builder()
                .model("X4")
                .supplier("BMW")
                .price(150)
                .build();

        assertNotNull(carRepository.save(bmw));
    }

    @Test
    public void updateCarChecker() {
        Car bmw = Car.builder()
                .model("X4")
                .supplier("BMW")
                .price(150)
                .build();

        assertNotNull(carRepository.save(bmw));
    }

    @Test
    public void getByIdChecker() {
        Optional<Car> carById = carRepository.findById(17L);
        assertNotEquals(carById, Optional.empty());
    }*/

    @Test
    public void getAllChecker() {
        List<Car> carList = (List<Car>) carRepository.findAll();
        assertNotNull(carList.size());
    }
}
