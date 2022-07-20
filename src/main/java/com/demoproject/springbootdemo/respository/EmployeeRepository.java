package com.demoproject.springbootdemo.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demoproject.springbootdemo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{
    
}
