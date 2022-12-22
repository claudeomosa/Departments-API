package com.claude.springbootapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
    @Id          //make departmentId the unique identifier of a Department entity
    @GeneratedValue(strategy = GenerationType.AUTO) //PK auto generated
    private long departmentId;
    @NotBlank(message = "Please add a name for the department")
    private String departmentName;
    private String departmentSchool;
    private String departmentCode;


}
