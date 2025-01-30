package com.ics.school_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ics.school_service.entity.School;

public interface School_Repository extends JpaRepository<School, Integer> {
	
	

}
