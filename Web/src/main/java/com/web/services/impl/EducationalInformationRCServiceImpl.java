package com.web.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.data.entities.EducationalInformation;
import com.data.entities.Enums;
import com.data.entities.QualificationLevel;
import com.data.entities.User;
import com.data.services.EducationalInformationService;
import com.data.services.QualificationLevelService;
import com.web.model.EducationModel;
import com.web.model.EducationModel.Qualification;
import com.web.model.EducationModel.QualificationDetail;
import com.web.model.EducationModel.SubQualification;
import com.web.services.EducationalInformationRCService;
import com.web.session.Session;


@Service("educationalInformationRCService")
public class EducationalInformationRCServiceImpl implements EducationalInformationRCService {

	@Autowired
	Session session;
	
	@Autowired
	EducationalInformationService educationalInformationService;
	
	@Autowired
	QualificationLevelService qualificationLevelService;
	
	public List<EducationModel.Qualification> getListofQualification(){
		List<EducationalInformation> educationalInformationListofUserAsc = educationalInformationService.getByUserOrderByQualificationLevelAsc(session.getCurrentUser());
		
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
			
			if(qualification.getSubQualificationList() == null)
				qualification.setSubQualificationList(new ArrayList<SubQualification>());
			
			//Creating subqualification object
			EducationModel educationalModel = new EducationModel();
			SubQualification subQualification = educationalModel.new SubQualification();
			if(educationalInformation.getQualificationName() == null || educationalInformation.getQualificationName() == "") {
				subQualification.setName(educationalInformation.getQualificationLevel().getName());
			} else {
				subQualification.setName(educationalInformation.getQualificationName());
			}
			if(educationalInformation.getCertifyingBody() == Enums.CertifyingBody.Board.getId())
				subQualification.setBoardOrUniversity("Board"/*educationalInformation.getNameOfBoard()*/);
			else if(educationalInformation.getCertifyingBody() == Enums.CertifyingBody.University.getId())
				subQualification.setBoardOrUniversity("University"/*educationalInformation.getNameOfUniversity()*/);
			subQualification.setFacultyOrCollegeName(educationalInformation.getSchoolCollegeName());
			subQualification.setPassingMonth(Enums.Month.get(educationalInformation.getPassingMonth()).name());
			subQualification.setPassingYear(educationalInformation.getPassingYear());
			subQualification.setMarksObtain(educationalInformation.getMarksObtain());
			subQualification.setTotalMarks(educationalInformation.getTotalMarks());
			qualification.getSubQualificationList().add(subQualification);			
		}
		
		return listOfQualification;

	}

	
	public QualificationDetail getQualificationDetail(User user, Integer qualificationLevel) {
		QualificationLevel qualificationLevelObject = qualificationLevelService.getById(qualificationLevel);
		EducationalInformation educationalInformation = educationalInformationService.getByUserAndQualificationLevel(user, qualificationLevelObject);
		
		EducationModel educationModel = new EducationModel();
		QualificationDetail qualificationDetail = educationModel.new QualificationDetail();
		
		if(educationalInformation != null) {
			qualificationDetail.setCountry(educationalInformation.getCountry());
			qualificationDetail.setState(educationalInformation.getState());
			qualificationDetail.setNameOfBoard(educationalInformation.getNameOfBoard());
			qualificationDetail.setNameOfUniversity(educationalInformation.getNameOfUniversity());
			qualificationDetail.setForeignBody_AreaStdCodePhone(educationalInformation.getBoardUniversity_AreaStdCodePhone());
			qualificationDetail.setForeignBody_EmailId(educationalInformation.getBoardUniversity_EmailId());
			qualificationDetail.setForeignBody_URL(educationalInformation.getBoardUniversity_URL());
			qualificationDetail.setResultStatus(educationalInformation.getResultStatus());
			qualificationDetail.setStream(educationalInformation.getStream());
			qualificationDetail.setNoOfAttempts(educationalInformation.getNoOfAttempts());
			qualificationDetail.setQualificationName(educationalInformation.getQualificationName());
			qualificationDetail.setQualificationLevel(educationalInformation.getQualificationLevel().getQualificationLevelId());
			qualificationDetail.setSpecialSubject(educationalInformation.getSpecialSubject());
			qualificationDetail.setOtherBodyName(educationalInformation.getOtherBodyName());
			qualificationDetail.setSchoolCollegeAddress(educationalInformation.getSchoolCollegeAddress());
			qualificationDetail.setCertifyingBody(educationalInformation.getCertifyingBody());
			qualificationDetail.setIsLocalBody(educationalInformation.getIsLocalBody());
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
		return qualificationDetail;
	}	
}