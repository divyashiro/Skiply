package com.skiply.student.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skiply.student.dao.StudentReceiptMappingRepository;
import com.skiply.student.dao.StudentRepository;
import com.skiply.student.entity.Student;
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
		if(studentData.isPresent()) {
			Receipt receipt = new Receipt();
			receipt.setCardNumber(fee.getCardNumber());
			receipt.setCardType(fee.getCardType());
			receipt.setDateTime(LocalDateTime.now());
			receipt.setFee(fee.getFee());
			receipt.setStudentId(studentId);
			Receipt savedReceipt = receiptClient.saveReceipt(receipt);
			return savedReceipt;
//			StudentReceiptMapping s = new StudentReceiptMapping();
//			s.setReceiptNumber(savedReceipt.getReferenceNumber());
//			s.setStudentId(studentId);
//			return studentReceiptMappingRepository.save(s);
		} else {
			throw new StudentNotFoundException("Invalid Student Id");
		}
		
	}

}
