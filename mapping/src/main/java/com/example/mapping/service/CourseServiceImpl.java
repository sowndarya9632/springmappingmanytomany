package com.example.mapping.service;

import com.example.mapping.dto.CourseDto;
import com.example.mapping.entity.Course;
import com.example.mapping.entity.Student;
import com.example.mapping.repository.CourseRepository;
import com.example.mapping.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseRepository courseRepo;
    @Autowired
    private StudentRepository studentRepo;

    public CourseDto addCourse(CourseDto courseDto) {
        Course course = new Course(courseDto);
        course = courseRepo.save(course);
        return mapToDto(course);
    }

    public CourseDto addStudentToCourse(Long studentId, long courseId) {
        Course course = courseRepo.findById(courseId)
                .orElseThrow(()->new RuntimeException("course id not found"));
        Student student = studentRepo.findById(studentId)
                .orElseThrow(()->new RuntimeException("student id not found"));
        course.getStudents().add(student);
        course = courseRepo.save(course);
        return mapToDto(course);
    }

    public CourseDto mapToDto(Course course) {
        CourseDto courseDto=new CourseDto();
        courseDto.setId(course.getId());
        courseDto.setTitle(course.getTitle());
        courseDto.setStudents(course.getStudents());
        return courseDto;

    }


}
