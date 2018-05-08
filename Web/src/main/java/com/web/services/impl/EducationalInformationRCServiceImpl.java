package com.web.services.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.CollegeProgramMap;
import com.data.entities.EducationalInformation;
import com.data.entities.Enums;
import com.data.entities.QualificationLevel;
import com.data.entities.QualificationProgram;
import com.data.entities.User;
import com.data.services.BoardService;
import com.data.services.CollegeProgramMapService;
import com.data.services.EducationalInformationService;
import com.data.services.GeoLocationsService;
import com.data.services.QualificationLevelService;
import com.data.services.QualificationProgramDao;
import com.web.model.EducationModel;
import com.web.model.EducationModel.Qualification;
import com.web.model.EducationModel.QualificationDetail;
import com.web.model.EducationModel.SubQualification;
import com.web.services.EducationalInformationRCService;


@Service("educationalInformationRCService")
public class EducationalInformationRCServiceImpl implements EducationalInformationRCService {

	@Autowired
	EducationalInformationService educationalInformationService;
	
	@Autowired
	QualificationLevelService qualificationLevelService;
	
	@Autowired
	QualificationProgramDao qualificationProgramDao;
	
	@Autowired
	GeoLocationsService geoLocationService;
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	CollegeProgramMapService collegeProgramMapService;
	
	@Override
	public List<EducationModel.Qualification> getListofQualification(User user){
		List<EducationalInformation> educationalHistory = educationalInformationService.getEducationalHistory(user);
		return generateQualificationHistory(educationalHistory);
	}
	
	@Override
	public List<Qualification> getAllowedQualificationsForProgram(User user, Integer collegeProgramMapId) {
		CollegeProgramMap clgPrgMap = collegeProgramMapService.getById(collegeProgramMapId);
		if(clgPrgMap != null && clgPrgMap.getProgram() != null) {
			List<EducationalInformation> educationalHistory = educationalInformationService.getAllowedLastQualification(user, clgPrgMap.getProgram());
			return generateQualificationHistory(educationalHistory);
		} else {
			return null;
		}
	}
	
	@Override
	public QualificationDetail getQualificationDetail(User user, Integer qualificationId) {
		EducationalInformation educationalInformation  = null;
		educationalInformation = educationalInformationService.getByEducationalInformationId(user, qualificationId);
		Integer qualificationGroup = educationalInformation.getQualificationLevel().getQualificationGroup();
		
		maxAcademicYear = 3;
		QualificationDetail qualificationDetail = createQualificationDetailObject(educationalInformation);
		setDefaultData(qualificationGroup, qualificationDetail);
		return qualificationDetail;
	}

	public QualificationDetail getNewQualification(User user, Integer qualificationGroup) {
		QualificationLevel qualificationGroupObject = qualificationLevelService.getQualificationGroup(qualificationGroup);
		
		EducationalInformation educationalInformation = null;
		
		if(qualificationGroupObject != null && qualificationGroupObject.getMultiReferred() == false) {
			educationalInformation = educationalInformationService.getByUserAndQualificationLevel(user, qualificationGroupObject);
		}
		
		maxAcademicYear = 3;
		QualificationDetail qualificationDetail = createQualificationDetailObject(educationalInformation);
		setDefaultData(qualificationGroup, qualificationDetail);
				
		return qualificationDetail;
	}
	
	@Override
	public Boolean saveQualificationDetail(User user, QualificationDetail qualificationDetail) {
		//Getting qualificationlevelobject to search for respected educational information
		//QualificationLevel qualificationLevelObject = qualificationLevelService.getByMainAndSubLevel(qualificationDetail.getQualificationGroup(), 0);
		QualificationLevel qualificationLevelObject = qualificationDetail.getQualificationLevel();
		if(qualificationLevelObject == null)
			return false;
		
		EducationalInformation educationalInformation = null;
		//Finding educational information for qualificationId of user
		if(qualificationLevelObject.getMultiReferred())
			educationalInformation = educationalInformationService.getByEducationalInformationId(user, qualificationDetail.getQualificationId());
		else
			educationalInformation = educationalInformationService.getByUserAndQualificationLevel(user, qualificationLevelObject);
		
		//if educational information not found
		if(educationalInformation == null) {
			educationalInformation = new EducationalInformation();
			educationalInformation.setUser(user);
		}
		
		educationalInformation.setCountry(qualificationDetail.getCountry());
		educationalInformation.setState(qualificationDetail.getState());
		educationalInformation.setBoard(qualificationDetail.getBoard());
		educationalInformation.setUniversity(qualificationDetail.getUniversity());
		educationalInformation.setForeignBody_BoardUniversityName(qualificationDetail.getForeignBody_BoardUniversityName());
		educationalInformation.setForeignBody_AreaStdCodePhone(qualificationDetail.getForeignBody_AreaStdCodePhone());
		educationalInformation.setForeignBody_EmailId(qualificationDetail.getForeignBody_EmailId());
		educationalInformation.setForeignBody_URL(qualificationDetail.getForeignBody_URL());
		educationalInformation.setResultStatus(qualificationDetail.getResultStatus());
		educationalInformation.setStream(qualificationDetail.getStream());
		educationalInformation.setNoOfAttempts(qualificationDetail.getNoOfAttempts());
		educationalInformation.setAcademicYear(qualificationDetail.getAcademicYear());
		educationalInformation.setQualificationName(qualificationDetail.getQualificationName());
		educationalInformation.setQualificationLevel(qualificationLevelObject);
		educationalInformation.setQualificationProgram(qualificationDetail.getQualificationProgram());
		educationalInformation.setSpecialSubject(qualificationDetail.getSpecialSubject());
		educationalInformation.setOtherBodyName(qualificationDetail.getOtherBodyName());
		educationalInformation.setSchoolCollegeAddress(qualificationDetail.getSchoolCollegeAddress());
		educationalInformation.setCertifyingBody(qualificationDetail.getCertifyingBody());
		Boolean isLocalBody = qualificationDetail.getIsLocalBody() == 2 ? false : true;
		educationalInformation.setIsLocalBody(isLocalBody);
		educationalInformation.setSchoolCollegeName(qualificationDetail.getSchoolCollegeName());
		educationalInformation.setPassingMonth(qualificationDetail.getPassingMonth());
		educationalInformation.setPassingYear(qualificationDetail.getPassingYear());
		educationalInformation.setExamSeatNo(qualificationDetail.getExamSeatNo());
		educationalInformation.setMarksheetNo(qualificationDetail.getMarksheetNo());
		educationalInformation.setEvaluationType(qualificationDetail.getEvaluationType());
		educationalInformation.setMarksObtain(qualificationDetail.getMarksObtain());
		educationalInformation.setTotalMarks(qualificationDetail.getTotalMarks());
		educationalInformation.setPercentage(qualificationDetail.getPercentage());
		educationalInformation.setGrade(qualificationDetail.getGrade());
		educationalInformation.setCgpa(qualificationDetail.getCgpa());
		
		return educationalInformationService.saveEducationalInformation(educationalInformation);
	}
	
	public Boolean deleteQualificationDetail(User user, Integer qualificationId) {
		return educationalInformationService.deleteEducationalInformation(user, qualificationId);
	}
	
	private Integer maxAcademicYear = 3;
	
	private QualificationDetail createQualificationDetailObject(EducationalInformation educationalInformation)
	{
		EducationModel educationModel = new EducationModel();
		QualificationDetail qualificationDetail = educationModel.new QualificationDetail();
		
		if(educationalInformation != null) {
			qualificationDetail.setQualificationId(educationalInformation.getEducationalInformationId());
			qualificationDetail.setCountry(educationalInformation.getCountry());
			qualificationDetail.setState(educationalInformation.getState());
			qualificationDetail.setBoard(educationalInformation.getBoard());
			qualificationDetail.setUniversity(educationalInformation.getUniversity());
			qualificationDetail.setForeignBody_BoardUniversityName(educationalInformation.getForeignBody_BoardUniversityName());
			qualificationDetail.setForeignBody_AreaStdCodePhone(educationalInformation.getForeignBody_AreaStdCodePhone());
			qualificationDetail.setForeignBody_EmailId(educationalInformation.getForeignBody_EmailId());
			qualificationDetail.setForeignBody_URL(educationalInformation.getForeignBody_URL());
			qualificationDetail.setResultStatus(educationalInformation.getResultStatus());
			qualificationDetail.setStream(educationalInformation.getStream());
			qualificationDetail.setNoOfAttempts(educationalInformation.getNoOfAttempts());
			qualificationDetail.setAcademicYear(educationalInformation.getAcademicYear());
			qualificationDetail.setQualificationName(educationalInformation.getQualificationName());
			qualificationDetail.setQualificationGroup(educationalInformation.getQualificationLevel().getQualificationGroup());
			qualificationDetail.setQualificationGroupLevel(educationalInformation.getQualificationLevel().getQualificationGroupLevel());
			qualificationDetail.setQualificationLevel(educationalInformation.getQualificationLevel());
			qualificationDetail.setQualificationProgram(educationalInformation.getQualificationProgram());
			qualificationDetail.setSpecialSubject(educationalInformation.getSpecialSubject());
			qualificationDetail.setOtherBodyName(educationalInformation.getOtherBodyName());
			qualificationDetail.setSchoolCollegeAddress(educationalInformation.getSchoolCollegeAddress());
			qualificationDetail.setCertifyingBody(educationalInformation.getCertifyingBody());
			Integer body = educationalInformation.getIsLocalBody() == false ? 2 : 1;
			qualificationDetail.setIsLocalBody(body);
			qualificationDetail.setSchoolCollegeName(educationalInformation.getSchoolCollegeName());
			qualificationDetail.setPassingMonth(educationalInformation.getPassingMonth());
			qualificationDetail.setPassingYear(educationalInformation.getPassingYear());
			qualificationDetail.setExamSeatNo(educationalInformation.getExamSeatNo());
			qualificationDetail.setMarksheetNo(educationalInformation.getMarksheetNo());
			qualificationDetail.setEvaluationType(educationalInformation.getEvaluationType());
			qualificationDetail.setMarksObtain(educationalInformation.getMarksObtain());
			qualificationDetail.setTotalMarks(educationalInformation.getTotalMarks());
			qualificationDetail.setPercentage(educationalInformation.getPercentage());
			qualificationDetail.setGrade(educationalInformation.getGrade());
			qualificationDetail.setCgpa(educationalInformation.getCgpa());
		}
		/*qualificationDetail.setResultStatusList(Enums.ResultStatus.getEnumList());
		qualificationDetail.setCertifyingBodyList(Enums.CertifyingBody.getEnumList());
		qualificationDetail.setMonthList(Enums.Month.getEnumList());
		qualificationDetail.setStreamList(Enums.Stream.getEnumList());
		qualificationDetail.setCountryList(geoLocationService.getCountryList());
		qualificationDetail.setStateList(geoLocationService.getStateListByCountryName("India"));
		qualificationDetail.setAllIndiaBoardList(boardService.getBoardList(null));
		qualificationDetail.setAcademicYearList(Enums.AcademicYear.getEnumList(maxAcademicYear));
		
		TimeZone timeZone = TimeZone.getTimeZone("UTC");
		Calendar calendar = Calendar.getInstance(timeZone);
		int year = calendar.get(Calendar.YEAR);		
		qualificationDetail.setYearListRange(year);*/
		
		return qualificationDetail;
	}

	private void setDefaultData(Integer qualificationGroup, QualificationDetail qualificationDetail) {
		QualificationLevel qualificationGroupObject = qualificationLevelService.getQualificationGroup(qualificationGroup);
		List<QualificationLevel> qualificationGroupLevelList = qualificationLevelService.getSubQualificationLevels(qualificationGroup);
		List<QualificationProgram> programListOfQualification = qualificationProgramDao.getProgramListOfQualification(qualificationGroupObject);
		
		qualificationDetail.setqualificationGroupLevelList(qualificationGroupLevelList);
		qualificationDetail.setQualificationProgramList(programListOfQualification);
		
		qualificationDetail.setResultStatusList(Enums.ResultStatus.getEnumList());
		qualificationDetail.setCertifyingBodyList(Enums.CertifyingBody.getEnumList());
		qualificationDetail.setMonthList(Enums.Month.getEnumList());
		qualificationDetail.setStreamList(Enums.Stream.getEnumList());
		qualificationDetail.setCountryList(geoLocationService.getCountryList());
		qualificationDetail.setStateList(geoLocationService.getStateListByCountryName("India"));
		qualificationDetail.setAllIndiaBoardList(boardService.getBoardList(null));
		qualificationDetail.setAcademicYearList(Enums.AcademicYear.getEnumList(maxAcademicYear));
		
		TimeZone timeZone = TimeZone.getTimeZone("UTC");
		Calendar calendar = Calendar.getInstance(timeZone);
		int year = calendar.get(Calendar.YEAR);		
		qualificationDetail.setYearListRange(year);
		
	}

	private List<EducationModel.Qualification> generateQualificationHistory(List<EducationalInformation> educationalHistory) {
		List<QualificationLevel> qualificationGroupList = qualificationLevelService.getAllMainQualificationLevel();
		
		//Creating model
		List<EducationModel.Qualification> listOfQualification = new ArrayList<EducationModel.Qualification>();
		
		//Creating objects of main/default qualifications
		for(QualificationLevel qualificationLevel : qualificationGroupList) {
			EducationModel educationalModel = new EducationModel();
			Qualification qualification = educationalModel.new Qualification();
			qualification.setName(qualificationLevel.getName());
			qualification.setQualificationGroup(qualificationLevel.getQualificationGroup());
			listOfQualification.add(qualification);
		}
		
		/* creating objects of subqualifications from educational information and adding them in to 
		 * subqualification list which is in qualification object
		 * */ 
		for(EducationalInformation educationalInformation : educationalHistory) {
			int index = educationalInformation.getQualificationLevel().getQualificationGroup() - 1;
			Qualification qualification = listOfQualification.get(index);
			
			if(qualification.getSubQualificationList() == null) {
				qualification.setSubQualificationList(new ArrayList<SubQualification>());
			}
			
			//Creating subqualification object
			EducationModel educationalModel = new EducationModel();
			SubQualification subQualification = educationalModel.new SubQualification();
			subQualification.setSubQualificationId(educationalInformation.getEducationalInformationId());
			if(educationalInformation.getQualificationName() == null || educationalInformation.getQualificationName() == "") {
				subQualification.setName(educationalInformation.getQualificationLevel().getName());
			} else {
				subQualification.setName(educationalInformation.getQualificationName());
			}
			if(educationalInformation.getIsLocalBody()) {
				if(educationalInformation.getCertifyingBody() == Enums.CertifyingBody.Board.getId()
						&& educationalInformation.getBoard() != null)
					subQualification.setBoardOrUniversity(educationalInformation.getBoard().getBoardName());
				else if(educationalInformation.getCertifyingBody() == Enums.CertifyingBody.University.getId()
						&& educationalInformation.getUniversity() != null)
					subQualification.setBoardOrUniversity(educationalInformation.getUniversity().getUniversityName());
				else if(educationalInformation.getCertifyingBody() == Enums.CertifyingBody.Other.getId())
					subQualification.setBoardOrUniversity(educationalInformation.getOtherBodyName());
			} else {
				subQualification.setBoardOrUniversity(educationalInformation.getForeignBody_BoardUniversityName());
			}
			subQualification.setFacultyOrCollegeName(educationalInformation.getSchoolCollegeName());
			if(educationalInformation.getPassingMonth() != null) {
				subQualification.setPassingMonth(Enums.Month.get(educationalInformation.getPassingMonth()).name());
				subQualification.setPassingYear(educationalInformation.getPassingYear());
			}
			subQualification.setMarksObtain(educationalInformation.getMarksObtain());
			subQualification.setTotalMarks(educationalInformation.getTotalMarks());
			/*if(educationalInformation.getQualificationLevel() != null) {
				subQualification.setQualificationGroup(educationalInformation.getQualificationLevel().getQualificationGroup());
				subQualification.setQualificationGroupLevel(educationalInformation.getQualificationLevel().getQualificationGroupLevel());
			}*/
			subQualification.setQualificationLevel(educationalInformation.getQualificationLevel());
			subQualification.setQualificationProgram(educationalInformation.getQualificationProgram());
			
			qualification.getSubQualificationList().add(subQualification);			
		}
		
		return listOfQualification;
	}

	
}