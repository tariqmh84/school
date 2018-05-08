package com.tariq.school.domain.entities;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity 
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int lectureId;
    private String lectureTitle;
    private String lectureRoom;
    @JsonFormat(pattern = "dd-MM-yyyy hh:mm")
    private LocalDateTime lectureDate;

    @ManyToOne
    @JoinColumn(name = "fk_course")
    private Course course;

    @OneToMany(cascade = {CascadeType.ALL})
    private Set<Subject> subjects;

    @OneToMany
    private Set<Teacher> teachers;

    public Lecture() {
    	teachers = new HashSet<>();
    	subjects = new HashSet<>();
    }
    
    public Lecture(String lectureTitle, String lectureRoom, LocalDateTime lectureDate) {
        this.lectureTitle = lectureTitle;
        this.lectureRoom = lectureRoom;
        this.lectureDate = lectureDate;
        teachers = new HashSet<>();
        subjects = new HashSet<>();
    }

    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }

    public String getLectureTitle() {
        return lectureTitle;
    }

    public void setLectureTitle(String lectureTitle) {
        this.lectureTitle = lectureTitle;
    }

    public LocalDateTime getLectureDate() {
        return lectureDate;
    }

    public void setLectureDate(LocalDateTime lectureDate) {
        this.lectureDate = lectureDate;
    }

    public String getLectureRoom() {
        return lectureRoom;
    }

    public void setLectureRoom(String lectureRoom) {
        this.lectureRoom = lectureRoom;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }


    public Set<Subject> getSubject() {
		return subjects;
	}

	public void setSubject(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }
    
    public void addTeacherToLecture(Teacher teacher) {
    	teachers.add(teacher);
    	teacher.getLectures().add(this);
    	
    }
    
    public void addSubjectToLecture(Subject subject) {
    	subjects.add(subject);
    	subject.setLecture(this);
    	
    }
    
}
