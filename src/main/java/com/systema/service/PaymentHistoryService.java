package com.systema.service;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.systema.model.PaymentHistory;
import com.systema.repository.PaymentHistoryRepository;


@Service
public class PaymentHistoryService {
	
	private PaymentHistoryRepository paymentHistoryRepository = null;

	@Autowired
	public PaymentHistoryService(PaymentHistoryRepository paymentHistoryRepository) {
		this.paymentHistoryRepository = paymentHistoryRepository;
	}
	
	public List<PaymentHistory> getPaymentHistoryById(int customerId, LocalDate date) {
		
		return paymentHistoryRepository.findByPaymentHistoryByDate(customerId, date);
	}
}
