package com.claude.springbootapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Department {
    @Id          //make departmentId the unique identifier of a Department entity
    @GeneratedValue(strategy = GenerationType.AUTO) //PK auto generated
    private long departmentId;
    private String departmentName;
    private String departmentSchool;
    private String departmentCode;

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentSchool() {
        return departmentSchool;
    }

    public void setDepartmentSchool(String departmentSchool) {
        this.departmentSchool = departmentSchool;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public Department(long departmentId, String departmentName, String departmentSchool, String departmentCode) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentSchool = departmentSchool;
        this.departmentCode = departmentCode;
    }

    public Department() {
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", departmentSchool='" + departmentSchool + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                '}';
    }
}
