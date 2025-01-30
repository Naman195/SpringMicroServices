package com.ics.school_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ics.school_service.entity.School;
import com.ics.school_service.repository.School_Repository;

@Service
public class SchoolService {

	@Autowired
	private School_Repository school_Repository;
	
	public School addSchool(School obj) {
		return school_Repository.save(obj);
	}
	
	public List<School> getAllSchool(){
		return school_Repository.findAll();
	}
	
	public School getSchoolById(int id) {
		return school_Repository.findById(id).orElse(null);
	}
}
