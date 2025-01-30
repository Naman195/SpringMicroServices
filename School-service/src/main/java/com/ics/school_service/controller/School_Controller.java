package com.ics.school_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ics.school_service.entity.School;
import com.ics.school_service.service.SchoolService;


@CrossOrigin("*")
@RestController
@RequestMapping("/school")
public class School_Controller {
	
	@Autowired
	private SchoolService schoolService;
	
	
	@PostMapping("/add")
	public School addSchool(@RequestBody School school) {
		return schoolService.addSchool(school);
		
	}
	
	@GetMapping("/list")
	public List<School> getAllSchool(){
		return schoolService.getAllSchool();
	}
	
	@GetMapping("/get/{id}")
	public School getSchoolById(@PathVariable int id) {
		return schoolService.getSchoolById(id);
	}
	
	
	

}
