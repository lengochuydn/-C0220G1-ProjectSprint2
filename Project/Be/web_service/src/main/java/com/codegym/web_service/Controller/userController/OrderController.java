package com.codegym.web_service.Controller.userController;

import com.codegym.dao.entity.Order;
import com.codegym.dao.entity.OrderDetail;
import com.codegym.service.OrderDetailService;
import com.codegym.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController

@CrossOrigin(origins = "*", allowedHeaders = "*")

public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderDetailService orderDetailService;

    @RequestMapping(value = "/user-order/{id}", method = RequestMethod.GET)
    public ResponseEntity<Page<Order>> getUserOder(@PathVariable Integer id, Pageable pageable) {
        Page<Order> orders = orderService.findAllById_user(id, pageable);
        if (orders.getContent().isEmpty()) {
            System.out.println("Order with id " + id + " not found");
            return new ResponseEntity<>(orders, HttpStatus.NOT_FOUND);
        } else
            return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public ResponseEntity<Order> getOrder(@PathVariable Integer id) {
        Optional<Order> order = orderService.findById(id);
        if (!order.isPresent()) {
            System.out.println("Order with id " + id + " not found");
            return new ResponseEntity<>(order.get(), HttpStatus.NOT_FOUND);
        } else
            return new ResponseEntity<>(order.get(), HttpStatus.OK);
    }

    @RequestMapping(value = "/order-detail/{id}", method = RequestMethod.GET)
    public ResponseEntity<Page<OrderDetail>> getOrderDetail(@PathVariable Integer id, Pageable pageable) {
        Optional<Order> order = orderService.findById(id);
        Page<OrderDetail> orderDetailList = orderDetailService.findByOrderUser(order.get(), pageable);
        return new ResponseEntity<>(orderDetailList, HttpStatus.OK);
    }

    @RequestMapping(value = "/order-cancel/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Order> cancelOrder(@PathVariable Integer id) {
        Optional<Order> currentOrder = orderService.findById(id);
        if (!currentOrder.isPresent()) {
            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
        } else {
            currentOrder.get().setOrderStatus("Đã hủy");
            orderService.save(currentOrder.get());
            return new ResponseEntity<Order>(currentOrder.get(), HttpStatus.OK);
        }

    }
}
