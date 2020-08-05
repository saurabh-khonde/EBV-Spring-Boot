package com.assimilate.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.assimilate.employee.UserEntity;
import com.assimilate.employee.UserRepository;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String str) throws UsernameNotFoundException {
    	
    	UserEntity userEntity = userRepository.findByEmailIdIgnoreCase(str);
    	
    	System.out.println("--****---"+userEntity);
    			
        return new User(userEntity.getEmailId(), userEntity.getPassword(), new ArrayList<>());
    }
}
