package com.skiply.receipt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ReceiptApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReceiptApplication.class, args);
	}

}
