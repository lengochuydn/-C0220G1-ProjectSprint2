package com.codegym.service;

import com.codegym.dao.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface OrderService {
    Page<Order> findAllById_user(Integer id, Pageable pageable);
    Optional<Order> findById(Integer id);

    void save(Order order);
}
