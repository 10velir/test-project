package com.itacademy.service.service;

import com.itacademy.database.entity.Car;
import com.itacademy.database.fitler.CarSearchFilter;
import com.itacademy.database.repository.CarRepository;
import com.itacademy.service.dto.CarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.OptimisticLockException;
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

    public Page<Car> getAll(Integer page) {
        return carRepository.findAll(PageRequest.of(page, 9));
    }

    @Transactional
    public Car mapDtoToCar(CarDto dto, Car car) throws OptimisticLockException {
        if (dto.getMaxSpeedDto() != null) {
            car.setMaxSpeed(dto.getMaxSpeedDto());
        }
        if (!dto.getModelDto().equals("")) {
            car.setModel(dto.getModelDto());
        }
        if (dto.getPriceDto() != null) {
            car.setPrice(dto.getPriceDto());
        }
        if (!dto.getSupplierDto().equals("")) {
            car.setSupplier(dto.getSupplierDto());
        }
        try {
            return carRepository.save(car);
        } catch (OptimisticLockException lockEx) {
            throw lockEx;
        }
    }

    public List<Car> getAll() {
        return (List<Car>) carRepository.findAll();
    }
}
