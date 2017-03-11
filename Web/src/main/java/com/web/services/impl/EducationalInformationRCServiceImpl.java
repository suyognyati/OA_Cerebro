package com.web.services.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.EducationalInformation;
import com.data.entities.Enums;
import com.data.entities.QualificationLevel;
import com.data.entities.User;
import com.data.services.BoardService;
import com.data.services.EducationalInformationService;
import com.data.services.GeoLocationsService;
import com.data.services.QualificationLevelService;
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
	GeoLocationsService geoLocationService;
	
	@Autowired
	BoardService boardService;
	
	@Override
	public List<EducationModel.Qualification> getListofQualification(User user){
		List<EducationalInformation> educationalInformationListofUserAsc = educationalInformationService.getByUserOrderByQualificationLevelAsc(user);
		
		List<QualificationLevel> qualificationLevelListAsc = qualificationLevelService.getAllMainQualificationOrderByQualificationMainLevel(true);
		
		List<EducationModel.Qualification> listOfQualification = new ArrayList<EducationModel.Qualification>();
		
		//Creating objects of main/default qualifications
		for(QualificationLevel qualificationLevel : qualificationLevelListAsc) {
			EducationModel educationalModel = new EducationModel();
			Qualification qualification = educationalModel.new Qualification();
			qualification.setName(qualificationLevel.getName());
			qualification.setQualificationMainLevel(qualificationLevel.getQualificationMainLevel());
			listOfQualification.add(qualification);
		}
		
		/* creating objects of subqualifications from educational information and adding them in to 
		 * subqualification list which is in qualification object
		 * */ 
		for(EducationalInformation educationalInformation : educationalInformationListofUserAsc) {
			int index = educationalInformation.getQualificationLevel().getQualificationMainLevel() - 1;
			Qualification qualification = listOfQualification.get(index);
			
			if(qualification.getSubQualificationList() == null) {
				qualification.setSubQualificationList(new ArrayList<SubQualification>());
			}
			
			//Creating subqualification object
			EducationModel educationalModel = new EducationModel();
			SubQualification subQualification = educationalModel.new SubQualification();
			if(educationalInformation.getQualificationName() == null || educationalInformation.getQualificationName() == "") {
				subQualification.setName(educationalInformation.getQualificationLevel().getName());
			} else {
				subQualification.setName(educationalInformation.getQualificationName());
			}
			if(educationalInformation.getCertifyingBody() == Enums.CertifyingBody.Board.getId()
					&& educationalInformation.getBoard() != null)
				subQualification.setBoardOrUniversity(educationalInformation.getBoard().getBoardName());
			else if(educationalInformation.getCertifyingBody() == Enums.CertifyingBody.University.getId())
				subQualification.setBoardOrUniversity("University"/*educationalInformation.getNameOfUniversity()*/);
			subQualification.setFacultyOrCollegeName(educationalInformation.getSchoolCollegeName());
			if(educationalInformation.getPassingMonth() != null) {
				subQualification.setPassingMonth(Enums.Month.get(educationalInformation.getPassingMonth()).name());
				subQualification.setPassingYear(educationalInformation.getPassingYear());
			}
			subQualification.setMarksObtain(educationalInformation.getMarksObtain());
			subQualification.setTotalMarks(educationalInformation.getTotalMarks());
			if(educationalInformation.getQualificationLevel() != null) {
				subQualification.setQualificationMainLevel(educationalInformation.getQualificationLevel().getQualificationMainLevel());
				subQualification.setQualificationSubLevel(educationalInformation.getQualificationLevel().getQualificationSubLevel());
			}
			qualification.getSubQualificationList().add(subQualification);			
		}
		
		return listOfQualification;

	}
	
	@Override
	public QualificationDetail getQualificationDetail(User user, Integer qualificationMainLevel, Integer qualificationSubLevel) {
		QualificationLevel qualificationLevelObject = qualificationLevelService.getByMainAndSubLevel(qualificationMainLevel, qualificationSubLevel);
		EducationalInformation educationalInformation = educationalInformationService.getByUserAndQualificationLevel(user, qualificationLevelObject);
		
		EducationModel educationModel = new EducationModel();
		QualificationDetail qualificationDetail = educationModel.new QualificationDetail();
		
		if(educationalInformation != null) {
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
			qualificationDetail.setQualificationName(educationalInformation.getQualificationName());
			qualificationDetail.setQualificationMainLevel(educationalInformation.getQualificationLevel().getQualificationMainLevel());
			qualificationDetail.setQualificationSubLevel(educationalInformation.getQualificationLevel().getQualificationSubLevel());
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
		qualificationDetail.setResultStatusList(Enums.ResultStatus.getEnumList());
		qualificationDetail.setCertifyingBodyList(Enums.CertifyingBody.getEnumList());
		qualificationDetail.setMonthList(Enums.Month.getEnumList());
		qualificationDetail.setStreamList(Enums.Stream.getEnumList());
		qualificationDetail.setCountryList(geoLocationService.getCountryList());
		qualificationDetail.setStateList(geoLocationService.getStateListByCountryName("India"));
		qualificationDetail.setAllIndiaBoardList(boardService.getBoardList(null));
		
		TimeZone timeZone = TimeZone.getTimeZone("UTC");
		Calendar calendar = Calendar.getInstance(timeZone);
		int year = calendar.get(Calendar.YEAR);
		
		qualificationDetail.setYearListRange(year);
		
		return qualificationDetail;
	}

	public QualificationDetail getNewQualification(User user, Integer qualificationMainLevel) {
		EducationModel educationModel = new EducationModel();
		QualificationDetail qualificationDetail = educationModel.new QualificationDetail();
		
		if(qualificationMainLevel < 4) {
			return getQualificationDetail(user, qualificationMainLevel, 0);
		}
		
		qualificationDetail.setResultStatusList(Enums.ResultStatus.getEnumList());
		qualificationDetail.setCertifyingBodyList(Enums.CertifyingBody.getEnumList());
		qualificationDetail.setMonthList(Enums.Month.getEnumList());
		qualificationDetail.setStreamList(Enums.Stream.getEnumList());
		qualificationDetail.setCountryList(geoLocationService.getCountryList());
		qualificationDetail.setStateList(geoLocationService.getStateListByCountryName("India"));
		qualificationDetail.setAllIndiaBoardList(boardService.getBoardList(null));
		
		TimeZone timeZone = TimeZone.getTimeZone("UTC");
		Calendar calendar = Calendar.getInstance(timeZone);
		int year = calendar.get(Calendar.YEAR);
		
		qualificationDetail.setYearListRange(year);
		
		return qualificationDetail;
	}
	
	@Override
	public Boolean saveQualificationDetail(User user, QualificationDetail qualificationDetail) {
		//Getting qualificationlevelobject to search for respected educational information
		QualificationLevel qualificationLevelObject = qualificationLevelService.getByMainAndSubLevel(qualificationDetail.getQualificationMainLevel(), qualificationDetail.getQualificationSubLevel());
		if(qualificationLevelObject == null)
			return false;
		
		EducationalInformation educationalInformation = null;
		//Finding educational information for qualification level of user
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
		educationalInformation.setQualificationName(qualificationDetail.getQualificationName());
		educationalInformation.setQualificationLevel(qualificationLevelObject);
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
}