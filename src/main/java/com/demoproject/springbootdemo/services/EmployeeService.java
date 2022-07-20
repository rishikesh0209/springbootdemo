package com.demoproject.springbootdemo.services;

import java.util.List;

import com.demoproject.springbootdemo.model.Employee;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);
    Employee updateEmployee(Long id,Employee employeeDataToUpdate);
}
