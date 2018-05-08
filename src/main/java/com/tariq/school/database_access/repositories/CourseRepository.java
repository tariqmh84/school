package com.tariq.school.database_access.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tariq.school.domain.entities.Course;

public interface CourseRepository extends CrudRepository<Course, Integer> {
	List<Course> findByCourseTitle(String courseTitle);
}
