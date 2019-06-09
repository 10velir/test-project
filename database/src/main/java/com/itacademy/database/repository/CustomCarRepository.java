package com.itacademy.database.repository;

import com.itacademy.database.entity.Car;
import com.itacademy.database.fitler.CarSearchFilter;

import java.util.List;

public interface CustomCarRepository {

    List<Car> getWithFilters(CarSearchFilter searchFilter);
}
