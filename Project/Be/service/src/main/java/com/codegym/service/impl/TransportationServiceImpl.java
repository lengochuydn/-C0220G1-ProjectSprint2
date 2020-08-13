package com.codegym.service.impl;

import com.codegym.dao.entity.Transportation;
import com.codegym.dao.repository.TransportationRepository;
import com.codegym.service.TransportationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TransportationServiceImpl implements TransportationService {
    @Autowired
    private TransportationRepository transportationRepository;

    @Override
    public List<Transportation> findAll() {
        return transportationRepository.findAll();
    }

    @Override
    public Transportation findById(Integer id) {
        return transportationRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Transportation transportation) {
        transportationRepository.save(transportation);
    }
}
