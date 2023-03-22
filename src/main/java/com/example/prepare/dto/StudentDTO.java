package com.example.prepare.dto;

import com.example.prepare.entity.Student;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentDTO {
    private long id;
    private String name;
    private int age;
    private String Info;
    private Long collegeId;

    public StudentDTO(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.age = student.getAge();
        this.Info = student.getInfo();
        if (student.getCollege() != null) {
            this.collegeId = student.getCollege().getId();
        }

    }

}
