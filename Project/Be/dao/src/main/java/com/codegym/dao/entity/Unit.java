package com.codegym.dao.entity;

import javax.persistence.*;

@Entity
@Table(name="unit")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="unit_id")
    private Integer unitId;

    @Column(name="unit_name")
    private String unitName;

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }
}
