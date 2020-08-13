package com.codegym.dao.repository;

import com.codegym.dao.entity.Rule;
import com.codegym.dao.entity.TypeBill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeBillRepository extends JpaRepository<TypeBill, Integer> {
}
