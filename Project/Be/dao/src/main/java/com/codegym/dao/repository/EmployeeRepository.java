package com.codegym.dao.repository;
import java.util.List;

import com.codegym.dao.DTO.AddressCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.codegym.dao.entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAllByDeleteFlagIsFalse();

    List<Employee> findAllByDeleteFlagIsTrue();

    Employee findByDeleteFlagIsFalseAndId(Integer id);

    Employee findByAccount_AccountIdAndDeleteFlagIsFalse(int accountId);

    Employee findByAccount_AccountName(String accountName);
}
