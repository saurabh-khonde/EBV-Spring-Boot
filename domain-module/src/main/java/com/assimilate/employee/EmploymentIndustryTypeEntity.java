package com.assimilate.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="employmentindustrytype")
public class EmploymentIndustryTypeEntity {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="EmpIndID")
	private int  empIndID;
	
	@Column(name="IndustryName")
	private String industryName;
	
	
	
	

}
