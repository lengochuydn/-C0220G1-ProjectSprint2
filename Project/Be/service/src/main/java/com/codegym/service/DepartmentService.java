package com.codegym.service;

import com.codegym.dao.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> findAll();
    Department findByNameDepartment(String name);
}
