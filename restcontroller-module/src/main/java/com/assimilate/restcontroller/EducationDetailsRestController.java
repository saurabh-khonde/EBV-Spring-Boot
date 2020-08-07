package com.assimilate.restcontroller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assimilate.employee.EducationDetailsEntity;
import com.assimilate.employee.FamilyDetailsEntity;
import com.assimilate.exception.RecordNotFoundException;
import com.assimilate.service.EducationDetailsService;
import com.assimilate.service.FamilyDetailService;


@RestController
//@RequestMapping("/api/employee")
public class EducationDetailsRestController {
	@Autowired
	public EducationDetailsService eds;
	
	@PostMapping("/api/employee/postEducationDetails")
	public ResponseEntity<String> saveEducationDetails(@RequestBody EducationDetailsEntity ed) {
		EducationDetailsEntity education = eds.saveEducation(ed);
		if(education!=null) {
			return new ResponseEntity<String>("Details saved successfully.... ",HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("There is an error while saving details.... ",HttpStatus.NOT_FOUND);
	}

	@GetMapping("/api/employee/getEducationDetails")
    public ResponseEntity<?> getAllDetails(){
    	
    	List<EducationDetailsEntity> educationdetail=eds.getAll();
    	
    	if(!educationdetail.isEmpty())
    		return new ResponseEntity<List>(educationdetail,HttpStatus.OK);
    	else
    		throw new RecordNotFoundException(" No Records Availble. ");
    } 

}
