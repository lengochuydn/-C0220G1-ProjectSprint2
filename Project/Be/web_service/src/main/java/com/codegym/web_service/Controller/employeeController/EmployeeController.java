package com.codegym.web_service.Controller.employeeController;
import com.codegym.dao.DTO.AccessTimesDTO;
import com.codegym.dao.DTO.AddressCount;
import com.codegym.dao.DTO.EmployeeDTO;
import com.codegym.dao.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.codegym.dao.entity.*;
import com.codegym.service.AccountService;
import com.codegym.service.DepartmentService;
import com.codegym.service.EmployeeService;
import com.codegym.service.PositionService;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    PositionService positionService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    AccountService accountService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    EmployeeRepository employeeRepository;

    //return list of employee
    @RequestMapping(value = "/employee/list", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> listEmployeeAvailable() {
        List<Employee> employeeList = employeeService.findAll();
//        if(employeeList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//        return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
//        }
        return (employeeList.isEmpty()) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
    }

    //return an employee using id
    @GetMapping("employee/list/{id}")
    public ResponseEntity<?> findAvailableEmployee(@PathVariable int id) {
        Employee employee = employeeService.findById(id);
//        EmployeeDTO employeeDTO = new EmployeeDTO();
//        employeeDTO.setId(employee.getId());
//        employeeDTO.setImage(employee.getImage());
//        employeeDTO.setName(employee.getName());
//        employeeDTO.setGender(employee.getGender());
//        employeeDTO.setBirthday(employee.getBirthday());
//        employeeDTO.setAddress(employee.getAddress());
//        employeeDTO.setPhoneNumber(employee.getPhoneNumber());
//        employeeDTO.setEmail(employee.getEmail());
//        employeeDTO.setPosition(employee.getPosition().getName());
//        employeeDTO.setDepartment(employee.getDepartment().getName());
//        employeeDTO.setIdAccount(employee.getIdAccount());
        return employee != null ? new ResponseEntity<Employee>(employee, HttpStatus.OK) : new ResponseEntity<Object>(HttpStatus.NOT_FOUND);

    }

    // find an employee by their account name
    @GetMapping("employee/list/name/{acountName}")
    public ResponseEntity<?> findEmployeeByAccount(@PathVariable String acountName) {
        Employee employee = employeeService.findByAccountName(acountName);
        return employee != null ? new ResponseEntity<Employee>(employee, HttpStatus.OK) : new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
    }

    //edit an employee using id
    @RequestMapping(value = "employee/list/{id}", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> editEmployee(@PathVariable("id") int id, @RequestBody EmployeeDTO employeeDTO) {
        Employee employee1 = employeeService.findById(id);
        if (employee1 == null) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        employee1.setImage(employeeDTO.getImage());
        employee1.setName(employeeDTO.getName());
        employee1.setGender(employeeDTO.getGender());
        employee1.setBirthday(employeeDTO.getBirthday());
        employee1.setAddress(employeeDTO.getAddress());
        employee1.setPhoneNumber(employeeDTO.getPhoneNumber());
        employee1.setEmail(employeeDTO.getEmail());
        employee1.setPosition(positionService.findByPositionName(employeeDTO.getPosition()));
        employee1.setDepartment(departmentService.findByNameDepartment(employeeDTO.getDepartment()));
        employeeService.save(employee1);
        return new ResponseEntity<Employee>(employee1, HttpStatus.OK);
    }

    //edit account of employee using their account name
    @RequestMapping(value = "employee/account/name/{accountName}", method = RequestMethod.PATCH)
    public ResponseEntity<Account> editPassWordAccount(@PathVariable("accountName") String accountName, @RequestBody Account account) {
        Account account1 = accountService.findAccountByName(accountName);
        if (account1 == null) {
            return new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
        }
        account1.setAccountPassword(passwordEncoder.encode(account.getAccountPassword()));
        accountService.save(account1);
        return new ResponseEntity<Account>(account1, HttpStatus.OK);
    }

    //find account of employee by their account name
    @GetMapping("employee/account/name/{accountName}")
    public ResponseEntity<Account> findAccountByName(@PathVariable String accountName) {
        Account account = accountService.findAccountByName(accountName);
        return account != null ? new ResponseEntity<>(account, HttpStatus.OK) : new ResponseEntity<Account>(HttpStatus.NOT_FOUND);
    }

    //return the list of position
    @GetMapping("employee/position")
    public ResponseEntity<List<Position>> findAllPosition() {
        List<Position> positionList = positionService.findAll();
        return positionList.isEmpty() ? new ResponseEntity<List<Position>>(HttpStatus.NO_CONTENT) : new ResponseEntity<List<Position>>(positionList, HttpStatus.OK);
    }

    //return the list of department
    @GetMapping("employee/department")
    public ResponseEntity<List<Department>> findAllDepartment() {
        List<Department> departmentList = departmentService.findAll();
        return departmentList.isEmpty() ? new ResponseEntity<List<Department>>(HttpStatus.NO_CONTENT) : new ResponseEntity<List<Department>>(departmentList, HttpStatus.OK);
    }
}
