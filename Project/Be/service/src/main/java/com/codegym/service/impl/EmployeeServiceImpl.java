package com.codegym.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.codegym.dao.entity.Employee;
import com.codegym.dao.repository.EmployeeRepository;
import com.codegym.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllByDeleteFlagIsFalse();
    }

    @Override
    public List<Employee> findAllDeleted() {
        return employeeRepository.findAllByDeleteFlagIsTrue();
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findByDeleteFlagIsFalseAndId(id);
    }

    @Override
    public Employee findByAccountName(String accountName) {
        return employeeRepository.findByAccount_AccountName(accountName);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void remove(int id) {
        Employee employee = employeeRepository.findByDeleteFlagIsFalseAndId(id);
        employee.setDeleteFlag(true);
    }

    @Override
    public Employee findByAccountId(int accountId) {
        return employeeRepository.findByAccount_AccountIdAndDeleteFlagIsFalse(accountId);
    }
}
