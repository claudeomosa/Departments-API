package com.claude.springbootapi.service;

import com.claude.springbootapi.entity.Department;
import com.claude.springbootapi.error.DepartmentNotFoundException;
import com.claude.springbootapi.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;
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
        Optional<Department> department =  departmentRepository.findById(departmentId);
        if(!department.isPresent()) {
            throw new DepartmentNotFoundException("Department with id: " + departmentId + " Not Available!");
        }
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department =  departmentRepository.findById(departmentId);
        if(!department.isPresent()) {
            throw new DepartmentNotFoundException("Cannot delete department with id: " + departmentId + ", Department Not Available!");
        }
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) throws DepartmentNotFoundException {
//        first find the department to be updated using the departmentId, then check that the field in the update body are not null or empty then update according to the provided body
        Optional<Department> departmentDB = departmentRepository.findById(departmentId);
        if (!departmentDB.isPresent()){
            throw new DepartmentNotFoundException("Cannot update department with id: " + departmentId + ", Department Not Available!");
        }

            if (Objects.nonNull(department.getDepartmentName()) &&
                    !"".equalsIgnoreCase(department.getDepartmentName())) {
                departmentDB.get().setDepartmentName(department.getDepartmentName());
            }
            if (Objects.nonNull(department.getDepartmentSchool()) &&
                    !"".equalsIgnoreCase(department.getDepartmentSchool())) {
                departmentDB.get().setDepartmentSchool(department.getDepartmentSchool());
            }
            if (Objects.nonNull(department.getDepartmentCode()) &&
                    !"".equalsIgnoreCase(department.getDepartmentCode())) {
                departmentDB.get().setDepartmentCode(department.getDepartmentCode());
            }

        return departmentRepository.save(departmentDB.get());
    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
