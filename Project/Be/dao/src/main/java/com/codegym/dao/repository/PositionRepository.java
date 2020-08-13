package com.codegym.dao.repository;

import com.codegym.dao.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Integer> {
    Position findByName( String name);
}
