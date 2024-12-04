package com.example.mapping.controller;

import com.example.mapping.dto.CourseDto;
import com.example.mapping.service.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    CourseServiceImpl courseServiceimpl;
    @PostMapping("/add")
    public CourseDto addCourse(@RequestBody CourseDto courseDto){
        return courseServiceimpl.addCourse(courseDto);
    }

    @PatchMapping("/{courseId}/students/{studentId}")
    public CourseDto addStudentToCourse(@PathVariable long studentId, @PathVariable long courseId) {
        return courseServiceimpl.addStudentToCourse(studentId,courseId);
    }
}
