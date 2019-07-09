package com.itacademy.database.repository;

import com.itacademy.database.entity.ClientOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<ClientOrder, Long> {

    @Query(value = "SELECT * FROM rental_company.client_order where rental_company.client_order.client_id = :user_id",
            nativeQuery = true)
    List<ClientOrder> findByUserId(@Param("user_id") Long userId);
}
