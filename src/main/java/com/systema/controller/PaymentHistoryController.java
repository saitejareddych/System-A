package com.systema.controller;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.systema.model.PaymentHistory;
import com.systema.service.PaymentHistoryService;



@RestController
@RequestMapping("/systema")
public class PaymentHistoryController {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(PaymentHistoryController.class);

	@Autowired
	private PaymentHistoryService paymentHistoryService;

	@GetMapping("/getpaymenthistory/{id}/{date}")
	public ResponseEntity<List<PaymentHistory>> getPaymentHistory(@PathVariable("id") int customerId, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate date) {
		
		List<PaymentHistory> result= paymentHistoryService.getPaymentHistoryById(customerId, date);
		
		return ResponseEntity.ok().body(result);
	}

}
