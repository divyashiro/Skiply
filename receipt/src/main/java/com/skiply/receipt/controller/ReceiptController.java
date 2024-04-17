package com.skiply.receipt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skiply.receipt.entity.Receipt;
import com.skiply.receipt.service.ReceiptService;

@RestController
@RequestMapping("/receipt")
public class ReceiptController {
	
	@Autowired
	ReceiptService receiptService;

	@PostMapping
	public Receipt saveReceipt(@RequestBody Receipt receipt) {
		return receiptService.saveReceipt(receipt);
	}
	
	@GetMapping("/{studentId}")
	public ResponseEntity<?> viewReceipt(@PathVariable Long studentId) {
		return new ResponseEntity<>(receiptService.viewReceiptByStudentId(studentId),HttpStatus.OK);
	}
}
