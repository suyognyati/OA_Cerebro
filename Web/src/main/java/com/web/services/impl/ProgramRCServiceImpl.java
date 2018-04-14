package com.web.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.CollegeProgramMap;
import com.data.entities.ProgramCategory;
import com.data.entities.University_Program;
import com.data.services.CollegeProgramMapService;
import com.web.model.ProgramModel;
import com.web.services.ProgramRCService;

@Service("programRCService")
public class ProgramRCServiceImpl implements ProgramRCService {

	@Autowired
	CollegeProgramMapService collegeProgramMapService;
	
	public List<ProgramModel> getProgramsByCategory(Integer collegeId, Integer programCategoryId) {
	
		List<CollegeProgramMap> programsOfCollege = collegeProgramMapService.getCollegeProgramsByCategory(collegeId, programCategoryId);
		List<ProgramModel> programModelList = new ArrayList<ProgramModel>();
		
		University_Program program = null;
		for(CollegeProgramMap programOfCollege : programsOfCollege) {
			program = programOfCollege.getProgram();
			ProgramModel programModel = new ProgramModel();
			programModel.setCollegeProgramId(programOfCollege.getCollegeProgramMapId());
			programModel.setProgramCode(program.getUniversityProgramCode());
			programModel.setProgramName(program.getUniversityProgramName());
			programModel.setFacultyOrCollege(program.getUniversityProgramFaculty());
			programModel.setApplicationDates("");
			programModel.setProgramId(program.getUniversityProgramId());
			programModel.setFileMap(program.getProgramFileMap());
			programModelList.add(programModel);
		}
		
		return programModelList;
	}
	
	public List<ProgramModel> getAllProgramsOfCollege(Integer collegeId) {
		
		List<CollegeProgramMap> programsOfCollege = collegeProgramMapService.getAllProgramsOfCollege(collegeId);
		List<ProgramModel> programModelList = new ArrayList<ProgramModel>();
		
		University_Program program = null;
		ProgramCategory programLevel = null;
		for(CollegeProgramMap programOfCollege : programsOfCollege) {
			program = programOfCollege.getProgram();
			programLevel = programOfCollege.getProgramCategory();
			
			ProgramModel programModel = new ProgramModel();
			programModel.setCollegeProgramId(programOfCollege.getCollegeProgramMapId());
			programModel.setProgramCode(program.getUniversityProgramCode());
			programModel.setProgramName(program.getUniversityProgramName());
			programModel.setFacultyOrCollege(program.getUniversityProgramFaculty());
			programModel.setApplicationDates("");
			programModel.setProgramId(program.getUniversityProgramId());
			programModel.setFileMap(program.getProgramFileMap());
			programModel.setProgramLevelId(programLevel.getCategoryId());
			programModelList.add(programModel);
		}
		
		return programModelList;
	}
	
	public void saveBachelorCourses(ProgramModel bachelorCoursesModel) {
		
	}
		
		
}
