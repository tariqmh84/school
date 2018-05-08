package com.tariq.school.domain.entities;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

import java.util.Set;
import java.util.HashSet;


@Entity 
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int teacherId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;

	@ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinTable(name = "teacher_subject", joinColumns = @JoinColumn(name = "subject_Id"), inverseJoinColumns = @JoinColumn(name = "teacher_id"))
	private Set<Subject> qualifications;

	@OneToMany//(targetEntity = Teacher.class)
	private Set<Course> supervisedCourses;

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private Set<Lecture> lectures;
	
	public Teacher() {
		qualifications = new HashSet<>();
		supervisedCourses = new HashSet<>();
		lectures = new HashSet<>();
	}


	public Teacher(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		qualifications = new HashSet<>();
		supervisedCourses = new HashSet<>();
		lectures = new HashSet<>();
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Set<Subject> getQualifications() {
		return qualifications;
	}

	public void setQualifications(Set<Subject> qualifications) {
		this.qualifications = qualifications;
	}

	public Set<Course> getSupervisedCourses() {
		return supervisedCourses;
	}

	public void setSupervisedCourses(Set<Course> supervisedCourses) {
		this.supervisedCourses = supervisedCourses;
	}

	public Set<Lecture> getLectures() {
		return lectures;
	}

	public void setLectures(Set<Lecture> lectures) {
		this.lectures = lectures;
	}
	
	public void addLectureToTeacher(Lecture lectureToTeacher) {
		lectures.add(lectureToTeacher);
		lectureToTeacher.getTeachers().add(this);
		
	}
}
