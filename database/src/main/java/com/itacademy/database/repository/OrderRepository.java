package com.itacademy.database.repository;

import com.itacademy.database.entity.ClientOrder;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository extends PagingAndSortingRepository<ClientOrder, Long> {
}
