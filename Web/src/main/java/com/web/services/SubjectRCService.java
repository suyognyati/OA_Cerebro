package com.web.services;

import com.web.model.SubjectModel;

public interface SubjectRCService {

	SubjectModel getSubjectsByProgram(Integer collegeId, Integer programId);
}
