package com.example.prepare.service.impl;

import com.example.prepare.entity.College;
import com.example.prepare.entity.Student;
import com.example.prepare.repository.StudentRepository;
import com.example.prepare.repository.specificationFilter.StudentSpecification;
import com.example.prepare.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;

    @Autowired
    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Student> getAll() {
        return repository.findAll();
    }

    @Override
    public Student getStudentById(long id) {
        Optional<Student> res = repository.findById(id);
        return res.orElse(null);
    }

    @Override
    public List<Student> getStudentByAge(int min, int max) {
        return repository.getStudentsByAgeBetween(min, max);
    }
    @Override
    public List<Student> getStudentByCollegeId(long id){
        return repository.findByCollege_Id(id);
    }

    @Override
    public List<Student> getStudentByCriteria(String name, int age, College college){
        Student filter = new Student();
        filter.setName(name);
        filter.setAge(age);
        filter.setCollege(college);
        Specification<Student> spec = new StudentSpecification(filter);
        return repository.findAll(spec);
    }

    @Override
    public Student addStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return repository.save(student);
    }

    @Transactional
    @Override
    public boolean deleteStudentById(long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }


    @Override
    public List<Student> getStudentByName(String name) {
        return repository.findByName(name);
    }

    @Override
    @Transactional
    public int updateInfoById(String info, long id) {
        return repository.updateInfoById(info, id);
    }


}
