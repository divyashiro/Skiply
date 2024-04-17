package com.skiply.student.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.skiply.student.dao.StudentReceiptMappingRepository;
import com.skiply.student.dao.StudentRepository;
import com.skiply.student.entity.Student;
import com.skiply.student.exception.FeeAlreadyPaidException;
import com.skiply.student.exception.StudentNotFoundException;
import com.skiply.student.feign.IReceiptClient;
import com.skiply.student.model.Fee;
import com.skiply.student.model.Receipt;
import com.skiply.student.service.FeeService;

@Service
public class FeeServiceImpl implements FeeService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	StudentReceiptMappingRepository studentReceiptMappingRepository;
	
	@Autowired
	IReceiptClient receiptClient;


	@Override
	public Receipt collectFee(Long studentId, Fee fee) {
		Optional<Student> studentData = studentRepository.findById(studentId); 
		
		if(! studentData.isPresent()) {
			throw new StudentNotFoundException("Invalid Student Id");
		}
		if (studentData.get().getIsFeePaid().booleanValue()) {
			throw new FeeAlreadyPaidException("Fee already paid for student id : " + studentId);
		}
		else {
			Receipt receipt = new Receipt();
			receipt.setCardNumber(fee.getCardNumber());
			receipt.setCardType(fee.getCardType());
			receipt.setDateTime(LocalDateTime.now());
			receipt.setFee(fee.getFee());
			receipt.setStudentId(studentId);
			Receipt savedReceipt = receiptClient.saveReceipt(receipt);
			if(savedReceipt != null) {
				studentRepository.updateFeePaid(studentId, true);
			}
			return savedReceipt;

		} 
		
	}

}
