package com.example.prepare.service.impl;

import com.example.prepare.entity.College;
import com.example.prepare.repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollegeService {

    private final CollegeRepository repository;

    @Autowired
    public CollegeService(CollegeRepository repository) {
        this.repository = repository;
    }

    public College createCollege(College college) {
        return repository.save(college);
    }

    public College getCollegeById(long id) {
        Optional<College> res = repository.findById(id);
        return res.orElse(null);
    }

    public List<College> findAll() {
        return repository.findAll();
    }

}
