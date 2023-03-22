package com.example.prepare.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Employee {

    @JsonProperty(value = "id")
    private int id;
    @JsonProperty(value = "employee_name")
    private String name;
    @JsonProperty(value = "employee_salary")
    private int salary;
    @JsonProperty(value = "employee_age")
    private int age;
    @JsonProperty(value = "profile_image")
    private String image;

    public Employee(int id, String name, int salary, int age) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.age = age;
    }
}
