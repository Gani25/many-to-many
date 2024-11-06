package com.sprk.many_to_many.mapper;

import com.sprk.many_to_many.dto.CourseDto;
import com.sprk.many_to_many.dto.StudentDto;
import com.sprk.many_to_many.dto.StudentWithCourseDto;
import com.sprk.many_to_many.entity.Course;
import com.sprk.many_to_many.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentMapper {

    public static Student mappedStudentDto(StudentDto studentDto, Student student){

        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setPhone(studentDto.getPhone());
        student.setRollNo(studentDto.getRollNo());

        return student;
    }
    public static StudentDto mappedStudent( Student student,StudentDto studentDto){

        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setPhone(student.getPhone());
        studentDto.setRollNo(student.getRollNo());

        return studentDto;
    }

    public static StudentWithCourseDto convertStudentToStudentWithCourseDto(Student student,StudentWithCourseDto studentWithCourseDto){
        studentWithCourseDto.setFirstName(student.getFirstName());
        studentWithCourseDto.setLastName(student.getLastName());
        studentWithCourseDto.setPhone(student.getPhone());
        studentWithCourseDto.setRollNo(student.getRollNo());

        List<Course> courses = student.getCourses();
        List<CourseDto> courseDtos = new ArrayList<>();
        for(Course course : courses){
            CourseDto courseDto = CourseMapper.mappedCourseToCourseDto(course,new CourseDto());
            courseDtos.add(courseDto);
        }

        studentWithCourseDto.setCourses(courseDtos);

        return studentWithCourseDto;
    }
}
