package com.codegym.dao.repository;

import com.codegym.dao.entity.Pay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayRepository extends JpaRepository<Pay,Integer> {
}
