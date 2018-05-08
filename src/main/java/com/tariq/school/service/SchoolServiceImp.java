package com.tariq.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tariq.school.database_access.dao.CourseDAO;
import com.tariq.school.domain.entities.Course;

@Service
public class SchoolServiceImp {
	
	@Autowired
	private CourseDAO courseDAO;;
	
	
	@Transactional
	public Course findCourseById(int id) {
		Course found = courseDAO.findById(id);
		return found;
		
	}
	
	

}
