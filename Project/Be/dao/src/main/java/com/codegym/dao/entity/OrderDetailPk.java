package com.codegym.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class OrderDetailPk implements Serializable {

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private Order orderUser;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public OrderDetailPk() {

    }

    public Order getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(Order order_id) {
        this.orderUser = order_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product_id) {
        this.product = product_id;
    }
}
