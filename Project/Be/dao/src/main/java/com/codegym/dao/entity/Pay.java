package com.codegym.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "pay")
public class Pay {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_pay")
    private Integer id;
    @Column(name = "name_pay")
    private String namePay;

    public Pay() {
    }

    public Pay(Integer id, String namePay) {
        this.id = id;
        this.namePay = namePay;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNamePay() {
        return namePay;
    }

    public void setNamePay(String namePay) {
        this.namePay = namePay;
    }
}
