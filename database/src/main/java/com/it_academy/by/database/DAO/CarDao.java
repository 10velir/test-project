package com.it_academy.by.database.DAO;

import java.sql.SQLException;

public interface CarDao extends DAO<Car>{
    Car getByModel(String model) throws SQLException;
}
