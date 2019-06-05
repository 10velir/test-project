package com.itacademy.database.DAO.impl;

import com.itacademy.database.DAO.BaseDao;
import com.itacademy.database.entities.Car;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.Cleanup;
import org.hibernate.Session;

import java.util.List;

import static com.itacademy.database.entities.QCar.car;
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

    public List<Car> getBySupplierAndMaxSpeed(String supplier, Integer maxSpeed) {

        @Cleanup Session session = getSession();
        return new JPAQuery<Car>(session)
                .select(car)
                .from(car)
                .where(car.supplier.eq(supplier), car.maxSpeed.eq(maxSpeed))
                .fetch();
    }

    public List<Car> getWithFilters(CarSearchFilter carSearchFilter) {

        @Cleanup Session session = getSession();
        JPAQuery<Car> queryWithFilters = new JPAQuery<>(session);

        if (carSearchFilter.getMaxSpeed() != null) {
            queryWithFilters.where(car.maxSpeed.eq(carSearchFilter.getMaxSpeed()));
        }
        if (carSearchFilter.getModel() != null) {
            queryWithFilters.where(car.model.eq(carSearchFilter.getModel()));
        }
        if (carSearchFilter.getSupplier() != null) {
            queryWithFilters.where(car.supplier.eq(carSearchFilter.getSupplier()));
        }
        if (carSearchFilter.getPrice() != null) {
            queryWithFilters.where(car.price.eq(carSearchFilter.getPrice()));
        }
        if (carSearchFilter.getLimit() != null) {
            queryWithFilters.limit(carSearchFilter.getLimit());
        }
        if (carSearchFilter.getOffset() != null) {
            queryWithFilters.offset(carSearchFilter.getOffset());
        }
        queryWithFilters
                .select(car)
                .from(car);
        return queryWithFilters.fetch();
    }
}