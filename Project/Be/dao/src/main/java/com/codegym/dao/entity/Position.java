package com.codegym.dao.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "position")
public class Position {
    @Id
    @Column(name = "position_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

//    @OneToMany(fetch = FetchType.LAZY,mappedBy = "position")
//    private List<Employee> employees;


    public Position() {
    }

    public Position(int id, String name) {
        this.id = id;
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
