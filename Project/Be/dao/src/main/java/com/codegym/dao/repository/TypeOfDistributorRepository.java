package com.codegym.dao.repository;

import com.codegym.dao.entity.TypeOfDistributor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeOfDistributorRepository extends JpaRepository<TypeOfDistributor,Integer> {
    TypeOfDistributor findByName(String name);
}
