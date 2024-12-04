package com.example.mapping.service;

import com.example.mapping.dto.StudentDto;
import com.example.mapping.entity.Student;
import com.example.mapping.repository.CourseRepository;
import com.example.mapping.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl  implements StudentService{
    public CourseRepository courseRepository;
    public StudentRepository studentRepository;

    public StudentServiceImpl(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDto addStudent(StudentDto requestDto) {
        Student student = new Student(requestDto);
         student = studentRepository.save(student);
         return mapToDto(student);
    }



    private StudentDto mapToDto(Student student) {
        StudentDto studentRequestDto=new StudentDto();
        studentRequestDto.setName(student.getName());
        studentRequestDto.setCourse(student.getCourse());
        return studentRequestDto;
    }


}

