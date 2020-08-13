package com.codegym.service;

import com.codegym.dao.entity.WareHouse;

import java.util.List;

public interface WareHouseService {
    List<WareHouse> findAll();

    WareHouse findById(Integer id);

    void save(WareHouse wareHouse);

//    void remove(Long id);
}
