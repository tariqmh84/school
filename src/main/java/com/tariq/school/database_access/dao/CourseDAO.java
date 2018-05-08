package com.tariq.school.database_access.dao;

import java.util.List;

import com.tariq.school.domain.entities.Course;

public interface CourseDAO {
	
	void registerCourse(Course course);

	void registerCourses(List<Course> courses);

	Course findById(Integer id);

	List<Course> findAll();

	List<Course> findByTitle(String courseTitle);
}
