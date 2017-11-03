package com.data.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="CollegeProgramMap")
public class CollegeProgramMap {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CollegeProgramId")
	Integer collegeProgramId;
	
	@ManyToOne
	@JoinColumn(name="FK_College")
	College college;
	
	@ManyToOne
	@JoinColumn(name="FK_ProgramCategory")
	ProgramCategory programCategory;
	
	@ManyToOne
	@JoinColumn(name="FK_Program")
	University_Program program;

		public Integer getCollegeProgramId() {
			return collegeProgramId;
		}
	
		public void setCollegeProgramId(Integer collegeProgramId) {
			this.collegeProgramId = collegeProgramId;
		}
	
		public College getCollege() {
			return college;
		}
	
		public void setCollege(College college) {
			this.college = college;
		}
	
		public ProgramCategory getProgramCategory() {
			return programCategory;
		}
	
		public void setProgramCategory(ProgramCategory programCategory) {
			this.programCategory = programCategory;
		}
	
		public University_Program getProgram() {
			return program;
		}
	
		public void setProgram(University_Program program) {
			this.program = program;
		}
}
