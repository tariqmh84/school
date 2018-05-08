package com.tariq.school.database_access.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tariq.school.domain.entities.Subject;

public interface SubjectRepository extends CrudRepository<Subject, Integer> {

}
