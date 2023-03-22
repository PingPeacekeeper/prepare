package com.example.prepare.service;

import com.example.prepare.entity.College;
import com.example.prepare.entity.Student;

import javax.transaction.Transactional;
import java.util.List;

public interface StudentService {

    List<Student> getAll();

    Student getStudentById(long id);

    List<Student> getStudentByAge(int min, int max);

    List<Student> getStudentByCollegeId(long id);

    List<Student> getStudentByCriteria(String name, int age, College college);

    Student addStudent(Student student);

    Student updateStudent(Student student);

    @Transactional
    boolean deleteStudentById(long id);

    List<Student> getStudentByName(String name);

    int updateInfoById(String info, long id);
}
