package com.skiply.receipt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skiply.receipt.dao.ReceiptRepository;
import com.skiply.receipt.entity.Receipt;
import com.skiply.receipt.service.ReceiptService;

@Service
public class ReceiptServiceImpl implements ReceiptService {
	
	@Autowired
	ReceiptRepository receiptRepository;
	

	@Override
	public Receipt saveReceipt(Receipt receipt) {
		return receiptRepository.save(receipt);
	}


	@Override
	public Receipt viewReceiptByStudentId(Long studentId) {
		return receiptRepository.findByStudentId(studentId);
		
	}

}
