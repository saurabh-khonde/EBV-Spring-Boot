package com.assimilate.service;

import java.util.List;

import com.assimilate.employee.EmploymentDetailsEntity;

public interface EmploymentDetailsService {

	EmploymentDetailsEntity saveEmploymentDetails(EmploymentDetailsEntity employmentDetailsEntity);

	List<EmploymentDetailsEntity> allEmploymentDetails();
	
	

}
