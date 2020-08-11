package com.assimilate.employee;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Data
@Entity
@Table(name="employmentdetails")
public class EmploymentDetailsEntity {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="EmpCompanyID")
	private Integer empCompanyId;
	
	//@NotNull
	@Column(name="CompanyName")
	private String companyName;
	
	@Column(name="CompanyAddress")
	private String companyAddress;
	
	
	@OneToOne
	@JoinColumn(name="IndustryType")
	private EmploymentIndustryTypeEntity employmentIndustryType;
	
	@Column(name="Designation")
	private  String designation;
	
	@Column(name="EmploymentType")
	private  String  employmentType;
	
	@Column(name="WorkFrom")
	private  Date  workFrom;
	
	@Column(name="WorkTill")
	private   Date workTill;
	
	@Column(name="Salary")
	private double  salary;
	
	@Column(name="SupervisiorName")
	private  String supervisiorName;
	
	@Column(name="SupervisiorContactNumber")
	private int supervisiorContactNumber;
	
	@Column(name="SupervisiorEmail")
	private String supervisiorEmail;
	
	@Column(name="ReasonForLeaving")
	private  String reasonForLeaving;
	
	@Column(name="EligibleForRehire")
	private   boolean  eligibleForRehire;
	
	@Column(name="AgencyName")
	private  String agencyName;
	
	
	@Column(name = "CreatedAt", nullable = false, updatable = true)
	@CreatedDate
	@CreationTimestamp
	private Date createdAt;
	
	@Column(name="UpdatedAt")
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;
	
	@Column(name="UpdatedBy")
	private String  updatedBy;
	
	@Column(name="IsDeleted")
	private Boolean  isDeleted;
	

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="employeeId", nullable=false)
	private EmployeeEntity employeeEntity;
	

}
