package com.assimilate.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assimilate.employee.EmploymentDetailsEntity;
import com.assimilate.employee.EmploymentDetailsRepository;
import com.assimilate.service.EmploymentDetailsService;


@Service
public class EmploymentDetailsServiceImpl implements EmploymentDetailsService{
	
	@Autowired
	private EmploymentDetailsRepository employmentDetailsRepository; 
	

	@Override
	public EmploymentDetailsEntity saveEmploymentDetails(EmploymentDetailsEntity employmentDetailsEntity) {
		employmentDetailsRepository.save(employmentDetailsEntity);
		return employmentDetailsEntity;
		
		
	}


	@Override
	public List<EmploymentDetailsEntity> allEmploymentDetails() {
		List<EmploymentDetailsEntity> list=employmentDetailsRepository.findAll();
		return list;
	}

}
