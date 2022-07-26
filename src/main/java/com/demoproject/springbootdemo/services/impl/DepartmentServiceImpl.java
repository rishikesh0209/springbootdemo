package com.demoproject.springbootdemo.services.impl;
import com.demoproject.springbootdemo.exception.DepartmentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoproject.springbootdemo.model.Department;
import com.demoproject.springbootdemo.respository.DepartmentRepository;
import com.demoproject.springbootdemo.services.DepartmentService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    // public DepartmentServiceImpl(DepartmentRepository departmentRepository){
    //     super();
    //     this.departmentRepository = departmentRepository;
    // }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department =
                departmentRepository.findById(departmentId);

         if(!department.isPresent()) {
             throw new DepartmentNotFoundException("Department Not Available");
         }

        return  department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department depDB = departmentRepository.findById(departmentId).get();
        //check if object has values and its not null or blank
        if(Objects.nonNull(department.getDepartmentName()) &&
        !"".equalsIgnoreCase(department.getDepartmentName())) {
            depDB.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())) {
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(depDB);
    }

    // @Override
    // public Department fetchDepartmentByName(String departmentName) {
    //     // TODO Auto-generated method stub
    //     return departmentRepository.findByDepartmentName(departmentName);
    // }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}