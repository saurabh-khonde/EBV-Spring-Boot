package com.assimilate.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assimilate.employee.AddressdetailsEntity;
import com.assimilate.employee.AddressdetailsRepository;
import com.assimilate.service.AddressdetailsService;


@Service
public class AddressdetailsServiceImpl implements AddressdetailsService {
	
	@Autowired
	AddressdetailsRepository addressdetailsRepository;

	@Override
	public AddressdetailsEntity postUser(AddressdetailsEntity addressdetailsEntity) 
	{
		return addressdetailsRepository.save(addressdetailsEntity);
		
		}

	@Override
	public List<AddressdetailsEntity> getAllUser() {
		
		return addressdetailsRepository.findAll();
	
	}
	}


