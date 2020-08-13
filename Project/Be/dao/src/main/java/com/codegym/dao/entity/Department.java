package com.codegym.dao.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @Column(name = "department_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

//    @OneToMany(fetch = FetchType.LAZY,mappedBy = "department")
//    private List<Employee> employeeList;

    public Department() {
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
