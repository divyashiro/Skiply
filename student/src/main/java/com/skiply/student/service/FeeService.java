package com.skiply.student.service;

import com.skiply.student.model.Fee;
import com.skiply.student.model.Receipt;

public interface FeeService {
	
	Receipt collectFee(Long studentId, Fee fee);

}
