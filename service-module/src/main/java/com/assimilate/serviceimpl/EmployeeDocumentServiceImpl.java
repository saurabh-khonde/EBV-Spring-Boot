package com.assimilate.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assimilate.employee.EmployeeDocument;
import com.assimilate.employee.EmployeeDocumentRepository;
import com.assimilate.service.EmployeeDocumentService;

@Service
public class EmployeeDocumentServiceImpl implements EmployeeDocumentService {
	
	@Autowired
	public EmployeeDocumentRepository employeedocumentrepository;
	
	@Override
	public EmployeeDocument saveDocuments(EmployeeDocument empd) {
		
		return employeedocumentrepository.save(empd);
	}

	@Override
	public List<EmployeeDocument> getAll() {
		// TODO Auto-generated method stub
		return employeedocumentrepository.findAll();
	}

}
