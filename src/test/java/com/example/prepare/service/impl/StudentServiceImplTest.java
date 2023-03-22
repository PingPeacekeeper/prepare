package com.example.prepare.service.impl;

import com.example.prepare.entity.Student;
import com.example.prepare.repository.StudentRepository;
import com.example.prepare.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceImplTest {


    @Autowired
    StudentService service;

    @BeforeEach
    void setUp() {
        service.addStudent(new Student("Alice",18,"AAA"));
        service.addStudent(new Student("Bob",18,"BBB"));
        service.addStudent(new Student("Charlie",18,"CCC"));
    }

    @Test
    void getStudentByName() {
        System.out.println(service.getStudentByName("Bob"));
        System.out.println(service.getStudentByName("David"));
        service.updateInfoById("new info",1);
        System.out.println(service.getStudentById(1));

    }
}