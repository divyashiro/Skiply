package com.skiply.student.exception;

public class StudentAlreadyExistsExeption extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public StudentAlreadyExistsExeption(String message) {
		super();
		this.message = message;
		
	}
	
	public StudentAlreadyExistsExeption() {}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	} 
	
	

}
