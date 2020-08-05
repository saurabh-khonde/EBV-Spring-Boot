package com.assimilate.exception;

public class AlreadyRegistered extends RuntimeException{

	public AlreadyRegistered()
	{
		
	}
	
	public AlreadyRegistered(String str)
	{
		super(str);
	}
	
}
