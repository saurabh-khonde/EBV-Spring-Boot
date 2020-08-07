package com.assimilate.service;

import java.util.List;

import com.assimilate.employee.AddressdetailsEntity;

public interface AddressdetailsService {

	void postUser(AddressdetailsEntity addressdetailsEntity);

	List<AddressdetailsEntity> getAllUser();

	
}
