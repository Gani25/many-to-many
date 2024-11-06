package com.sprk.many_to_many.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rollNo;

    private String firstName;

    private String lastName;

    private String phone;

    @ManyToMany(mappedBy = "students", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    private List<Course> courses = new ArrayList<>();

    // Helper method to add course
    public void addCourse(Course course) {
        courses.add(course);
        course.getStudents().add(this); // Maintain the relationship on both sides
    }
}
