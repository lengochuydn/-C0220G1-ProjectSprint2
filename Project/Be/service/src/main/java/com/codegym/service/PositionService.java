package com.codegym.service;

import com.codegym.dao.entity.Position;

import java.util.List;

public interface PositionService {
    List<Position> findAll();
    Position findByPositionName(String name);
}
