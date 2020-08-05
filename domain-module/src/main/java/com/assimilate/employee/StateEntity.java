package com.assimilate.employee;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Entity
@Data
@Table(name="state")
public class StateEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="StateId")
	private Integer stateId;
	
	@Column(name="StateName")
	private String stateName;
	
	@Column(name="CountryId")
	private Integer countryId;
	
	@OneToMany(targetEntity=CityEntity.class,cascade=CascadeType.ALL)
	@JoinColumn(name="StateId",referencedColumnName="StateId")
	private List<CityEntity> cityEntity;

	
	

}

