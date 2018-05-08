package com.tariq.school.database_access.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tariq.school.database_access.repositories.CourseRepository;
import com.tariq.school.domain.entities.Course;

@Repository
public class CourseDAOimp implements CourseDAO {
	
	private CourseRepository repo;

	@Override
	public void registerCourse(Course course) {
		repo.save(course);
		
	}

	@Override
	public void registerCourses(List<Course> courses) {
		repo.save(courses);
		
	}

	@Override
	public Course findById(Integer id) {
		Course found = repo.findOne(id);
		return found;
	}

	@Override
	public List<Course> findAll() {
		List<Course> foundAll = (List<Course>) repo.findAll();
		return foundAll; 
	}

	@Override
	public List<Course> findByTitle(String courseTitle) {
		return repo.findByCourseTitle(courseTitle);
	}

}
