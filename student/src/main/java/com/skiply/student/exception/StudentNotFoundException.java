package com.skiply.student.exception;

public class StudentNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public StudentNotFoundException(String message) {
		super();
		this.message = message;
		
	}
	
	public StudentNotFoundException() {}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	} 
	
	


}
