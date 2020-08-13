package com.codegym.dao.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "order_detail")
public class OrderDetail {

    @EmbeddedId
    private OrderDetailPk id;

    @Column(name = "order_quantity")
    private int orderQuantity;

    public OrderDetail() {
    }

    public OrderDetailPk getId() {
        return id;
    }

    public void setId(OrderDetailPk id) {
        this.id = id;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int order_quantity) {
        this.orderQuantity = order_quantity;
    }
}
