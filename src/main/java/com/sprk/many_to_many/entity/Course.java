package com.sprk.many_to_many.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;

    private String courseName;

    private String description;

    private String duration;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "roll_no")
    )
    private List<Student> students = new ArrayList<>();

    // Helper method to add student
    public void addStudent(Student student) {

        students.add(student);
        student.getCourses().add(this); // Maintain the relationship on both sides
    }
}
