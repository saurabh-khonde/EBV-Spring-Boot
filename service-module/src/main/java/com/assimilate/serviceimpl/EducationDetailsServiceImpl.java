package com.assimilate.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assimilate.employee.EducationDetailsEntity;
import com.assimilate.employee.EducationDetailsRepository;
import com.assimilate.employee.FamilyDetailRepository;
import com.assimilate.service.EducationDetailsService;
import com.assimilate.service.FamilyDetailService;

@Service
public class EducationDetailsServiceImpl implements EducationDetailsService {
	
	
	@Autowired
	public EducationDetailsRepository educationdetailsrepository;

	@Override
	public EducationDetailsEntity saveEducation(EducationDetailsEntity ed) {
		
		return  educationdetailsrepository.save(ed);
	}

	@Override
	public List<EducationDetailsEntity> getAll() {
		
		return educationdetailsrepository.findAll() ;
	}

}
