package com.codegym.dao.repository;

import com.codegym.dao.entity.Rule;
import com.codegym.dao.entity.StorageLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StorageLocationRepository extends JpaRepository<StorageLocation, Integer> {
}
