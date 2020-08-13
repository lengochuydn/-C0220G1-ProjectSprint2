package com.codegym.dao.repository;

import com.codegym.dao.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Integer> {
    List<Bill> findAllByDeleteFlagFalse();
}
