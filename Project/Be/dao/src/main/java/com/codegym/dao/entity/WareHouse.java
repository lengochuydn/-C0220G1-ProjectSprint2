package com.codegym.dao.entity;

import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "ware_house")
public class WareHouse {
    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_ware_house")
    private Integer id;
    @Column(name = "name_ware_house")
    private String nameWareHouse;

    public WareHouse() {
    }

    public WareHouse(Integer id, String nameWareHouse) {
        this.id = id;
        this.nameWareHouse = nameWareHouse;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameWareHouse() {
        return nameWareHouse;
    }

    public void setNameWareHouse(String nameWareHouse) {
        this.nameWareHouse = nameWareHouse;
    }
}
