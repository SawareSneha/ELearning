package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.PaymentRepo;
import com.model.Payment;


@Service
public class PaymentServiceImp implements PaymentService{

	@Autowired
	PaymentRepo prepo;
	
	@Override
	public Payment save(Payment payment) {
		
		return prepo.save(payment);
	}

	@Override
	public Payment getOne(long id) {
		
		return prepo.findById((long) id).orElse(null);

	}

	@Override
	public List<Payment> getAllPayment() {
		
		return prepo.findAll();
	}

	@Override
	public Map<String, Object> deletePayment(long id) throws ClassNotFoundException, Exception {
		
		Map<String,Object>response=new HashMap<String,Object>();
		try {
			Payment p=prepo.findById(id).orElseThrow(()-> new ClassNotFoundException("Payment Not Exits"+id));
			prepo.delete(p);
			response.put("deleted", Boolean.TRUE);
		}
		catch(ClassNotFoundException p)
		{
			response.put("not deleted", p.getMessage());
		}
		
		return response;
	}

	@Override
	public Payment updatePayment(Payment payment) {
		
		System.out.println(payment.getId());
		Payment p=prepo.findById(payment.getId()).orElse(null);
		
		p.setAmount(p.getAmount());
		return prepo.save(p);
	}

}
