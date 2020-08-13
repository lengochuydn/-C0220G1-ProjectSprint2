package com.codegym.dao.repository;

import com.codegym.dao.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    Department findByName(String name);
}
