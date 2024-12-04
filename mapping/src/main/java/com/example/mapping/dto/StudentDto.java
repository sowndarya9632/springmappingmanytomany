package com.example.mapping.dto;

import com.example.mapping.entity.Course;
import com.example.mapping.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private Long id;
    private String name;
    private List<Course> course;
    //private List<Student>student;
}
