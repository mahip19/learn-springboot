package com.mahip.cruddemo.service;

import com.mahip.cruddemo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int Id);

    Employee save(Employee newEmployee);

    void deleteById(int Id);
}
