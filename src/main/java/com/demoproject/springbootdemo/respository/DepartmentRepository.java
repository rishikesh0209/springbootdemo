package com.demoproject.springbootdemo.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demoproject.springbootdemo.model.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    //custom query
    //findBy with department name is a naming convention
    public Department findByDepartmentName(String departmentName);

    public Department findByDepartmentNameIgnoreCase(String departmentName);
}
