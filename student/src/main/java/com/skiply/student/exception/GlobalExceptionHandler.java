package com.skiply.student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(StudentAlreadyExistsExeption.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ErrorResponse handleBadRequestException(StudentAlreadyExistsExeption ex) {
		
		return new ErrorResponse(HttpStatus.CONFLICT.value(),ex.getMessage());
	}
	

}
