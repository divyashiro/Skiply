package com.skiply.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skiply.student.model.Fee;
import com.skiply.student.service.FeeService;

@RestController
@RequestMapping("/collect-fee")
public class FeeController {
	
	@Autowired
	FeeService feeService;
	
	@PostMapping("/{studentId}")
	public ResponseEntity<?> collectFee(@PathVariable Long studentId, @RequestBody Fee fee) {
		return new ResponseEntity<>(feeService.collectFee(studentId, fee),HttpStatus.OK);
	}
	

}
