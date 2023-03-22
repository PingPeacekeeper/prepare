package com.example.prepare.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    public Student(String name, int age, String info) {
        this.name = name;
        this.age = age;
        Info = info;
    }

    @Column
    private String name;

    @Column
    private int age;

    @Column
    private String Info;

    @ManyToOne()
    @JoinColumn(name = "cid")
    private College college;

}
