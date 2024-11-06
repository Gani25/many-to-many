package com.sprk.many_to_many.repository;

import com.sprk.many_to_many.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    // Custom query to fetch a student and their associated courses
    @Query("FROM Student s JOIN FETCH s.courses WHERE s.rollNo = :rollNo")
    Optional<Student> findStudentWithCourses( int rollNo);

}
