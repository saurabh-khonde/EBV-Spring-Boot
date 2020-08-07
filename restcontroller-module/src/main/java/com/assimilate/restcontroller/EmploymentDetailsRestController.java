package com.assimilate.restcontroller;

import static com.assimilate.common.EmployeeConstants.API;
import static com.assimilate.common.EmployeeConstants.All_Employment_Details;
import static com.assimilate.common.EmployeeConstants.SAVE_EMPLOYMENT_DETAILS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assimilate.employee.EmploymentDetailsEntity;
import com.assimilate.service.EmploymentDetailsService;

@RestController
@RequestMapping(API)
public class EmploymentDetailsRestController {
	
	@Autowired
	private EmploymentDetailsService employmentDetailsService;
	
	@PostMapping(SAVE_EMPLOYMENT_DETAILS)
	public ResponseEntity<Object> saveEmploymentDetails(@RequestBody EmploymentDetailsEntity employmentDetailsEntity) {
		employmentDetailsService.saveEmploymentDetails(employmentDetailsEntity);
		return new ResponseEntity<Object>(employmentDetailsEntity,HttpStatus.OK);
	}
	
	@GetMapping(All_Employment_Details)
	public List<EmploymentDetailsEntity> allEmploymentDetails(){
		List<EmploymentDetailsEntity> list= employmentDetailsService.allEmploymentDetails();
		return list;
	}

}
