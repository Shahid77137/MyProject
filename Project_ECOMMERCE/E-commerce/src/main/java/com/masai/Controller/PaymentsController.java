package com.masai.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.CategoryException;
import com.masai.Exception.PaymentsException;
import com.masai.Model.Category;
import com.masai.Model.Payments;
import com.masai.Service.CategoryService;
import com.masai.Service.PaymentsService;

@RestController
@RequestMapping("/Payments")
@CrossOrigin("*")
public class PaymentsController {

	@Autowired
	public PaymentsService paymentsService;
	
	
	@PostMapping("/createPayements")
	public ResponseEntity<Payments> createPayements(@RequestBody Payments payments)throws PaymentsException{
		Payments cat = paymentsService.createPayements(payments);
		return new ResponseEntity<>(cat,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/getPaymentsById/{payid}")
	public ResponseEntity<Payments> getPaymentsById(@PathVariable int payid)throws PaymentsException{
		
		Payments cat = paymentsService.getPaymentsById(payid);
		return new ResponseEntity<>(cat,HttpStatus.OK);
	}
	
	
	
	@PutMapping("/updatePayments/{payid}")
	public ResponseEntity<Payments> updatePayments(@PathVariable int payid,@RequestBody Payments payments)throws PaymentsException{
		Payments cat = paymentsService.updatePayments(payid, payments);
		return new ResponseEntity<>(cat,HttpStatus.OK);
	}
	
	

	@DeleteMapping("/deletePayments/{payid}")
	public ResponseEntity<Payments> deletePayments(@PathVariable int payid)throws PaymentsException{
		Payments cat = paymentsService.deletePayments(payid);
		return new ResponseEntity<>(cat,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/getAllPayments")
	public ResponseEntity<List<Payments>> getAllPayments()throws PaymentsException{
		List<Payments> list = paymentsService.getAllPayments();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
}
