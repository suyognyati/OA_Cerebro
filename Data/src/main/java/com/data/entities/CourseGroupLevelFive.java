package com.data.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="CourseGroupLevelFive")
public class CourseGroupLevelFive {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CGLevelFiveId")
	Integer id;
	
	@Column(name="Name")
	String name;
	
	@Column(name="SequenceNo")
	Integer sequenceNo;
	
	@Column(name="MinSelection")
	Integer minSelection;
	
	@Column(name="MaxSelection")
	Integer maxSelection;
	
	@Column(name="MaxAllowedCourses")
	Integer maxAllowedCourses;
	
	@ManyToOne
	@JoinColumn(name="FK_CourseGroupLevelFour")
	@JsonIgnore
	CourseGroupLevelFour cgLevelFour;
	
	@OneToMany(mappedBy = "cgLevelFive", fetch = FetchType.EAGER)
	List<GroupSubjectMap> subjectList;

		public Integer getId() {
			return id;
		}
	
		public void setId(Integer id) {
			this.id = id;
		}
	
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getSequenceNo() {
			return sequenceNo;
		}
	
		public void setSequenceNo(Integer sequenceNo) {
			this.sequenceNo = sequenceNo;
		}
	
		public Integer getMinSelection() {
			return minSelection;
		}
	
		public void setMinSelection(Integer minSelection) {
			this.minSelection = minSelection;
		}
	
		public Integer getMaxSelection() {
			return maxSelection;
		}
	
		public void setMaxSelection(Integer maxSelection) {
			this.maxSelection = maxSelection;
		}
	
		public CourseGroupLevelFour getCgLevelFour() {
			return cgLevelFour;
		}
	
		public Integer getMaxAllowedCourses() {
			return maxAllowedCourses;
		}

		public void setMaxAllowedCourses(Integer maxAllowedCourses) {
			this.maxAllowedCourses = maxAllowedCourses;
		}

		public void setCgLevelFour(CourseGroupLevelFour cgLevelFour) {
			this.cgLevelFour = cgLevelFour;
		}

		public List<GroupSubjectMap> getSubjectList() {
			return subjectList;
		}

		public void setSubjectList(List<GroupSubjectMap> subjectList) {
			this.subjectList = subjectList;
		}
	
}
