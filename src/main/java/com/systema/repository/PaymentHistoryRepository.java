package com.systema.repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.systema.model.PaymentHistory;

@Repository
public interface PaymentHistoryRepository extends JpaRepository<PaymentHistory, Integer> {

	@Query("select paymentHistory from PaymentHistory paymentHistory where paymentHistory.customerId = :customerId and paymentHistory.paymentDate > :paymentDate")
	   List<PaymentHistory> findByPaymentHistoryByDate(@Param("customerId") int  customerId, @Param("paymentDate") LocalDate  paymentDate);
}
