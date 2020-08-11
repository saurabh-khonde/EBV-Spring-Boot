package com.assimilate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assimilate.employee.EmployeeReference;
import com.assimilate.employee.ReferenceRepository;


@Service
public interface EmpReferenceService {
	
	
	public EmployeeReference addEmpRef(EmployeeReference empRef);
	
	public List<EmployeeReference> getAllRef();

}
