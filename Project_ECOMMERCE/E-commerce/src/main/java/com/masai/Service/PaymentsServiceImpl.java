package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.CustomersException;
import com.masai.Exception.PaymentsException;
import com.masai.Model.Customers;
import com.masai.Model.Payments;
import com.masai.Repository.PaymentsRepository;

@Service
public class PaymentsServiceImpl implements PaymentsService{

	@Autowired
	private PaymentsRepository paymentRepository;
	
	@Override
	public Payments createPayements(Payments payments) throws PaymentsException {
		
		if(paymentRepository.existsById(payments.getPaymentId())) {
			throw new PaymentsException("Customer already exists with id "+payments.getPaymentId());
		}
		
		return paymentRepository.save(payments);
		
	}

	@Override
	public Payments getPaymentsById(int payid) throws PaymentsException {
Optional<Payments> payments = paymentRepository.findById(payid);
		
		if(payments.isEmpty()) {
			throw new PaymentsException("Customer doesn't exists with id "+payid);
		}
		
		return payments.get();
	}

	@Override
	public List<Payments> getAllPayments() throws PaymentsException {
List<Payments> list = paymentRepository.findAll();
		
		if(list.isEmpty()) {
			throw new PaymentsException("No payments found");
		}
		
		return list;
	}

	@Override
	public Payments updatePayments(int payid,Payments payments) throws PaymentsException {
Optional<Payments> payment = paymentRepository.findById(payid);
		
		if(payment.isEmpty()) {
			throw new PaymentsException("Payments doesn't exists with id "+payid);
		}
		
		Payments custo = payment.get();
		
		custo.setPaymentType(payments.getPaymentType());
		custo.setPaymentCreatedDate(payments.getPaymentCreatedDate());
		custo.setPaymentUpdatedDate(payments.getPaymentUpdatedDate());
		custo.setAllowed(payments.isAllowed());
		
		return paymentRepository.save(custo);
	}

	@Override
	public Payments deletePayments(int payid) throws PaymentsException {
Optional<Payments> payments = paymentRepository.findById(payid);
		
		if(payments.isEmpty()) {
			throw new PaymentsException("No payments exists with id "+payid); 
		}
		
		paymentRepository.delete(payments.get());
		
		return payments.get();
	}

}
