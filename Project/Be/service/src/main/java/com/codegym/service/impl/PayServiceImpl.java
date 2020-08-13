package com.codegym.service.impl;

import com.codegym.dao.entity.Pay;
import com.codegym.dao.repository.PayRepository;
import com.codegym.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayServiceImpl implements PayService {
    @Autowired
    private PayRepository payRepository;
    @Override
    public List<Pay> findAll() {
        return payRepository.findAll();
    }

    @Override
    public Pay findById(Integer id) {
        return payRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Pay pay) {
        payRepository.save(pay);
    }
}
