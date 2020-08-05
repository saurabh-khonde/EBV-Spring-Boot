package com.assimilate.employee;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import lombok.*; 

@Data
@Entity
public class EmployeeReference{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer empRefId;
	
	@Column(name = "FirstName")
	private String firstName;
	 
	@Column(name = "LastName")
	private String lastName;
	
	@Column(name = "Designation")
	private String designation;  
	
	@Column(name = "Relationship")
	private String relationship;
	
	@Column(name = "MobileNumber")
	private Long mobileNumber;
	
	@Column(name = "EmailId")
	private String emailId;
	
	@Column(name = "CreatedAt", nullable = false, updatable = false)
	@CreatedDate
	@CreationTimestamp
	private Date createdAt;

	@Column(name = "UpdatedAt", nullable = false, updatable = true)
	@CreatedDate
	@CreationTimestamp
	private Date updatedAt;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="employeeId", nullable=false)
	private EmployeeEntity empEntity;

}

