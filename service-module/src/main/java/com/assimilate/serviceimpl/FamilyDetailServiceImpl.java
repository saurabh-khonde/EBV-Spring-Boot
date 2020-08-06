package com.assimilate.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assimilate.employee.FamilyDetailRepository;
import com.assimilate.employee.FamilyDetailsEntity;
import com.assimilate.service.FamilyDetailService;

@Service
public class FamilyDetailServiceImpl implements FamilyDetailService {
		
	@Autowired
	public FamilyDetailRepository familydetailrepository;

	@Override
	public FamilyDetailsEntity saveFamily(FamilyDetailsEntity fd) {
		
		return familydetailrepository.save(fd);
	}

	@Override
	public List<FamilyDetailsEntity> getAll() {
		
		return familydetailrepository.findAll();
	}
	
	
}
