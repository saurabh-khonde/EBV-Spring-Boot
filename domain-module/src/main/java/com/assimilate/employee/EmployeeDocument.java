package com.assimilate.employee; 

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import lombok.Data;
 
@Data
@Entity
public class EmployeeDocument {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EmpDocId")
	private Integer empDocId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="docTypeId")
	private DocumentType docType;		// e.g Aadhar Card
	
    @Lob @Basic(fetch = FetchType.LAZY)
    @Column(name="file", nullable=false)
    private byte[] file;				//	e.g byte aadhar.pdf
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="employeeId", nullable=false)
	private EmployeeEntity empEntity;
	
	@Column(name = "CreatedAt", nullable = false, updatable = false)
	@CreatedDate
	@CreationTimestamp
	private Date createdAt;

	@Column(name = "UpdatedAt", nullable = false, updatable = true)
	@CreatedDate
	@CreationTimestamp
	private Date updatedAt;
	
}
