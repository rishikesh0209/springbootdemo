package com.demoproject.springbootdemo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demoproject.springbootdemo.exception.ResourceNotFoundException;
import com.demoproject.springbootdemo.model.Employee;
import com.demoproject.springbootdemo.respository.EmployeeRepository;
import com.demoproject.springbootdemo.services.EmployeeService;


// this implements employee service class
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        // TODO Auto-generated method stub
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id){
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }else{
            throw new ResourceNotFoundException("Employee","ID",id); 
        }
    }


    @Override
    public Employee updateEmployee(Long id,Employee employeeDataToUpdate){
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            Employee data= new Employee();
            data.setEmail(employeeDataToUpdate.getEmail());
            data.setFirstname(employeeDataToUpdate.getFirstname());
            data.setLastname(employeeDataToUpdate.getLastname());
            data.setId(employee.get().getId());
            return employeeRepository.save(data);

        }else{
            throw new ResourceNotFoundException("Employee","ID",id); 
        }
    }


    
}
