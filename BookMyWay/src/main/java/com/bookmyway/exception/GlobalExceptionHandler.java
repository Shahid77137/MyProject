package com.bookmyway.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler(NoHandlerFoundException ce, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTimpstamp(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler1(Exception ce, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTimpstamp(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
 
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler2(NotFoundException ce, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTimpstamp(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(BusException.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler2(BusException ce, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTimpstamp(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(TrainException.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler2(TrainException ce, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTimpstamp(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(HotelException.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler2(HotelException ce, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTimpstamp(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(FlightException.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler2(FlightException ce, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTimpstamp(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(req.getDescription(false));
		
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	 

}