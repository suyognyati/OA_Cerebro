package com.web.services;

import com.web.model.GenerateMeritListModel;

public interface GenerateMeritListRCService {
	GenerateMeritListModel getMeritList(Integer collegeId, Integer programId);
}
