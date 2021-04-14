package com.assimilate.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assimilate.employee.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	
	UserEntity findByEmailIdIgnoreCase(String str);


// git test for new beranch pooja_solpure
}
