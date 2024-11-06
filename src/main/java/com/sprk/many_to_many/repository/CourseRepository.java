package com.sprk.many_to_many.repository;

import com.sprk.many_to_many.entity.Course;
import com.sprk.many_to_many.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
