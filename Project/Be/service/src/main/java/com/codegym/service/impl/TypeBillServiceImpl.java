package com.codegym.service.impl;

import com.codegym.dao.entity.TypeBill;
import com.codegym.dao.repository.TypeBillRepository;
import com.codegym.service.TypeBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeBillServiceImpl implements TypeBillService {
    @Autowired
    private TypeBillRepository typeBillRepository;
    @Override
    public List<TypeBill> findAll() {
        return typeBillRepository.findAll();
    }

    @Override
    public TypeBill findById(Integer id) {
        return typeBillRepository.findById(id).orElse(null);
    }

    @Override
    public void save(TypeBill typeBill) {
        typeBillRepository.save(typeBill);
    }
}
