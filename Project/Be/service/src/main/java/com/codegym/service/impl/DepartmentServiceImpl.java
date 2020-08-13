package com.codegym.service.impl;

import com.codegym.dao.entity.Department;
import com.codegym.dao.repository.DepartmentRepository;
import com.codegym.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;
    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findByNameDepartment(String name) {
        return departmentRepository.findByName(name);
    }
}
