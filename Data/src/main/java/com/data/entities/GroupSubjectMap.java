package com.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="GroupSubjectMap")
public class GroupSubjectMap {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="GroupSubjectMapId")
	Integer GroupSubjectMapId;
	
	@ManyToOne
	@JoinColumn(name="FK_CourseGroupLevelOne")
	@JsonIgnore
	CourseGroupLevelOne cgLevelOne;
	
	@ManyToOne
	@JoinColumn(name="FK_CourseGroupLevelTwo")
	@JsonIgnore
	CourseGroupLevelTwo cgLevelTwo;
	
	@ManyToOne
	@JoinColumn(name="FK_CourseGroupLevelThree")
	@JsonIgnore
	CourseGroupLevelThree cgLevelThree;
	
	@ManyToOne
	@JoinColumn(name="FK_CourseGroupLevelFour")
	@JsonIgnore
	CourseGroupLevelFour cgLevelFour;
	
	@ManyToOne
	@JoinColumn(name="FK_CourseGroupLevelFive")
	@JsonIgnore
	CourseGroupLevelFive cgLevelFive;
	
	@OneToOne
	@JoinColumn(name="FK_Subject")
	University_Subject subject;

		public Integer getGroupSubjectMapId() {
			return GroupSubjectMapId;
		}
	
		public void setGroupSubjectMapId(Integer groupSubjectMapId) {
			GroupSubjectMapId = groupSubjectMapId;
		}
	
		public CourseGroupLevelOne getCgLevelOne() {
			return cgLevelOne;
		}
	
		public void setCgLevelOne(CourseGroupLevelOne cgLevelOne) {
			this.cgLevelOne = cgLevelOne;
		}
	
		public CourseGroupLevelTwo getCgLevelTwo() {
			return cgLevelTwo;
		}
	
		public void setCgLevelTwo(CourseGroupLevelTwo cgLevelTwo) {
			this.cgLevelTwo = cgLevelTwo;
		}
	
		public CourseGroupLevelThree getCgLevelThree() {
			return cgLevelThree;
		}
	
		public void setCgLevelThree(CourseGroupLevelThree cgLevelThree) {
			this.cgLevelThree = cgLevelThree;
		}
	
		public CourseGroupLevelFour getCgLevelFour() {
			return cgLevelFour;
		}
	
		public void setCgLevelFour(CourseGroupLevelFour cgLevelFour) {
			this.cgLevelFour = cgLevelFour;
		}
	
		public CourseGroupLevelFive getCgLevelFive() {
			return cgLevelFive;
		}
	
		public void setCgLevelFive(CourseGroupLevelFive cgLevelFive) {
			this.cgLevelFive = cgLevelFive;
		}
	
		public University_Subject getSubject() {
			return subject;
		}
	
		public void setSubject(University_Subject subject) {
			this.subject = subject;
		}	
		
}
