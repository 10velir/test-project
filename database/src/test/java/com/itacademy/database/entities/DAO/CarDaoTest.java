package com.itacademy.database.entities.DAO;

import com.itacademy.database.DAO.impl.CarDao;
import com.itacademy.database.entities.Car;
import org.junit.FixMethodOrder;
import org.junit.Test;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@FixMethodOrder
public class CarDaoTest {

    public final CarDao carDao = CarDao.getInstance();

    @Test
    public void saveCarChecker() {
        Car bmw = Car.builder()
                .model("X4")
                .supplier("BMW")
                .price(150)
                .build();

        Serializable id = carDao.save(bmw);
        assertNotNull(id);
        System.out.println(bmw);
    }

    @Test
    public void updateCarChecker() {
        Car bmw = Car.builder()
                .model("X4")
                .supplier("BMW")
                .price(150)
                .build();

        Serializable id = carDao.save(bmw);
        assertNotNull(id);
        System.out.println(bmw);
    }

    @Test
    public void getByIdChecker() {
        Optional<Car> carById = carDao.getById(22);
        assertNotEquals(carById, Optional.empty());
        System.out.println(carById);
    }

    @Test
    public void getAllChecker() {
        List<Car> carList = carDao.getAll();
        assertNotNull(carList.size());
        System.out.println(carList.size());
    }
}
