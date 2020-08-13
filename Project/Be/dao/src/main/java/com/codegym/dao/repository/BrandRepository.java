package com.codegym.dao.repository;

import com.codegym.dao.entity.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    List<Brand> findAllByDeleteFlagFalse();
    Page<Brand> findAllByBrandNameContainingAndDeleteFlagFalse(Pageable pageable, String search);
}
