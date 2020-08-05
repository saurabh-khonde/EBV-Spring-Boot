package com.assimilate.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assimilate.employee.UserEntity;
import com.assimilate.employee.UserRepository;
import com.assimilate.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserEntity findByEmailIdIgnoreCase(String str) {
		UserEntity ue = userRepository.findByEmailIdIgnoreCase(str);
		return ue;
	}

	@Override
	public void saveUser(UserEntity ue) {
		userRepository.save(ue);
	}
}
