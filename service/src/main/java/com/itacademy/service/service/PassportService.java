package com.itacademy.service.service;

import com.itacademy.database.entity.Passport;
import com.itacademy.database.repository.PassportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PassportService {

    private final PassportRepository passportRepository;

    public List<Passport> getAll() {
        return passportRepository.findAll();
    }
}
