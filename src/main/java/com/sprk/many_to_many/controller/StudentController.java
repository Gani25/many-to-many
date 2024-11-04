package com.sprk.many_to_many.controller;

import com.sprk.many_to_many.dto.StudentDto;
import com.sprk.many_to_many.entity.Student;
import com.sprk.many_to_many.mapper.StudentMapper;
import com.sprk.many_to_many.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/save")
    public StudentDto save(@RequestBody StudentDto studentDto) {
        Student student = StudentMapper.mappedStudentDto(studentDto,new Student());

        studentRepository.save(student);
        return studentDto;
    }

    @GetMapping("/get-student/{rollNo}")
    public StudentDto getStudentByRollNo(@PathVariable int rollNo) {
        Student student = studentRepository.findById(rollNo).orElseThrow(() -> new RuntimeException("Student Not Found"));

        StudentDto studentDto = StudentMapper.mappedStudent(student,new StudentDto());
        return studentDto;
    }
}
