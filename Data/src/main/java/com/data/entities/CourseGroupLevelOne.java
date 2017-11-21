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

@Entity
@Table(name="CourseGroupLevelOne")
public class CourseGroupLevelOne {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CGLevelOneId")
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
	@JoinColumn(name="FK_UniversityProgram")
	University_Program universityProgram;

	@OneToMany(mappedBy = "cgLevelOne", fetch = FetchType.EAGER)
	List<CourseGroupLevelTwo> cgLevelTwoList;
	
	@OneToMany(mappedBy = "cgLevelOne", fetch = FetchType.EAGER)
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
	
		public Integer getMaxAllowedCourses() {
			return maxAllowedCourses;
		}

		public void setMaxAllowedCourses(Integer maxAllowedCourses) {
			this.maxAllowedCourses = maxAllowedCourses;
		}

		public List<CourseGroupLevelTwo> getCgLevelTwoList() {
			return cgLevelTwoList;
		}
	
		public void setCgLevelTwoList(List<CourseGroupLevelTwo> cgLevelTwoList) {
			this.cgLevelTwoList = cgLevelTwoList;
		}
	
		public University_Program getUniversityProgram() {
			return universityProgram;
		}
	
		public void setUniversityProgram(University_Program universityProgram) {
			this.universityProgram = universityProgram;
		}

		public List<GroupSubjectMap> getSubjectList() {
			return subjectList;
		}

		public void setSubjectList(List<GroupSubjectMap> subjectList) {
			this.subjectList = subjectList;
		}		
	
}
