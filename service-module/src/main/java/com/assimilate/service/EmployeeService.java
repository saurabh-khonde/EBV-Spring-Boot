package com.assimilate.service;

import java.util.List;

import com.assimilate.employee.EmployeeEntity;

public interface EmployeeService {

	public List<EmployeeEntity> getAll();
	
	public void saveEmp(EmployeeEntity ee);

}
