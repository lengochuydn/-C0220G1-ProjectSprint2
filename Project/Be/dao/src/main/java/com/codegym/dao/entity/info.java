package com.codegym.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "info")
public class info {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @Column(name = "name")
    private String name;

    public info() {
    }

    public info(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
