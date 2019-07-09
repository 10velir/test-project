package com.itacademy.database.repository.implementation;

import com.itacademy.database.entity.User;
import com.itacademy.database.entity.User_;
import com.itacademy.database.fitler.UserSearchFilter;
import com.itacademy.database.repository.CustomUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CustomUserRepositoryImpl implements CustomUserRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> getWithFilters(UserSearchFilter searchFilter) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<User> criteria = cb.createQuery(User.class);
        Root<User> root = criteria.from(User.class);

        criteria.select(root);
        if (!searchFilter.getName().equals("")) {
            criteria.where(
                    cb.equal(root.get(User_.name), searchFilter.getName())
            );
        }
        if (!searchFilter.getLogin().equals("")) {
            criteria.where(
                    cb.equal(root.get(User_.login), searchFilter.getLogin())
            );
        }
        if (searchFilter.getBirthDate() != null) {
            criteria.where(
                    cb.equal(root.get(User_.birthDate), searchFilter.getBirthDate())
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
