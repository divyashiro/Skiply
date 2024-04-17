package com.skiply.student.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.skiply.student.config.FeignConfig;
import com.skiply.student.model.Receipt;


@FeignClient(name = "RECEIPT-SERVICE", configuration=FeignConfig.class, fallback = HystrixClientFallback.class)
public interface IReceiptClient {
	
	@PostMapping(value = "/receipt")
	public Receipt saveReceipt(@RequestBody Receipt receipt);
	
	@GetMapping(value = "/receipt/{studentId}")
	public ResponseEntity<?> viewReceipt(@PathVariable Long studentId);

}
