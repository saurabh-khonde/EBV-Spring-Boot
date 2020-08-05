package com.assimilate.exception;

public class ErrorDetails {
	
	private String message;
	private String details;
	
	public ErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorDetails(String message, String details) {
		super();
		this.message = message;
		this.details = details;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getdetails() {
		return details;
	}
	public void setdetails(String details) {
		this.details = details;
	}
	@Override
	public String toString() {
		return "ErrorDetails [message=" + message + ", details=" + details + "]";
	}
	
}
