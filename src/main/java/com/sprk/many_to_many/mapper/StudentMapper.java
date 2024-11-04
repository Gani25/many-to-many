package com.sprk.many_to_many.mapper;

import com.sprk.many_to_many.dto.StudentDto;
import com.sprk.many_to_many.entity.Student;

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
}
