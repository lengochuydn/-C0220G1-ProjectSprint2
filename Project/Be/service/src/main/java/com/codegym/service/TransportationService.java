package com.codegym.service;

import com.codegym.dao.entity.Transportation;

import java.util.List;

public interface TransportationService {
    List<Transportation> findAll();

    Transportation findById(Integer id);

    void save(Transportation transportation);

//    void remove(Integer id);
}
