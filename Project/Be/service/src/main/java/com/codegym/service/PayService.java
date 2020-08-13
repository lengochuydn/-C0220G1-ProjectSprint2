package com.codegym.service;

import com.codegym.dao.entity.Pay;

import java.util.List;

public interface PayService {
    List<Pay> findAll();

    Pay findById(Integer id);

    void save(Pay pay);

//    void remove(Long id);
}
