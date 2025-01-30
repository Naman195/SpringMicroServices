package com.ics.student_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ics.student_service.entity.Student;
import com.ics.student_service.service.StudentService;

@RestController
@CrossOrigin("*")
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@GetMapping("/{id}")
	public ResponseEntity<?> fetchStudentById(@PathVariable int id){
		return studentService.fetchStudentById(id);
	}
	
	@GetMapping
    public ResponseEntity<?> fetchStudents(){
        return studentService.fetchStudents();
    }
	
	@PostMapping("/add")
    public ResponseEntity<?> createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }
}
