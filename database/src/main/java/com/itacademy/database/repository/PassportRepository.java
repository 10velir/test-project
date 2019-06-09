package com.itacademy.database.repository;

import com.itacademy.database.entity.Passport;
import org.springframework.data.repository.CrudRepository;

public interface PassportRepository extends CrudRepository<Passport, Long> {
}
