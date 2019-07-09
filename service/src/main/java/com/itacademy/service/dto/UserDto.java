package com.itacademy.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private String name;
    private String birthDate;
    private String password;
    private String email;
    private String phoneNumber;
    private String city;
    private String Street;
}
