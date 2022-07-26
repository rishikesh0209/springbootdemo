package com.demoproject.springbootdemo.controller;

import java.util.List;

import com.demoproject.springbootdemo.exception.DepartmentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demoproject.springbootdemo.model.Department;
import com.demoproject.springbootdemo.services.DepartmentService;

//doc to refer  https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
@RestController
@RequestMapping("/api/v1")
public class DepartmentController {

    @Autowired // telling spring to auto wire the object so no need to initialise it again
               // using contructor
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartments(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchAllDepartments() {
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<Department> fetchDepartmentById(@PathVariable("id") Long deptId) throws DepartmentNotFoundException {
        Department dept= departmentService.fetchDepartmentById(deptId);
        // ResponseEntity.of(departmentService.fetchDepartmentById(deptId))
        return ResponseEntity.ok().body(dept);
    }

    @DeleteMapping("/departments/{id}")
    public String  deleteDepartmentById(@PathVariable("id") Long deptId) {
         departmentService.deleteDepartmentById(deptId);
         return "Department deleted Successfully!!";
    }

    @PutMapping("department/{id}")
    public Department updateDepartmentByID(@PathVariable("id") Long deptId,@RequestBody Department department){
        return departmentService.updateDepartment(deptId, department);
    }
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
