package com.web.model;

import java.util.List;

import com.data.entities.CollegeProgramMap;
import com.data.entities.Enums.KeyValuePair;
import com.data.entities.ProgramCategoryWeightage;

public class ProgramCategoryWeightageModel {

	CollegeProgramMap collegeProgramMap;
	ProgramCategoryWeightage programCategoryWeightageCount;
	List<CategoryWeightage> categoryWeightageList;
	//To accept data from view
	List<ProgramCategoryWeightage> programCategoryWeightageList;
		
		public CollegeProgramMap getCollegeProgramMap() {
			return collegeProgramMap;
		}
		public void setCollegeProgramMap(CollegeProgramMap collegeprogramMap) {
			this.collegeProgramMap = collegeprogramMap;
		}
		public ProgramCategoryWeightage getProgramCategoryWeightageCount() {
			return programCategoryWeightageCount;
		}
		public void setProgramCategoryWeightageCount(ProgramCategoryWeightage programCategoryWeightageCount) {
			this.programCategoryWeightageCount = programCategoryWeightageCount;
		}
		public List<CategoryWeightage> getCategoryWeightageList() {
			return categoryWeightageList;
		}
		public void setCategoryWeightageList(List<CategoryWeightage> categoryWeightageList) {
			this.categoryWeightageList = categoryWeightageList;
		}		
		public List<ProgramCategoryWeightage> getProgramCategoryWeightageList() {
			return programCategoryWeightageList;
		}
		public void setProgramCategoryWeightageList(List<ProgramCategoryWeightage> programCategoryWeightageList) {
			this.programCategoryWeightageList = programCategoryWeightageList;
		}


		public class CategoryWeightage {
			KeyValuePair category;
			ProgramCategoryWeightage programCategoryWeightage;
				public KeyValuePair getCategory() {
					return category;
				}
				public void setCategory(KeyValuePair category) {
					this.category = category;
				}
				public ProgramCategoryWeightage getProgramCategoryWeightage() {
					return programCategoryWeightage;
				}
				public void setProgramCategoryWeightage(ProgramCategoryWeightage programCategoryWeightage) {
					this.programCategoryWeightage = programCategoryWeightage;
				}		
		}	
}
