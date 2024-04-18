package com.skiply.receipt.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skiply.receipt.dao.ReceiptRepository;
import com.skiply.receipt.entity.Receipt;
import com.skiply.receipt.exception.ReceiptNotFoundException;
import com.skiply.receipt.feign.IStudentClient;
import com.skiply.receipt.model.ReceiptResponse;
import com.skiply.receipt.model.Student;
import com.skiply.receipt.service.ReceiptService;

@Service
public class ReceiptServiceImpl implements ReceiptService {
	
	@Autowired
	ReceiptRepository receiptRepository;
	
	@Autowired
	IStudentClient studentClient;
	

	@Override
	public Receipt saveReceipt(Receipt receipt) {
		return receiptRepository.save(receipt);
	}


	@Override
	public ReceiptResponse viewReceiptByStudentId(Long studentId) {
		Receipt receipt = receiptRepository.findFirstByStudentId(studentId);
		if(receipt != null) {
			ReceiptResponse receiptResponse = new ReceiptResponse();
			Student student = new Student();
			ResponseEntity<Student> studentById = studentClient.getStudentById(studentId);
			ModelMapper modelmapper = new ModelMapper();
			modelmapper.map(studentById.getBody(),student);
			receiptResponse.setCardNumber(receipt.getCardNumber());
			receiptResponse.setReferenceNumber(receipt.getReferenceNumber());
			receiptResponse.setCardType(receipt.getCardType());
			receiptResponse.setDateTime(receipt.getDateTime());
			receiptResponse.setFee(receipt.getFee());
			receiptResponse.setStudent(student);
			return receiptResponse;
		}
				
		else
				throw new ReceiptNotFoundException("No receipt found for student ID: " + studentId );
		
	}

}
