package com.tariq.school.database_access.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tariq.school.domain.entities.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
	List<Teacher> findByLastName(String lastName);
}
