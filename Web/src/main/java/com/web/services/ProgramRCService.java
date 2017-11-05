package com.web.services;

import java.util.List;

import com.web.model.CourseModel;

public interface ProgramRCService {

	List<CourseModel> getProgramsByCategory(Integer programCategoryId);
}
