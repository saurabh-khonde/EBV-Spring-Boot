package com.assimilate.employee;



import java.util.Date;

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

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;

@Entity
@Data
@Table(name="educationdetails")
public class EducationDetailsEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "EdId")
	private Integer educationDetailsId;
    
	@Column(name="Qualification")
	private String qualification;
	
	@Column(name="Univercity")
	private String univercity;
	
	@Column(name="CollegeName")
	private String collegeName;
	
	@Column(name="Stream")
	private String stream;
	
	@Column(name="YearOfPassing")
	private Integer yearOfPassing;
	
	@Column(name="Type")
	private String type;
	
	@Column(name="Percentage")
	private float percentage;
	
	@Column(name="IsYearGap")
	private String isYearGap;
	
	@Column(name="NoOfYearGap")
	private Integer noOfYearGap;
	
	@Column(nullable = false,updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date Create_At;
	
	
	@Column(nullable = false,updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
    private Date Updated_At;
	
	@Column(name="IsDeleted")
	private Boolean isDeleted;
	
	@ManyToOne
	@JoinColumn(name="EmployeeId")
	private EmployeeEntity employee;

}