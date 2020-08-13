package com.codegym.service;

import com.codegym.dao.entity.TypeBill;

import java.util.List;

public interface TypeBillService {
    List<TypeBill> findAll();

    TypeBill findById(Integer id);

    void save(TypeBill typeBill);

//    void remove(Long id);
}
