package com.example.mapping.entity;

import com.example.mapping.dto.CourseDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToMany
    private List<Student> students;

    public Course(CourseDto courseDto) {
        this.title=courseDto.getTitle();
        this.students=courseDto.getStudents();
    }
}
