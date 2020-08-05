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

import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import lombok.Data;
@Data
@Entity
@Table(name="familydetails")
public class FamilyDetailsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "FdId")
	private Integer fdID;
	
	@Column(name="FirstName")
	private String firstName;
	
	@Column(name="LastName")
	private String lastName;
	
	@Column(name="DateOfBirth")
	private Date dateOfBirth;
	
	@Column(name="Occupation")
	private String occupation;
	
	@Column(name="Relation")
	private String relation;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="MobileNumber")
	private Long mobileNumber;

	@Column(name = "CreatedAt", nullable = false, updatable = false)
	@CreatedDate
	@CreationTimestamp
	private Date createdAt;

	@Column(name = "UpdatedAt", nullable = false, updatable = true)
	@CreationTimestamp
	private Date updatedAt;

	@Column(name = "IsDeleted")
	private Boolean isDeleted;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="employeeId")
	private EmployeeEntity employeeEntity;
}
