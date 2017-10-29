package com.web.services;

import java.util.List;

import com.web.model.SubjectModel;

public interface SubjectRCService {

	List<SubjectModel> getBachelorSubject(Integer courseId);
}
