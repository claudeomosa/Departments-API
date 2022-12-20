package com.claude.springbootapi.controller;

import com.claude.springbootapi.entity.Department;
import com.claude.springbootapi.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

//    to handle post requests
    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

//    to handle get requests
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }
//   to handle get requests with ID in the request parameters
    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId ){
        return departmentService.fetchDepartmentById(departmentId);
    }

//    to handle delete requests with ID in the path variable
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "successfully deleted department";
    }
}
