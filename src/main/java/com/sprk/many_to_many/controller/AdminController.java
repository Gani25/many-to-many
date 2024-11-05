package com.sprk.many_to_many.controller;

import com.sprk.many_to_many.entity.Course;
import com.sprk.many_to_many.entity.Student;
import com.sprk.many_to_many.repository.CourseRepository;
import com.sprk.many_to_many.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AdminController {

    @Autowired
    private StudentRepository studentRepo;
    @Autowired
    private CourseRepository courseRepo;

    @PostMapping("/assign-course-to-student")
    public String addCourseToStudent(@RequestParam int rollNo, @RequestParam int courseId) {

        Student student = studentRepo.findById(rollNo).orElseThrow(()->new RuntimeException("Student Not found"));

        Course course = courseRepo.findById(courseId).orElseThrow(()->new RuntimeException("Student Not found"));
        List<Course> courses = student.getCourses();

        if(courses == null){
            courses = new ArrayList<>();
        }
        courses.add(course);

        student.setCourses(courses);

        studentRepo.save(student);

        return "Course added successfully";

    }
}
