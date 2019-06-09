package com.itacademy.database.repository;

import com.itacademy.database.entity.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
