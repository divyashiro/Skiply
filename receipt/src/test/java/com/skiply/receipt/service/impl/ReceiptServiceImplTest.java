package com.skiply.receipt.service.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.skiply.receipt.dao.ReceiptRepository;
import com.skiply.receipt.entity.Receipt;
import com.skiply.receipt.exception.ReceiptNotFoundException;
import com.skiply.receipt.feign.IStudentClient;
import com.skiply.receipt.model.ReceiptResponse;
import com.skiply.receipt.model.Student;

@SpringBootTest
public class ReceiptServiceImplTest {
	
	@InjectMocks
	ReceiptServiceImpl receiptServiceImpl;
	
	@Mock
	ReceiptRepository receiptRepository;
	
	@Mock
	IStudentClient studentClient;
	

	@Before
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test (expected = ReceiptNotFoundException.class)
	public void viewReceiptByStudentIdReceiptNotFound() {
		when(receiptRepository.findFirstByStudentId(anyLong())).thenReturn(null);
		receiptServiceImpl.viewReceiptByStudentId((long) 3);
	}
	
	@Test 
	public void viewReceiptByStudentId() {
		when(receiptRepository.findFirstByStudentId((long) 3)).thenReturn(getReceipt());
		
		when(studentClient.getStudentById(anyLong())).thenReturn(getStudent());
		ReceiptResponse receiptResponse = receiptServiceImpl.viewReceiptByStudentId((long) 3);
		
		Assert.assertTrue(receiptResponse != null);
	}

	private ResponseEntity<Student> getStudent() {
		Student student = new Student();
		student.setGrade("4");
		student.setMobileNumber((long) 887765);
		student.setName("Drake");
		student.setSchoolName("skiply");
		return new ResponseEntity<Student>(student,HttpStatus.OK);
	}

	private Receipt getReceipt() {
		Receipt receipt = new Receipt();
		receipt.setCardNumber("777-886-99");
		receipt.setCardType("visa");
		receipt.setFee((long) 4000);
		receipt.setDateTime(LocalDateTime.now());
		return receipt;
	}

}
