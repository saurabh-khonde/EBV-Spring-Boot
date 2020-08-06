package com.assimilate.service;

import java.util.List;

import com.assimilate.employee.EmployeeDocument;


public interface EmployeeDocumentService {
	
	public EmployeeDocument saveDocuments(EmployeeDocument empd);

	public List<EmployeeDocument> getAll();
}
