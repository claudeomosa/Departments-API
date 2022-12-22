package com.claude.springbootapi.service;

import com.claude.springbootapi.entity.Department;
import com.claude.springbootapi.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    public Department updateDepartment(Long departmentId, Department department) throws DepartmentNotFoundException;

    public Department fetchDepartmentByName(String departmentName);
}
