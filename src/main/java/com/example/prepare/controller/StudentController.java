package com.example.prepare.controller;

import com.example.prepare.dto.StudentDTO;
import com.example.prepare.entity.College;
import com.example.prepare.entity.Student;
import com.example.prepare.repository.specificationFilter.StudentSpecification;
import com.example.prepare.service.StudentService;
import com.example.prepare.service.impl.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService stuService;
    private final CollegeService collegeService;

    @Autowired
    public StudentController(StudentService stuService, CollegeService collegeService) {
        this.stuService = stuService;
        this.collegeService = collegeService;
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAll(@RequestParam(required = false) Long collegeId) {
        List<Student> studentList;
        if (collegeId != null) {
            studentList = stuService.getStudentByCollegeId(collegeId);
        } else {
            studentList = stuService.getAll();
        }


        List<StudentDTO> res = studentList.stream().map(StudentDTO::new).collect(Collectors.toList());
        System.out.println(res);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/multi")
    public List<Student> testSpecification(@RequestParam(required = false) String name,
                                           @RequestParam(required = false) Integer age,
                                           @RequestParam(required = false) Long collegeId) {
        College college = null;
        if (collegeId != null) college = collegeService.getCollegeById(collegeId);
        return stuService.getStudentByCriteria(name, age == null ? 0 : age, college);


    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable long id) {
        Student student = stuService.getStudentById(id);
        if (student == null) {
            return new ResponseEntity<>((StudentDTO) null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new StudentDTO(student), HttpStatus.OK);
    }

    @GetMapping("/byAge")
    public ResponseEntity<List<StudentDTO>> getStudentByAge(@RequestParam(name = "maxAge", required = false) Integer max, @RequestParam(name = "minAge", required = false) Integer min) {
        if (max == null) max = Integer.MAX_VALUE;
        if (min == null) min = Integer.MIN_VALUE;
        List<StudentDTO> res = stuService.getStudentByAge(min, max).stream().map(StudentDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@Validated @RequestBody StudentDTO dto, BindingResult br) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setInfo(dto.getInfo());
        if (dto.getCollegeId() != 0) {
            College collegeById = collegeService.getCollegeById(dto.getCollegeId());
            student.setCollege(collegeById);
        }
        student = stuService.addStudent(student);
        return new ResponseEntity<>(new StudentDTO(student), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO dto, @PathVariable long id) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setInfo(dto.getInfo());
        student.setId(id);
        student = stuService.updateStudent(student);
        return new ResponseEntity<>(new StudentDTO(student), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteStudentById(@PathVariable long id) {
        boolean flag = stuService.deleteStudentById(id);
        return new ResponseEntity<>(flag, HttpStatus.OK);
    }


    @GetMapping("/test2")
    public Student test2() {
        College collegeById = collegeService.getCollegeById(1);
        Student student = new Student("Charlie", 20, "ccc");
        student.setCollege(collegeById);
        return stuService.addStudent(student);
    }

    @GetMapping("/test")
    public List<Student> test() {
        Student student = new Student("Alice", 18, "aaa");
        stuService.addStudent(student);
        Student bob = new Student("Bob", 19, "bbb");
        stuService.addStudent(bob);
        return stuService.getAll();

    }


}
