package com.sprk.many_to_many.repository;

import com.sprk.many_to_many.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
