package com.tariq.school.domain.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


@Entity 
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int courseId;
	private String courseTitle;
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate startDate;
	@JsonFormat(pattern = "dd-MM-yyyy ")
	private LocalDate endDate;
	private int durationInMonth;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "teacher_id")
	private Teacher supervisor;

	@OneToMany(cascade = {CascadeType.ALL})
	//@JsonIgnore
	private Set<Lecture> scheduledLecture;

	@ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	@JsonIgnore
	private List<Student> appliedStutents;

	public Course() {
		scheduledLecture = new HashSet<>();
		appliedStutents = new ArrayList<>();
	}
	
	public Course(String courseTitle, LocalDate startDate, LocalDate endDate, Teacher supervisor) {
		this.courseTitle = courseTitle;
		this.startDate = startDate;
		this.endDate = endDate;
		this.supervisor = supervisor;
		scheduledLecture = new HashSet<>();
		appliedStutents = new ArrayList<>();
	}
	
	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public int getDurationInMonth() {
		return durationInMonth;
	}

	public void setDurationInMonth(int durationInMonth) {
		this.durationInMonth = durationInMonth;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Teacher getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(Teacher supervisor) {
		this.supervisor = supervisor;
	}

	public Set<Lecture> getScheduledLecture() {
		return scheduledLecture;
	}

	public void setScheduledLecture(Set<Lecture> scheduledLecture) {
		this.scheduledLecture = scheduledLecture;
	}

	public List<Student> getAppliedStutents() {
		return appliedStutents;
	}

	public void setAppliedStutents(List<Student> appliedStutents) {
		this.appliedStutents = appliedStutents;
	}
	
	public void addStudentToCourse(Student studentToCourse) {
		appliedStutents.add(studentToCourse);
		studentToCourse.getCourses().add(this);
		
	}
	
	/*public void addLectureToCourse(LocalDateTime lectureDateAndTime, Lecture lectureToCourse) {
		scheduledLecture.put(lectureDateAndTime, lectureToCourse);
		
	}*/
	
	public void addLectureToCourse(Lecture lectureToCourse) {
		scheduledLecture.add(lectureToCourse);
		lectureToCourse.setCourse(this);
		}
	
	public void addTeacherToCourse(Teacher teacherToCourse) {
		this.supervisor = teacherToCourse;
		teacherToCourse.getSupervisedCourses().add(this);
		
	}
	
	
	
	
	
	
}
