package com.codegym.service;

import com.codegym.dao.entity.TypeOfDistributor;

import java.util.List;

public interface TypeOfDistributorService {
    TypeOfDistributor findByName(String name);
    List<TypeOfDistributor> findAll();
}
