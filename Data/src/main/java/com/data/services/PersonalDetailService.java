package com.data.services;

import com.data.entities.PersonalDetail;
import com.data.entities.Student;

public interface PersonalDetailService {
	PersonalDetail getByStudent(Student student);
	void save(PersonalDetail personalDetail);
}
