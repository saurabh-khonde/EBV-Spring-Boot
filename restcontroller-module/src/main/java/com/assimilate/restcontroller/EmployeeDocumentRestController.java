package com.assimilate.restcontroller;

import static com.assimilate.common.EmployeeConstants.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assimilate.employee.EmployeeDocument;

import com.assimilate.exception.RecordNotFoundException;
import com.assimilate.service.EmployeeDocumentService;


@RestController
@RequestMapping(API)
public class EmployeeDocumentRestController {

	@Autowired
	public EmployeeDocumentService employeedocumentservice;
	
	@PostMapping("/savedocuments")
	public ResponseEntity<String> saveFamilyDetail(@RequestBody EmployeeDocument empd) {
		EmployeeDocument employeedoc = employeedocumentservice.saveDocuments(empd);
		if(employeedoc!=null) {
			return new ResponseEntity<String>("Documents saved successfully.... ",HttpStatus.OK);
		}
		else
			return new ResponseEntity<String>("There is an error while saving documents.... ",HttpStatus.NOT_FOUND);
	}

	
	@GetMapping("/getdocument")
    public ResponseEntity<?> getAllDetails(){
    	
    	List<EmployeeDocument> employeedocuments= employeedocumentservice.getAll();
    	
    	if(!employeedocuments.isEmpty())
    		return new ResponseEntity<List>(employeedocuments, HttpStatus.OK);
    	else
    		throw new RecordNotFoundException(" No Records Availble. ");
    }
    
}


