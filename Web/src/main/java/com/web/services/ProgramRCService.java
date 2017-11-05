package com.web.services;

import java.util.List;

import com.web.model.ProgramModel;

public interface ProgramRCService {

	List<ProgramModel> getProgramsByCategory(Integer collegeId, Integer programCategoryId);
}
