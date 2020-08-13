package com.codegym.service;
import com.codegym.dao.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    List<Employee> findAllDeleted();
    Employee findById(int id);
    Employee findByAccountName(String accountName);
    void save(Employee employee);
    void remove(int id);
    Employee findByAccountId(int accountId);
}
