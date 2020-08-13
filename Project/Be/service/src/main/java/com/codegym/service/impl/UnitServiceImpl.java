package com.codegym.service.impl;

import com.codegym.dao.entity.Unit;
import com.codegym.dao.repository.UnitRepository;
import com.codegym.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitServiceImpl implements UnitService {
    @Autowired
    private UnitRepository unitRepository;
    @Override
    public List<Unit> findAll() {
        return unitRepository.findAll();
    }
}
