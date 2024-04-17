package com.skiply.student.feign;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.skiply.student.exception.CircuitBreakerException;
import com.skiply.student.model.Receipt;

@Component
public class HystrixClientFallback implements IReceiptClient {

	@Override
	public Receipt saveReceipt(Receipt receipt) {
		throw new CircuitBreakerException("Reciept-service is unavailable");
	}

	@Override
	public ResponseEntity<?> viewReceipt(Long studentId) {
		throw new CircuitBreakerException("Reciept-service is unavailable");
	}
  
}
