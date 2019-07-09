package com.itacademy.database.repository.implementation;

import com.itacademy.database.entity.Car;
import com.itacademy.database.entity.Car_;
import com.itacademy.database.fitler.CarSearchFilter;
import com.itacademy.database.repository.CustomCarRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CustomCarRepositoryImpl implements CustomCarRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Car> getWithFilters(CarSearchFilter searchFilter) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Car> criteria = cb.createQuery(Car.class);
        Root<Car> root = criteria.from(Car.class);
        criteria.select(root);

        if (!searchFilter.getSupplier().equals("")) {
            criteria.where(
                    cb.equal(root.get(Car_.supplier), searchFilter.getSupplier())
            );
        }
        if (!searchFilter.getModel().equals("")) {
            criteria.where(
                    cb.equal(root.get(Car_.model), searchFilter.getModel())
            );
        }
        if (searchFilter.getMaxSpeed() != null) {
            criteria.where(
                    cb.equal(root.get(Car_.maxSpeed), searchFilter.getMaxSpeed())
            );
        }
        if (searchFilter.getPrice() != null) {
            criteria.where(
                    cb.equal(root.get(Car_.price), searchFilter.getPrice())
            );
        }
        if (searchFilter.getLimit() != null && searchFilter.getOffset() != null) {
            return entityManager.createQuery(criteria)
                    .setMaxResults(searchFilter.getLimit())
                    .setFirstResult(searchFilter.getOffset())
                    .getResultList();
        }

        return entityManager.createQuery(criteria).getResultList();
    }
}
