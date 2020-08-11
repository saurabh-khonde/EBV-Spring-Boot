package com.assimilate.exception;

public class RecordDoesNotExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RecordDoesNotExistException() {
	
	}

	public RecordDoesNotExistException(String str) {
		super(str);
		
	}
	
	

}
