package com.example.prepare.dto;

import com.example.prepare.entity.Employee;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeDTO {
    private List<Employee> data;
    private String status;

}
