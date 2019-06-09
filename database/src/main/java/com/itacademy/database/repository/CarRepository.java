package com.itacademy.database.repository;

import com.itacademy.database.entity.Car;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CarRepository extends PagingAndSortingRepository<Car, Long>, CustomCarRepository {

    List<Car> getAllByModel(String model);

    List<Car> getAllByModelAndSupplier(String model, String supplier);

    List<Car> getAllByMaxSpeed(Integer maxSpeed);

    List<Car> getAllByPrice(Integer price);

    List<Car> getAllByPriceOrderByMaxSpeedAsc(Integer price);

    List<Car> getAllBySupplierOrderByPriceAsc(String supplier);
}
