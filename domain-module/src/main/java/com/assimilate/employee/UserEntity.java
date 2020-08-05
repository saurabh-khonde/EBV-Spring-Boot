package com.assimilate.employee;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import com.sun.istack.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "user")
public class UserEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "UserId")
	private Integer userId;

	@Email
	@NotEmpty(message = "Enter Valid Email Address")
	@Column(name = "EmailId")
	private String emailId;

	@Column(name = "Password")
	private String password;

	@Column(name = "Role")
	private String role;

	@Column(name = "CreatedAt", nullable = false, updatable = false)
	@CreatedDate
	@CreationTimestamp
	private Date createdAt;

	@Column(name = "IsActive")
	private Boolean isActive;

	@Column(name = "UpdatedAt", nullable = false, updatable = false)
	@CreationTimestamp
	private Date updatedAt;

//	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "userEntity")
//	private EmployeeEntity employeeEntity;
}
