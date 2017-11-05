package com.web.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.CollegeProgramMap;
import com.data.entities.University_Program;
import com.data.services.CollegeProgramMapService;
import com.data.services.ProgramService;
import com.web.model.ProgramModel;
import com.web.services.ProgramRCService;

@Service("programRCService")
public class ProgramRCServiceImpl implements ProgramRCService {

	@Autowired
	CollegeProgramMapService collegeProgramMapService;
	
	@Autowired
	ProgramService programService;
	
	public List<ProgramModel> getProgramsByCategory(Integer collegeId, Integer programCategoryId) {
	
		List<CollegeProgramMap> programsOfCollege = collegeProgramMapService.getCollegeProgramsByCategory(collegeId, programCategoryId);
		List<ProgramModel> programModelList = new ArrayList<ProgramModel>();
		
		University_Program program = null;
		for(CollegeProgramMap programOfCollege : programsOfCollege) {
			program = programOfCollege.getProgram();
			ProgramModel programModel = new ProgramModel();			
			programModel.setProgramCode(program.getUniversityProgramCode());
			programModel.setProgramName(program.getUniversityProgramName());
			programModel.setFacultyOrCollege(program.getUniversityProgramFaculty());
			programModel.setApplicationDates("");
			programModel.setId(program.getUniversityProgramId());
			programModelList.add(programModel);
		}
		
		ProgramModel programModel = new ProgramModel();
		programModel.setProgramCode("1");
		programModel.setProgramName("BSc IT");
		programModel.setFacultyOrCollege("Faculty of Science");
		programModel.setApplicationDates("22-02-2015");
		programModel.setId(1);
		programModelList.add(programModel);
		
		programModel = new ProgramModel();
		programModel.setProgramCode("2");
		programModel.setProgramName("BSc Comp Sc");
		programModel.setFacultyOrCollege("Faculty of Science");
		programModel.setApplicationDates("22-02-2015");
		programModel.setId(2);
		programModelList.add(programModel);
		
		return programModelList;
	}
	
	public void saveBachelorCourses(ProgramModel bachelorCoursesModel) {
		
	}
		
		
}
