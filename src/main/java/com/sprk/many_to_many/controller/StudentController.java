package com.sprk.many_to_many.controller;

import com.sprk.many_to_many.dto.StudentDto;
import com.sprk.many_to_many.entity.Student;
import com.sprk.many_to_many.mapper.StudentMapper;
import com.sprk.many_to_many.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/save")
    public StudentDto save(@RequestBody StudentDto studentDto) {
        Student student = StudentMapper.mappedStudentDto(studentDto,new Student());

        studentRepository.save(student);
        studentDto.setRollNo(student.getRollNo());
        return studentDto;
    }

    @GetMapping("/get-student/{rollNo}")
    public StudentDto getStudentByRollNo(@PathVariable int rollNo) {
        Student student = studentRepository.findById(rollNo).orElseThrow(() -> new RuntimeException("Student Not Found"));

        StudentDto studentDto = StudentMapper.mappedStudent(student,new StudentDto());

        return studentDto;
    }

    @GetMapping("/get-all-students")
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = new ArrayList<>();
        for (Student student : students) {
            StudentDto studentDto = StudentMapper.mappedStudent(student,new StudentDto());
            studentDtos.add(studentDto);
        }

        return studentDtos;
    }
}
