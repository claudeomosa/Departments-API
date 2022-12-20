package com.claude.springbootapi.service;

import com.claude.springbootapi.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();
}
