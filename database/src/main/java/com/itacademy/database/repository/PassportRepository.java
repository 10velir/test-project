package com.itacademy.database.repository;

import com.itacademy.database.entity.Passport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PassportRepository extends JpaRepository<Passport, Long> {
}
