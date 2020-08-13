package com.codegym.service.impl;

import com.codegym.dao.entity.TypeOfDistributor;
import com.codegym.dao.repository.TypeOfDistributorRepository;
import com.codegym.service.TypeOfDistributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeOfDistributorServiceImpl implements TypeOfDistributorService {
    @Autowired
    private TypeOfDistributorRepository typeOfDistributorRepository;
    @Override
    public TypeOfDistributor findByName(String name) {
        return typeOfDistributorRepository.findByName(name);
    }

    @Override
    public List<TypeOfDistributor> findAll() {
        return typeOfDistributorRepository.findAll();
    }
}
