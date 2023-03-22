package com.example.prepare.controller;

import com.example.prepare.entity.College;
import com.example.prepare.service.impl.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/college")
public class CollegeController {

    private final CollegeService service;


    @Autowired
    public CollegeController(CollegeService service) {
        this.service = service;
    }


    @GetMapping("/{id}")
    public ResponseEntity<College> getCollegeById(@PathVariable long id) {
        return new ResponseEntity<>(service.getCollegeById(id), HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<College> createCollege(@RequestBody College college) {
        College college1 = service.createCollege(college);
        return new ResponseEntity<>(college1, HttpStatus.OK);
    }

    @GetMapping("/test")
    public List<College> test() {
        College c = new College(null, "c1", null);
        service.createCollege(c);
        College c2 = new College(null, "c2", null);
        service.createCollege(c2);
        return service.findAll();
    }
}

