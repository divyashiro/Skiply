package com.skiply.receipt.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.skiply.receipt.model.Student;

@FeignClient(name = "STUDENT-SERVICE")
public interface IStudentClient {
	
	@GetMapping("/student/{studentId}")
	ResponseEntity<Student> getStudentById(@PathVariable Long studentId);

}
