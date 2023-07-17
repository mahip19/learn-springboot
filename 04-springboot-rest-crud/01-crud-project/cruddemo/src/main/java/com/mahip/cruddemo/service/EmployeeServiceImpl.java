package com.mahip.cruddemo.service;

import com.mahip.cruddemo.dao.EmployeeDAO;
import com.mahip.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDAO employeeDAO;
    @Autowired
    public EmployeeServiceImpl (EmployeeDAO employeeDAO){
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int Id) {
        return employeeDAO.findById(Id);
    }

    @Transactional
    @Override
    public Employee save(Employee newEmployee) {
        return employeeDAO.save(newEmployee);
    }

    @Transactional
    @Override
    public void deleteById(int Id) {
         employeeDAO.deleteById(Id);
    }
}
