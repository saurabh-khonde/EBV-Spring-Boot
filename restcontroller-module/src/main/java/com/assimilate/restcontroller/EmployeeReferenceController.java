package com.assimilate.restcontroller;

import static com.assimilate.common.EmployeeConstants.API;

import java.util.List;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.assimilate.employee.EmployeeReference;
import com.assimilate.exception.RecordNotFoundException;
import com.assimilate.service.EmpReferenceService;

@CrossOrigin("*")
@RestController
@RequestMapping(API)
public class EmployeeReferenceController {

	@Autowired
	private EmpReferenceService empRefeService;
	
	@PostMapping("/addRef")
	public ResponseEntity<String> postEmpReference(@RequestBody EmployeeReference empRef)
	{
		EmployeeReference addEmpRef = empRefeService.addEmpRef(empRef);
		if(addEmpRef!=null)
			return new ResponseEntity<String>("Record Saved Succesfully.", HttpStatus.OK);
		else
			return new ResponseEntity<String>("*Record Not Saved .", HttpStatus.NOT_FOUND);
	}

	
	@GetMapping("/getAllRef")
	public ResponseEntity<?> getAllEmpReference() 
	{
		List<EmployeeReference> empRefList = empRefeService.getAllRef();
		
		if(!empRefList.isEmpty())
			return new ResponseEntity<List>(empRefList,HttpStatus.OK);
		else
			throw new RecordNotFoundException("Record Not available");
		
	}
}
 