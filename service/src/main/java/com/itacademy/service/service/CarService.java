package com.itacademy.service.service;

import com.itacademy.database.entity.Car;
import com.itacademy.database.fitler.CarSearchFilter;
import com.itacademy.database.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CarService {

    private CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getWithFilters(CarSearchFilter searchFilter) {
       return carRepository.getWithFilters(searchFilter);
    }

    public List<Car> getAll() {
        return (List<Car>) carRepository.findAll();
    }
}
