package com.ics.student_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor 
@Getter
@Setter
public class School {
	
	private int id;
	private String schoolName;
	private String location;
	private String principalName;

}
