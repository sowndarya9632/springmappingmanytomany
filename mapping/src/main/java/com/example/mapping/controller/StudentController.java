package com.example.mapping.controller;

import com.example.mapping.dto.StudentDto;
import com.example.mapping.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    public StudentServiceImpl studentserviceimpl;

    @PostMapping("/add")
    public StudentDto addStudent(@RequestBody StudentDto studentDto) {
        return  studentserviceimpl.addStudent(studentDto);
    }

}
