package com.example.mapping.entity;

import com.example.mapping.dto.StudentDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "students")
    private List<Course> course;

    public Student(StudentDto requestDto) {
        this.name=requestDto.getName();
        this.course=requestDto.getCourse();

    }


}
