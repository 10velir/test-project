package com.itacademy.service.service;

import com.itacademy.database.entity.Address;
import com.itacademy.database.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class AddressService {

    private final AddressRepository addressRepository;

    public List<Address> getAll() {
        return addressRepository.findAll();
    }
}
