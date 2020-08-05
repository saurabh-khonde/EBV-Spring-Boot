package com.assimilate.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.assimilate.service.EmailSenderService;

@Service
public class EmailSenderServiceImp implements EmailSenderService{
	
	    private JavaMailSender javaMailSender;

	    @Autowired
	    public EmailSenderServiceImp(JavaMailSender javaMailSender) {
	        this.javaMailSender = javaMailSender;
	    } 

	    @Async
	    public void sendEmail(SimpleMailMessage email) {
	        javaMailSender.send(email);
	    }
}