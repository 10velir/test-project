package com.itacademy.database.repository;

import com.itacademy.database.entity.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
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

    @Query(value = "SELECT * FROM rental_company.car where rental_company.car.id= :carId",
            nativeQuery = true)
    Car getById(@Param("carId") Integer carId);

    @Query(value = "INSERT INTO rental_conpany.car_user (carId, userId) VALUES (= :carId, = :userId)",
            nativeQuery = true)
    void createOrder(@Param("carId") Integer carId, @Param("userId") Long userId);
}
