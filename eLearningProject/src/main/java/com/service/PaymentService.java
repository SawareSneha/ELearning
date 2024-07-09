package com.service;

import java.util.List;
import java.util.Map;

import com.model.Payment;

public interface PaymentService {

	public Payment save(Payment payment);
	
	public Payment getOne(long id);
	
	public List<Payment> getAllPayment();
	
	public Map<String,Object> deletePayment(long id) throws ClassNotFoundException,Exception;
	
	public Payment updatePayment(Payment payment);

	
}
