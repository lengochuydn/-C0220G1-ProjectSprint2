package com.codegym.dao.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "transportation")
public class Transportation {
    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_transportation")
    private Integer id;
    @Column(name = "name_transportation")
    private String nameTransportation;

    public Transportation() {
    }

    public Transportation(Integer id, String nameTransportation) {
        this.id = id;
        this.nameTransportation = nameTransportation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameTransportation() {
        return nameTransportation;
    }

    public void setNameTransportation(String nameTransportation) {
        this.nameTransportation = nameTransportation;
    }
}
