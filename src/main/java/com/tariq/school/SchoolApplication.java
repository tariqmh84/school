package com.tariq.school;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tariq.school.database_access.repositories.CourseRepository;
import com.tariq.school.database_access.repositories.LectureRepository;
import com.tariq.school.database_access.repositories.StudentRepository;
import com.tariq.school.database_access.repositories.SubjectRepository;
import com.tariq.school.database_access.repositories.TeacherRepository;
import com.tariq.school.domain.entities.Course;
import com.tariq.school.domain.entities.Lecture;
import com.tariq.school.domain.entities.Student;
import com.tariq.school.domain.entities.Subject;
import com.tariq.school.domain.entities.Teacher;

@SpringBootApplication
public class SchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CourseRepository courseRepo, 
								  StudentRepository studentRepo,
								  TeacherRepository teacherRepo,
								  LectureRepository lectureRepo,
								  SubjectRepository subjectRepo) 
	{
		return (args) ->{
			
			 
			
			Student student1 = new Student("Tariq","Mahrous","tariq@tariq.com","Karlskrona");
			
			Subject subject1 = new Subject("Dependency injection");
			
			Lecture lecture1 = new Lecture("Lambda Expressions", "400L", LocalDateTime.of(2018, 5, 15, 8, 0));
			
			Teacher teacher1 = new Teacher("Erik","Svensson","svensson@erik.com");
			
			Course courseJAVA = new Course("JAVA Fundamental", LocalDate.of(2018, 05, 01), LocalDate.of(2018, 10, 30), teacher1);
			
			
			
			courseJAVA.addStudentToCourse(student1);
			courseRepo.save(courseJAVA);
			courseJAVA.addLectureToCourse(lecture1);
			courseRepo.save(courseJAVA);
			lecture1.addTeacherToLecture(teacher1);
			lectureRepo.save(lecture1);
			lecture1.addSubjectToLecture(subject1);

			
		    
			
			
			
			
			
		};	
		
	}
}
