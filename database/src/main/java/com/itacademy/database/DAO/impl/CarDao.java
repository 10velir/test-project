package com.itacademy.database.DAO.impl;

import com.itacademy.database.DAO.BaseDao;
import com.itacademy.database.entities.Car;
import lombok.Cleanup;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

import static com.itacademy.database.util.SessionManager.getSession;

public class CarDao implements BaseDao<Integer, Car> {

    private static final CarDao INSTANSE = new CarDao();

    public static CarDao getInstance() {
        return INSTANSE;
    }

    public List<Car> getByModel(String model) {
        @Cleanup Session session = getSession();
        return session.createQuery("select c from Car c where model =: model", Car.class)
                .setParameter("model", model).list();
    }

    @Deprecated
    public Query<Car> getWithFilters(FilterSearch fs) {
        @Cleanup Session session = getSession();
        Query<Car> query = session.createQuery(String.format("select c from Car c where %s =: firstFilter ", fs.getField()), Car.class)
                .setParameter("firstFilter", fs.getParameter());
        return query;
    }
}
