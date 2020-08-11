package com.assimilate.restcontroller;
import static com.assimilate.common.EmployeeConstants.API;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.assimilate.common.EmployeeConstants;
import com.assimilate.employee.AddressdetailsEntity;
import com.assimilate.exception.RecordDoesNotCreatedException;
import com.assimilate.exception.RecordDoesNotExistException;
import com.assimilate.service.AddressdetailsService;

@RestController
@RequestMapping(API)
public class AddressdetailsRestController {
	
	@Autowired
	AddressdetailsService addressdetailsService;
	
	Logger logger = LoggerFactory.getLogger(AddressdetailsRestController.class);

	@PostMapping(EmployeeConstants.POST_USER) 
	public AddressdetailsEntity postUser(@RequestBody AddressdetailsEntity addressdetailsEntity) throws RecordDoesNotCreatedException
	{
		AddressdetailsEntity addressdetails=addressdetailsService.postUser(addressdetailsEntity);
		if(addressdetails==null)
		{
			throw new RecordDoesNotCreatedException("Please Enter User Details");
		}
		else
		{
			logger.info("Record created successfully");
			return addressdetails;
			}
		}
	
@GetMapping(EmployeeConstants.GET_ALL)
public List<AddressdetailsEntity> getAllUser() throws RecordDoesNotExistException
{
	List<AddressdetailsEntity> addressdetailsEntity=addressdetailsService.getAllUser();
	if(addressdetailsEntity==null)
	{
	
		throw new RecordDoesNotExistException("Records Does Not Exist");
	}
	else
	{
		logger.info("Records displayed Successfully");
		return addressdetailsEntity;
	}
}

	
	
}
