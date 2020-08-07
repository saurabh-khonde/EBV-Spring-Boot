package com.assimilate.exception;

public class EmailVerificationException extends RuntimeException{

	public EmailVerificationException()
	{
		
	}
	
	public EmailVerificationException(String str)
	{
		super(str);
	}
}
