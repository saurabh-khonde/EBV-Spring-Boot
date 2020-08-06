package com.assimilate.service;

import java.util.List;

import com.assimilate.employee.EmployeeEntity;
import com.assimilate.employee.FamilyDetailsEntity;

public interface FamilyDetailService {

	public FamilyDetailsEntity saveFamily(FamilyDetailsEntity fd);

	public List<FamilyDetailsEntity> getAll();
}
