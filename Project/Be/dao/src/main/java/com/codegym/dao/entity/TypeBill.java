package com.codegym.dao.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "type_bill")
public class TypeBill {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_bill")
    private Integer id;
    @Column(name = "name_type_bill")
    private String nameTypeBill;

    public TypeBill() {
    }

    public TypeBill(Integer id, String nameTypeBill) {
        this.id = id;
        this.nameTypeBill = nameTypeBill;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameTypeBill() {
        return nameTypeBill;
    }

    public void setNameTypeBill(String nameTypeBill) {
        this.nameTypeBill = nameTypeBill;
    }
}
