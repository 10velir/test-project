package com.itacademy.database.fitler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarSearchFilter {

    private String supplier;
    private String model;
    private Integer maxSpeed;
    private Integer price;
    private Integer limit = 15;
    private Integer offset = 0;
}