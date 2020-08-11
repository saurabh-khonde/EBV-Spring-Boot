package com.assimilate.service;

import java.util.List;

import com.assimilate.employee.EducationDetailsEntity;
import com.assimilate.employee.FamilyDetailsEntity;

public interface EducationDetailsService {

	
	public EducationDetailsEntity saveEducation(EducationDetailsEntity ed);

	public List<EducationDetailsEntity> getAll();
}
