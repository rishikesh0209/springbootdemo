package com.demoproject.springbootdemo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoproject.springbootdemo.model.Employee;
import com.demoproject.springbootdemo.services.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    private EmployeeService employeeService;
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);
    
    public EmployeeController(EmployeeService employeeService){
        super();
        this.employeeService = employeeService;
    }

    //build create employee REST API
    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
        // return null;

    }

    @GetMapping()
    public List<Employee> getAllEmployees(){
        LOG.trace("This is a TRACE log");
        LOG.debug("This is a DEBUG log");
        LOG.info("This is an INFO log");
        LOG.error("This is an ERROR log");
        return employeeService.getAllEmployees();
    }

    @RequestMapping("/all/{id}")
    @GetMapping()
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long employeeId){
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
            
    }

    @RequestMapping("/{id}")
    @PutMapping()
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long employeeId,@RequestBody Employee employeeToUpdate){
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employeeId,employeeToUpdate), HttpStatus.OK);
            
    }
}
