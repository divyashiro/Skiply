package com.skiply.receipt.exception;

public class ReceiptNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public ReceiptNotFoundException(String message) {
		super();
		this.message = message;
		
	}
	
	public ReceiptNotFoundException() {}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	} 

}
