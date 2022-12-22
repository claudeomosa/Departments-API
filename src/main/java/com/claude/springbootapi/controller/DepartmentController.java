package com.claude.springbootapi.controller;

import com.claude.springbootapi.entity.Department;
import com.claude.springbootapi.error.DepartmentNotFoundException;
import com.claude.springbootapi.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

//    to handle post requests
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

//    to handle get requests
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return departmentService.fetchDepartmentList();
    }
//   to handle get requests with ID in the request parameters
    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId )
            throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(departmentId);
    }

//    to handle delete requests with ID in the path variable
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId)
            throws DepartmentNotFoundException{
        departmentService.deleteDepartmentById(departmentId);
        return "successfully deleted department";
    }

//    to handle update request with ID and the body
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department){
        return departmentService.updateDepartment(departmentId, department);
    }

//    to handle get request using name passed in the path variable

    @GetMapping("/departments/department/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }
}
