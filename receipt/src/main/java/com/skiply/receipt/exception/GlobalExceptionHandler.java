package com.skiply.receipt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ReceiptNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handleBadRequestException(ReceiptNotFoundException ex) {
		
		return new ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage());
	}
	
//	@ExceptionHandler(StudentNotFoundException.class)
//	@ResponseStatus(HttpStatus.NOT_FOUND)
//	public ErrorResponse handleNotFoundException(StudentNotFoundException ex) {
//		
//		return new ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage());
//	}
	

}
