package com.assimilate.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.assimilate.employee.EmployeeEntity;
import com.assimilate.employee.FamilyDetailsEntity;
import com.assimilate.exception.RecordNotFoundException;
import com.assimilate.service.FamilyDetailService;

import static com.assimilate.common.EmployeeConstants.*;

import java.util.List;

@RestController
@RequestMapping(API)
public class FamilyDetailRestController {
	
	@Autowired
	public FamilyDetailService familydetailservice;
	
	@PostMapping("/savedetails")
	public ResponseEntity<String> saveFamilyDetail(@RequestBody FamilyDetailsEntity fd) {
		FamilyDetailsEntity family = familydetailservice.saveFamily(fd);
		if(family!=null) {
			return new ResponseEntity<String>("Details saved successfully.... ",HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("There is an error while saving details.... ",HttpStatus.NOT_FOUND);
	}

	
	@GetMapping("/getdetails")
    public ResponseEntity<?> getAllDetails(){
    	
    	List<FamilyDetailsEntity> familydetail=familydetailservice.getAll();
    	
    	if(!familydetail.isEmpty())
    		return new ResponseEntity<List>(familydetail, HttpStatus.OK);
    	else
    		throw new RecordNotFoundException(" No Records Availble. ");
    }
    
}
