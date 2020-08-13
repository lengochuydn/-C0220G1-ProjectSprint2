package com.codegym.service.impl;

import com.codegym.dao.entity.Position;
import com.codegym.dao.repository.PositionRepository;
import com.codegym.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    PositionRepository positionRepository;
    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public Position findByPositionName(String name) {
        return positionRepository.findByName(name);
    }
}
