package com.itacademy.web.exeption;

public class DaoExeption extends RuntimeException {

    public DaoExeption() {

    }

    public DaoExeption(String message) {
        super(message);
    }
}
