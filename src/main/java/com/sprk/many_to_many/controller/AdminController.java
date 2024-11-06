package com.sprk.many_to_many.controller;

import com.sprk.many_to_many.dto.StudentWithCourseDto;
import com.sprk.many_to_many.entity.Course;
import com.sprk.many_to_many.entity.Student;
import com.sprk.many_to_many.mapper.StudentMapper;
import com.sprk.many_to_many.repository.CourseRepository;
import com.sprk.many_to_many.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private StudentRepository studentRepo;
    @Autowired
    private CourseRepository courseRepo;
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/assign-course-to-student")
    public String addCourseToStudent(@RequestParam int rollNo, @RequestParam int courseId) {

        Student student = studentRepo.findById(rollNo).orElseThrow(()->new RuntimeException("Student Not found"));

        Course course = courseRepo.findById(courseId).orElseThrow(()->new RuntimeException("Student Not found"));
        student.addCourse(course);  // This will add the course and maintain bidirectional association
//        course.addStudent(student);
        studentRepo.save(student);  // Save the student, and both sides of the relationship should be persisted

        return "Course added successfully";

    }

    @GetMapping("/get-student-with-courses/{rollNo}")
    public StudentWithCourseDto getStudentWithCourses(@PathVariable int rollNo) {
        Student student = studentRepository.findStudentWithCourses(rollNo).orElseThrow(()->new RuntimeException("Student Not found"));
        StudentWithCourseDto studentWithCourseDto = StudentMapper.convertStudentToStudentWithCourseDto(student,new StudentWithCourseDto());

        return studentWithCourseDto;
    }
}
