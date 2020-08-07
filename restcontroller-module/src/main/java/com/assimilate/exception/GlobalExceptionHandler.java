package com.assimilate.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	// Handle Specific exceptions
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<?> handlerResourceNotFoundException(RecordNotFoundException ex, WebRequest request)
	{
		ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidUserIdPasswordException.class)
	public ResponseEntity<?> handlerResourceNotFoundException(InvalidUserIdPasswordException ex, WebRequest request)
	{
		ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AlreadyRegistered.class)
	public ResponseEntity<?> handlerResourceNotFoundException(AlreadyRegistered ex, WebRequest request)
	{
		ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidLinkException.class)
	public ResponseEntity<?> handlerResourceNotFoundException(InvalidLinkException ex, WebRequest request)
	{
		ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	
	
	// Handle Global Exception
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handlerGlobalException(Exception ex, WebRequest request)
	{
		ErrorDetails errorDetails = new ErrorDetails(ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
