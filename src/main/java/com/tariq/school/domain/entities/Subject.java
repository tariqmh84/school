package com.tariq.school.domain.entities;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import java.util.HashSet;
import java.util.Set;

@Entity 
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int subjectId;
	private String subjectTitle;

	@ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinTable(name = "teacher_subject", joinColumns = @JoinColumn(name = "teacher_Id"), inverseJoinColumns = @JoinColumn(name = "subject_id"))
	private Set<Teacher> qualifiedTeachers;
	
	@ManyToOne
	private Lecture lecture;
		
		public Subject() {
			qualifiedTeachers = new HashSet<>();
		}
		
		public Subject(String subjectTitle) {
			this.subjectTitle = subjectTitle;
			qualifiedTeachers = new HashSet<>();
		}

		public int getSubjectId() {
			return subjectId;
		}

		public void setSubjectId(int subjectId) {
			this.subjectId = subjectId;
		}

		public String getSubjectTitle() {
			return subjectTitle;
		}

		public void setSubjectTitle(String subjectTitle) {
			this.subjectTitle = subjectTitle;
		}

	public Set<Teacher> getQualifiedTeachers() {
		return qualifiedTeachers;
	}

	public void setQualifiedTeachers(Set<Teacher> qualifiedTeachers) {
		this.qualifiedTeachers = qualifiedTeachers;
	}

	public Lecture getLecture() {
		return lecture;
	}

	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}
	
}
