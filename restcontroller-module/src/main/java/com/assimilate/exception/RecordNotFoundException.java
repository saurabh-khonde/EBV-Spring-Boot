package com.assimilate.exception;

public class RecordNotFoundException extends RuntimeException{

	public RecordNotFoundException()
	{
		
	}
	public RecordNotFoundException(String str)
	{
		super(str);
	}
}
