package com.skiply.receipt.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Receipt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long referenceNumber;
	
	private Long studentId;
	private LocalDateTime dateTime;
	private String cardNumber;
	private String cardType;
	private Long fee;
	public Long getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(Long referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public Long getFee() {
		return fee;
	}
	public void setFee(Long fee) {
		this.fee = fee;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	@Override
	public String toString() {
		return "Receipt [referenceNumber=" + referenceNumber + ", studentId=" + studentId + ", dateTime=" + dateTime
				+ ", cardNumber=" + cardNumber + ", cardType=" + cardType + ", fee=" + fee + "]";
	}
	
	
	

}
