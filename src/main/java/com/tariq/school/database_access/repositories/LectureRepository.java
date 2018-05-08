package com.tariq.school.database_access.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tariq.school.domain.entities.Lecture;

public interface LectureRepository extends CrudRepository<Lecture, Integer> {
			List<Lecture> findByLectureTitle(String lectureTitle);
}
