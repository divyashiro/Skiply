package com.skiply.student.exception;

public class FeeAlreadyPaidException extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public FeeAlreadyPaidException(String message) {
		super();
		this.message = message;
		
	}
	
	public FeeAlreadyPaidException() {}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	} 
}
