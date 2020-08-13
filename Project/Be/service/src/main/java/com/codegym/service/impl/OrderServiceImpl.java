package com.codegym.service.impl;

import com.codegym.dao.entity.Order;
import com.codegym.dao.repository.OrderRepository;
import com.codegym.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Override
    public Page<Order> findAllById_user(Integer id, Pageable pageable) {
        return orderRepository.findAllByIdUser(id,pageable);

    }

    @Override
    public Optional<Order> findById(Integer id) {
        return orderRepository.findById(id);
    }

    @Override
    public void save(Order order) {
orderRepository.save(order);
    }
//    haiz
}
