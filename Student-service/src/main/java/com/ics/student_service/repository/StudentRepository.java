package com.ics.student_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ics.student_service.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
