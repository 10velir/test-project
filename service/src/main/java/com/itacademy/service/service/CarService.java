package com.itacademy.service.service;

import com.itacademy.database.entity.Car;
import com.itacademy.database.fitler.CarSearchFilter;
import com.itacademy.database.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CarService {

    private final CarRepository carRepository;

    public List<Car> getWithFilters(CarSearchFilter searchFilter) {
        return carRepository.getWithFilters(searchFilter);
    }

    public Car getCarById(Integer id) {
        return carRepository.getById(id);
    }

    public List<Car> getAll() {
        return (List<Car>) carRepository.findAll();
    }
}
