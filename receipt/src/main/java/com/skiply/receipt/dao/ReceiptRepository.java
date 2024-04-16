package com.skiply.receipt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skiply.receipt.entity.Receipt;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
	
	Receipt findByStudentId(Long studentId);

}
