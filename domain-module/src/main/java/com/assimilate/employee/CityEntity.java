package com.assimilate.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="city")
public class CityEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CityId")
	private Integer cityId;
	
	@Column(name="CityName")
	private String cityName;
	
	@Column(name="StateId")
	private Integer stateId;
}


