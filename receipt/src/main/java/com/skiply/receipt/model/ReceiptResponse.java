package com.skiply.receipt.model;

import com.skiply.receipt.entity.Receipt;

public class ReceiptResponse {
	
	Receipt receipt;
	Student student;
	public Receipt getReceipt() {
		return receipt;
	}
	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

}
