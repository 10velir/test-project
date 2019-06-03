package com.itacademy.service;

import com.itacademy.database.DAO.impl.CarDao;
import com.itacademy.database.DAO.impl.FilterSearch;
import com.itacademy.database.entities.Car;

public class UserService {

    private static final UserService INSTANCE = new UserService();

    public final CarDao carDao = CarDao.getInstance();

     public Car getByModel(String model){
        try {
            return carDao.getByModel(model).get(0);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } return null;
    }

    public FilterSearch createFilter(String field, String parameter) {
         FilterSearch filterSearch = new FilterSearch();
         filterSearch.setField(field);
         filterSearch.setParameter(parameter);
         return filterSearch;
    }

    public Car getWithFilters(String firstFilter, String firstParam) {
         return carDao.getWithFilters(createFilter(firstFilter, firstParam)).getSingleResult();
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
