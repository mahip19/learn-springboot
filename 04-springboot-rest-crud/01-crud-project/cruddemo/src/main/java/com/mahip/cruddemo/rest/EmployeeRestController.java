package com.mahip.cruddemo.rest;

import com.mahip.cruddemo.dao.EmployeeDAO;
import com.mahip.cruddemo.entity.Employee;
import com.mahip.cruddemo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService= employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

//    add mapping for /employees/{empId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if (employee == null) throw new RuntimeException("employee not found - " + employeeId);
        return employee;
    }

//    add mapping for /employees - post
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

//    adding mapping for /employees - put
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee dbEmployee = employeeService.save(employee);
        return dbEmployee;
    }

//    add mapping for /eployees/employeeId - delete
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee employee_to_be_deleted = employeeService.findById(employeeId);
        if (employee_to_be_deleted == null) throw new RuntimeException("employee does not exists " + employeeId);

        employeeService.deleteById(employeeId);
        return "deleted employee id: " + employeeId;
    }
}
