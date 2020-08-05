package com.assimilate.employee;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Entity
@Data
@Table(name = "employee")
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EmployeeId")
	private Integer employeeId;

	@NotEmpty(message = "Enter First Name")
	@Column(name = "FirstName")
	private String firstName;

	@NotEmpty(message = "Enter Last Name")
	@Column(name = "LastName")
	private String lastName;

	@Column(name = "DateOfBirth")
	private String dateOfBirth;

//	@Enumerated(EnumType.STRING)
//	@Column(name = "gender")
//	private Gender gender;
	
	@Column
	private String gender;

	//@NotEmpty(message = "Please Enter Mobile Number")
	//@Size(max =10, message = "Mobile Number Should Be 10 Digits")
	@Column(name = "MobileNo")
	private Long mobileNo;

	@Column(name = "CreatedAt", nullable = false, updatable = false)
	@CreatedDate
	@CreationTimestamp
	private Date createdAt;

	@Column(name = "UpdatedAt", nullable = false, updatable = false)
	@CreationTimestamp
	private Date updatedAt;

	@Column(name = "IsDeleted")
	private Boolean isDeleted;

//	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinColumn(name = "userId")
//	private UserEntity userEntity;
	
	@OneToOne()
	@JoinColumn(name = "userId")
	private UserEntity userEntity;


}
