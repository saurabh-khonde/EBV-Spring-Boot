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
@Table(name="country")
public class CountryEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CountryId")
	private Integer countryId;
	
	@Column(name="CountryName")
	private String countryName;
	
	@OneToMany(targetEntity=StateEntity.class,cascade=CascadeType.ALL)
	@JoinColumn(name="CountryId",referencedColumnName="CountryId")
	private List<StateEntity> stateEntity;
	
	
	

}
