package com.assimilate.service;

import org.springframework.stereotype.Repository;

import com.assimilate.employee.UserEntity;



@Repository
public interface UserService {

	public UserEntity findByEmailIdIgnoreCase(String str);
	
	public void saveUser(UserEntity ue);
}
