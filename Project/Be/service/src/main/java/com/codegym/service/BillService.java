package com.codegym.service;

import com.codegym.dao.entity.Bill;
import com.codegym.dao.entity.Brand;

import java.util.List;

public interface BillService {
    List<Bill> findAllByDeleteFlagFalse();
    Bill findById(Integer id);
    void save(Bill bill);
    void remove(Bill bill);
    boolean createBill(Bill bill);
}
