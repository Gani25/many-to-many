package com.sprk.many_to_many.controller;

import com.sprk.many_to_many.dto.CourseDto;
import com.sprk.many_to_many.entity.Course;
import com.sprk.many_to_many.mapper.CourseMapper;
import com.sprk.many_to_many.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @PostMapping("/save-course")
    public CourseDto saveCourse(@RequestBody CourseDto courseDto) {

        Course course = CourseMapper.mappedCourseDtoToCourse(courseDto, new Course());

        courseRepository.save(course);
        courseDto.setCourseId(course.getCourseId());
        return courseDto;
    }

    @GetMapping("/get-all-courses")
    public List<CourseDto> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        List<CourseDto> courseDtos = new ArrayList<>();
        for (Course course : courses) {
            CourseDto courseDto = CourseMapper.mappedCourseToCourseDto(course,new CourseDto());
            courseDtos.add(courseDto);
        }

        return courseDtos;
    }
}
