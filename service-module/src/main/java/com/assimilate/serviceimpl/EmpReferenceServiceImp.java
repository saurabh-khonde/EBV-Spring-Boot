package com.assimilate.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assimilate.employee.EmployeeReference;
import com.assimilate.employee.ReferenceRepository;
import com.assimilate.service.EmpReferenceService;


@Service
public class EmpReferenceServiceImp implements EmpReferenceService{
	
	@Autowired
	private ReferenceRepository refRepository;
	
	@Override
	public EmployeeReference addEmpRef(EmployeeReference empRef)
	{
		EmployeeReference ref = refRepository.save(empRef);
		return ref;
	}
	
	@Override
	public List<EmployeeReference> getAllRef()
	{
		List<EmployeeReference> empRefList = refRepository.findAll();
		return empRefList;
	}

}
