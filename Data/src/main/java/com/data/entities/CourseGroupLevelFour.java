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
@Table(name="CourseGroupLevelFour")
public class CourseGroupLevelFour {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CGLevelFourId")
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
	@JoinColumn(name="FK_CourseGroupLevelThree")
	@JsonIgnore
	CourseGroupLevelThree cgLevelThree;

	@OneToMany(mappedBy = "cgLevelFour", fetch = FetchType.EAGER)
	List<CourseGroupLevelFive> cgLevelFiveList;
	
	@OneToMany(mappedBy = "cgLevelFour", fetch = FetchType.EAGER)
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
	
		public CourseGroupLevelThree getCgLevelThree() {
			return cgLevelThree;
		}
	
		public void setCgLevelThree(CourseGroupLevelThree cgLevelThree) {
			this.cgLevelThree = cgLevelThree;
		}
	
		public List<CourseGroupLevelFive> getCgLevelFiveList() {
			return cgLevelFiveList;
		}
	
		public void setCgLevelFiveList(List<CourseGroupLevelFive> cgLevelFiveList) {
			this.cgLevelFiveList = cgLevelFiveList;
		}

		public List<GroupSubjectMap> getSubjectList() {
			return subjectList;
		}

		public void setSubjectList(List<GroupSubjectMap> subjectList) {
			this.subjectList = subjectList;
		}

}
