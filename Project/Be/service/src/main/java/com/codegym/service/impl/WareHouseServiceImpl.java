package com.codegym.service.impl;

import com.codegym.dao.entity.WareHouse;
import com.codegym.dao.repository.WareHouseRepository;
import com.codegym.service.WareHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WareHouseServiceImpl implements WareHouseService {
    @Autowired
    private WareHouseRepository wareHouseRepository;
    @Override
    public List<WareHouse> findAll() {
        return wareHouseRepository.findAll();
    }

    @Override
    public WareHouse findById(Integer id) {
        return wareHouseRepository.findById(id).orElse(null);
    }

    @Override
    public void save(WareHouse wareHouse) {
        wareHouseRepository.save(wareHouse);
    }
}
