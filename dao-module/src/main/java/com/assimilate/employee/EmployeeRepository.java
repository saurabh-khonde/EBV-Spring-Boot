package com.assimilate.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assimilate.employee.EmployeeEntity;



@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer>{

	
}
