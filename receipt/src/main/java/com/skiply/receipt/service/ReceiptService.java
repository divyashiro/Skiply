package com.skiply.receipt.service;

import com.skiply.receipt.entity.Receipt;
import com.skiply.receipt.model.ReceiptResponse;

public interface ReceiptService {
	
	Receipt saveReceipt(Receipt receipt);
	
	ReceiptResponse viewReceiptByStudentId(Long StudentId);
	
	

}
