package com.assimilate.restcontroller;

import static com.assimilate.common.EmployeeConstants.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.assimilate.common.EmployeeConstants;
import com.assimilate.employee.AddressdetailsEntity;
import com.assimilate.service.AddressdetailsService;

@RestController
@RequestMapping(API)
public class AddressdetailsRestController {
	
	@Autowired
	AddressdetailsService addressdetailsService;

	@PostMapping(EmployeeConstants.POST_USER)
	public AddressdetailsEntity postUser(@RequestBody AddressdetailsEntity addressdetailsEntity )
	{
		addressdetailsService.postUser(addressdetailsEntity);
		return addressdetailsEntity;
		}
	
@GetMapping(EmployeeConstants.GET_ALL)
public List<AddressdetailsEntity> getAllUser() {
	
	List<AddressdetailsEntity> addressdetailsEntity=addressdetailsService.getAllUser();
	
	return addressdetailsEntity;
}

	
	
}
