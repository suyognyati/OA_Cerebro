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
@Table(name="CourseGroupLevelTwo")
public class CourseGroupLevelTwo {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CGLevelTwoId")
	Integer id;
	
	@Column(name="Name")
	String name;
	
	@Column(name="SequenceNo")
	Integer sequenceNo;
	
	@Column(name="MinSelection")
	Integer minSelection;
	
	@Column(name="MaxSelection")
	Integer maxSelection;
	
	@ManyToOne
	@JoinColumn(name="FK_CourseGroupLevelOne")
	@JsonIgnore
	CourseGroupLevelOne cgLevelOne;

	@OneToMany(mappedBy = "cgLevelTwo", fetch = FetchType.EAGER)
	List<CourseGroupLevelThree> cgLevelThreeList;
	
	@OneToMany(mappedBy = "cgLevelTwo", fetch = FetchType.EAGER)
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
	
		public CourseGroupLevelOne getCgLevelOne() {
			return cgLevelOne;
		}
	
		public void setCgLevelOne(CourseGroupLevelOne cgLevelOne) {
			this.cgLevelOne = cgLevelOne;
		}
	
		public List<CourseGroupLevelThree> getCgLevelThreeList() {
			return cgLevelThreeList;
		}
	
		public void setCgLevelThreeList(List<CourseGroupLevelThree> cgLevelThreeList) {
			this.cgLevelThreeList = cgLevelThreeList;
		}

		public List<GroupSubjectMap> getSubjectList() {
			return subjectList;
		}

		public void setSubjectList(List<GroupSubjectMap> subjectList) {
			this.subjectList = subjectList;
		}		
	
}
