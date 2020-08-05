package com.assimilate.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assimilate.employee.EmployeeEntity;
import com.assimilate.employee.EmployeeRepository;
import com.assimilate.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<EmployeeEntity> getAll() {
		List<EmployeeEntity> employeeEntity=employeeRepository.findAll();
		return employeeEntity;
	}

	@Override
	public void saveEmp(EmployeeEntity ee) {
		employeeRepository.save(ee);
	}

}