package com.skiply.receipt.service;

import com.skiply.receipt.entity.Receipt;

public interface ReceiptService {
	
	Receipt saveReceipt(Receipt receipt);
	
	Receipt viewReceiptByStudentId(Long StudentId);
	
	

}
