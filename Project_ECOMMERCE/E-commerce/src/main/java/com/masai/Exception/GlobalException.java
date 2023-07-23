package com.masai.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> myExpHandler2(Exception ie,WebRequest req){
		
		System.out.println("Inside myExceptionHandler2 method");
		
		MyErrorDetails err = new MyErrorDetails();
		err.setMessage(ie.getMessage());
		err.setTimestamp(LocalDateTime.now());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> myExpHandler3(NoHandlerFoundException ne,WebRequest req){
		
		System.out.println("Inside myExceptionHandler3 method");
		
		MyErrorDetails err = new MyErrorDetails();
		err.setMessage(ne.getMessage());
		err.setTimestamp(LocalDateTime.now());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> myExpHandler4(MethodArgumentNotValidException me){
		
		System.out.println("Inside myExceptionHandler3 method");
		
		MyErrorDetails err = new MyErrorDetails();
		err.setMessage("Invalid argument");
		err.setTimestamp(LocalDateTime.now());
		err.setDescription(me.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		
	}
	

	
	@ExceptionHandler(AddressException.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler5(AddressException ce, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDescription(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(CartException.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler5(CartException ce, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(CategoryException.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler5(CategoryException ce, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(CustomersException.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler5(CustomersException ce, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(FeedbackException.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler5(FeedbackException ce, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(OrdersException.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler5(OrdersException ce, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	@ExceptionHandler(PaymentsException.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler5(PaymentsException ce, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(ProductsException.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler5(ProductsException ce, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDescription(req.getDescription(false));
		
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	
	
	
}
