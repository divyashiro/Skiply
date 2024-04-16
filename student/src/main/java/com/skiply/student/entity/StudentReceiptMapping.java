package com.skiply.student.entity;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class StudentReceiptMapping {
	
	@Id
	private Long id;
	private Long StudentId;
	private Long receiptNumber;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getStudentId() {
		return StudentId;
	}
	public void setStudentId(Long studentId) {
		StudentId = studentId;
	}
	public Long getReceiptNumber() {
		return receiptNumber;
	}
	public void setReceiptNumber(Long receiptNumber) {
		this.receiptNumber = receiptNumber;
	}

}
