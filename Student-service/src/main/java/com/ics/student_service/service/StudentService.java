package com.ics.student_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ics.student_service.dto.School;
import com.ics.student_service.dto.StudentResponse;
import com.ics.student_service.entity.Student;
import com.ics.student_service.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public ResponseEntity<?> createStudent(Student obj) {
		try {
			return new ResponseEntity<Student>(studentRepository.save(obj), HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> fetchStudentById(int id){
		Optional<Student> student =  studentRepository.findById(id);
		
		if(student.isPresent()) {
			School school = restTemplate.getForObject("http://localhost:8081/school/get/" + student.get().getSchoolId(), School.class);
			
			StudentResponse studentRes = new StudentResponse(
					student.get().getId(),
					student.get().getName(),
					student.get().getAge(),
					student.get().getGender(),
					school
					);
			
			return new ResponseEntity<>(studentRes, HttpStatus.OK);
		} else{
            return new ResponseEntity<>("No Student Found",HttpStatus.NOT_FOUND);
        }
			
	}
	
	public ResponseEntity<?> fetchStudents(){
		List<Student> students = studentRepository.findAll();
        if(students.size() > 0){
            return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No Students",HttpStatus.NOT_FOUND);
        }
	}
}
