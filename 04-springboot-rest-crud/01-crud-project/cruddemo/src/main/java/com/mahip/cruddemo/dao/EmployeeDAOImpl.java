package com.mahip.cruddemo.dao;

import com.mahip.cruddemo.entity.Employee;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

//    define fields for entitymanager
        private EntityManager entityManager;
//    contructor injection
    @Autowired
    public EmployeeDAOImpl (EntityManager entityManager){
        this.entityManager = entityManager;
    }



    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int Id) {
        Employee employee = entityManager.find(Employee.class, Id);
        return employee;
    }

    @Override
    public Employee save(Employee newEmployee) {
        Employee dbEmployee = entityManager.merge(newEmployee);
        return dbEmployee;
    }

    @Override
    public void deleteById(int Id) {
        Employee employee = entityManager.find(Employee.class, Id);
        entityManager.remove(employee);
    }
}
