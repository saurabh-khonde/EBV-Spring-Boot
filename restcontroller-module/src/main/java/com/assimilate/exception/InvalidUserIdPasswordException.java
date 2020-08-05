package com.assimilate.exception;

public class InvalidUserIdPasswordException extends Exception{
	
	public InvalidUserIdPasswordException() {
		super();
	}
	
	public InvalidUserIdPasswordException(String str)
	{
		super(str);
	}

}
