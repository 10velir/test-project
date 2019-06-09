package com.itacademy.database.fitler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserSearchFilter {

    private String name;
    private String login;
    private String email;
    private String phoneNumber;
    private LocalDate birthDate;
    private Integer limit;
    private Integer offset;
}
