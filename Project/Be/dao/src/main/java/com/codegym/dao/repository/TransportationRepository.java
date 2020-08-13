package com.codegym.dao.repository;

import com.codegym.dao.entity.Rule;
import com.codegym.dao.entity.Transportation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportationRepository extends JpaRepository<Transportation, Integer> {
}
