package com.skiply.receipt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.skiply.receipt.entity.Receipt;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
	
	//@Query("select r from Receipt r where r.studentId = ?1 desc limit 1")
	Receipt findFirstByStudentId(Long studentId);

}
