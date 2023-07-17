package com.mahip.cruddemo.service;

import com.mahip.cruddemo.dao.EmployeeRepository;
import com.mahip.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl (EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int Id) {
        Optional<Employee> result = employeeRepository.findById(Id);
        Employee dbEmployee = null;
        if (result.isPresent()){
            dbEmployee = result.get();
        }else{
            throw new RuntimeException("cannot find employee by id " + Id);
        }
        return dbEmployee;
    }


    @Override
    public Employee save(Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }

    @Transactional
    @Override
    public void deleteById(int Id) {
         employeeRepository.deleteById(Id);
    }
}
