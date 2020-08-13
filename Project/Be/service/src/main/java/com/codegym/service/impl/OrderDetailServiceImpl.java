package com.codegym.service.impl;

import com.codegym.dao.entity.Order;
import com.codegym.dao.entity.OrderDetail;
import com.codegym.dao.repository.OrderDetailRepository;
import com.codegym.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class OrderDetailServiceImpl  implements OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Override
    public Page<OrderDetail> findByOrderUser(Order order, Pageable pageable) {
        return orderDetailRepository.findAllById_OrderUser(order, pageable);
    }
}
