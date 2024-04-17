package com.skiply.student.exception;

public class CircuitBreakerException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public CircuitBreakerException(String message) {
		super();
		this.message = message;
		
	}
	
	public CircuitBreakerException() {}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	} 
	
	

}
