package com.tariq.school.controller;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tariq.school.database_access.repositories.CourseRepository;
import com.tariq.school.domain.entities.Course;
import com.tariq.school.domain.entities.Lecture;
import com.tariq.school.domain.entities.Student;
import com.tariq.school.domain.entities.Teacher;

@RestController
public class courseController {
	@Autowired
	CourseRepository repository;

	@GetMapping("/courses")
	public List<Course> findAll() {
		List<Course> found = (List<Course>) repository.findAll();

		if (found == null) {
			throw new RuntimeException("Could not find any courses");
		}

		return found;
	}

	@GetMapping("/courses/{id}")
	public ResponseEntity<Course> find(@PathVariable int id) {

		Course result = repository.findOne(id);

		if (result == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(result);
	}

	@GetMapping("courses/{id}/teacher")
	public ResponseEntity<Teacher> showAuthors(@PathVariable int id) {
		Course found = repository.findOne(id);

		if (found == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(found.getSupervisor());
	}

	@GetMapping("courses/{id}/students")
	public ResponseEntity<List<Student>> showStudents(@PathVariable int id) {
		Course found = repository.findOne(id);

		if (found == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(found.getAppliedStutents());
	}

	@GetMapping("courses/{id}/lectures")
	public ResponseEntity<Set<Lecture>> showLecture(@PathVariable int id) {
		Course found = repository.findOne(id);

		if (found == null) {
			return ResponseEntity.notFound().build();
		}

		return ResponseEntity.ok(found.getScheduledLecture());
	}

	@PostMapping("/courses")
	public ResponseEntity<Void> create(@RequestBody Course created) {
		repository.save(created);

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@PutMapping("/courses/{id}")
	public ResponseEntity<Course> updateBook(@PathVariable int id, @RequestBody Course updated) {

		updated = repository.save(updated);

		return ResponseEntity.ok(updated);
	}

}
