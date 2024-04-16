package com.skiply.student.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.skiply.student.config.FeignConfig;
import com.skiply.student.model.Receipt;


@FeignClient(name = "RECEIPT-SERVICE", configuration=FeignConfig.class)
public interface IReceiptClient {
	
	@PostMapping(value = "/receipt")
	public Receipt saveReceipt(Receipt receipt);

}
