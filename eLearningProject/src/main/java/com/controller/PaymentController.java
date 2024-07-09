package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Payment;
import com.service.PaymentService;

@RestController
public class PaymentController {

	@Autowired
	PaymentService paymentservice;
	
	@PostMapping("/savePayment")
	public Payment save(@RequestBody Payment payment) {
		
		return paymentservice.save(payment);
	}
	@GetMapping("/getallPayment")
	public List<Payment> getAll() {
	
		return paymentservice.getAllPayment();
	}
	
	@GetMapping("/getOnePayment/{id}")
	public Payment getOne(@PathVariable("id")long id)
	{
		return paymentservice.getOne(id);
	}

	@DeleteMapping("/deletePayment/{id}")
	public ResponseEntity<Map<String,Object>> deletePayment(@PathVariable("id")long id) throws Exception
	{
		Map<String,Object> response =paymentservice.deletePayment(id);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/updatePayment")
	public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment)
	{
		Payment p=paymentservice.updatePayment(payment);
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("update", "Payment updated").body(p);
	}
}
