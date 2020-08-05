package com.assimilate.restcontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.assimilate.serviceimpl.EmployeeServiceImpl;


@Configuration
@SpringBootApplication(scanBasePackages = "com.assimilate") 
@EntityScan(basePackages = {"com.assimilate.employee"})
@ComponentScan({"com.assimilate.service"})
@EnableJpaRepositories("com.assimilate.employee")
@EnableJpaAuditing
@EnableWebMvc
@ComponentScan(basePackageClasses = EmployeeServiceImpl.class)
//@ComponentScan(basePackageClasses = RegisterServiceImpl.class)
public class EmployeeVerificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeVerificationApplication.class, args);
	}

}
