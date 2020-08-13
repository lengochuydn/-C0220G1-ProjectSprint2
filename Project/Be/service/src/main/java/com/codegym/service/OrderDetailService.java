package com.codegym.service;

import com.codegym.dao.entity.Order;
import com.codegym.dao.entity.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderDetailService {
   Page <OrderDetail> findByOrderUser(Order order, Pageable pageable);
}
