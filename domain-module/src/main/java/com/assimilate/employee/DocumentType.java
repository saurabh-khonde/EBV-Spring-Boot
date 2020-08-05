package com.assimilate.employee; 

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import lombok.Data;
 
@Data
@Entity
public class DocumentType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DocTypeId")
	private Integer docTypeId;
	
	@Column(name = "DocTypeName")
	private String docTypeName;

	
}
