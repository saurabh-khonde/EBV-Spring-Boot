package com.assimilate.employee;

import java.util.Date;
import java.util.UUID;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class ConfirmationToken {

	  @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name="token_id")
	    private long tokenid;

	    @Column(name="confirmation_token")
	    private String confirmationToken;

	    @Temporal(TemporalType.TIMESTAMP)
	    private Date createdDate;

	    @OneToOne(targetEntity = EmployeeEntity.class, fetch = FetchType.EAGER)
	    @JoinColumn(nullable = false, name = "EmployeeId")
	    private EmployeeEntity empEntity;

	    
	    public ConfirmationToken() {
			
		}

		public ConfirmationToken(EmployeeEntity empEntity) {
	        this.empEntity = empEntity;
	        createdDate = new Date();
	        confirmationToken = UUID.randomUUID().toString();
	    }
}