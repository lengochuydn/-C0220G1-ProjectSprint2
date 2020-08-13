package com.codegym.dao.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "order_user")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;
    @Column(name = "order_date")
    private LocalDateTime orderDate;
    @Column(name = "order_status")
    private String orderStatus;
    @Column(name = "order_address")
    private String orderAddress;
    @Column(name = "total_money")
    private double totalMoney;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    @OneToMany(mappedBy = "id.orderUser")
    @JsonManagedReference
    private List<OrderDetail> orderDetailList;

    public Order() {
    }

    public Order(int order_id, LocalDateTime order_date, String order_status, String order_address, double total_money, User id_user) {
        this.orderId = order_id;
        this.orderDate = order_date;
        this.orderStatus = order_status;
        this.orderAddress = order_address;
        this.totalMoney = total_money;
        this.user = id_user;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int order_id) {
        this.orderId = order_id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime order_date) {
        this.orderDate = order_date;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String order_status) {
        this.orderStatus = order_status;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String order_address) {
        this.orderAddress = order_address;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double total_money) {
        this.totalMoney = total_money;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User id_user) {
        this.user = id_user;
    }
}
