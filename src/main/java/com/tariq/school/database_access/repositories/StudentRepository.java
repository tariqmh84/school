package com.tariq.school.database_access.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tariq.school.domain.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	List<Student> findByLastName(String lastName);
}
