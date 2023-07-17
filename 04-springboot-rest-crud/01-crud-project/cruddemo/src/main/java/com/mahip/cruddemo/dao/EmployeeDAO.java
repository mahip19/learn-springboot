package com.mahip.cruddemo.dao;

import com.mahip.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int Id);

    Employee save(Employee newEmployee);

    void deleteById(int Id);

}
