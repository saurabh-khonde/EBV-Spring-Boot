package com.assimilate.employee;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.Data;

@Entity
	@Data
	@Table(name="addressdetails")
	@EntityListeners(AuditingEntityListener.class)
	public class AddressdetailsEntity {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="AddID")
		private Integer addId;
		
		@Column(name="Type")
		private String type;
		
		@Column(name="Line1")
		private String line1;
		
		@Column(name="Line2")
		private String line2;
		
		@Column(name="Area")
		private String area;
		
		@Column(name="Pincode")
		private Integer pincode;
		
		@OneToOne(cascade=CascadeType.MERGE)
		@JoinColumn(name="CountryId")
		private CountryEntity countryEntity;
		
		@OneToOne(cascade=CascadeType.MERGE)
		@JoinColumn(name="StateId")
		private StateEntity stateEntity;
		
		
		@OneToOne(cascade=CascadeType.MERGE)
		@JoinColumn(name="CityId")
		private CityEntity cityEntity;
		
		@Column(name="CreatedAt",nullable=false,updatable=false)
		@CreatedDate
		@CreationTimestamp
		private Date createdAt;
		
		@Column(name="UpdatedAt",nullable=false,updatable=false)
		@CreatedDate
		@CreationTimestamp
		private Date updatedAt;
		
		@Column(name="IsDeleted")
		private boolean isDeleted;
		
		@OneToOne(cascade=CascadeType.MERGE)
		@JoinColumn(name="employeeId")
		private EmployeeEntity employeeEntity;
		}



