package com.masai.otms.exceptions;

import org.springframework.http.HttpStatus;  
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> methodArgumentNotValidException(MethodArgumentNotValidException me, WebRequest req){
        ErrorDetails ed = new ErrorDetails();
        ed.setMessage(me.getBindingResult().getFieldError().getDefaultMessage());
        ed.setTimeStamp(LocalDateTime.now());
        ed.setUri(req.toString());

        return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
    }

    
    
    
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorDetails> noHandlerFoundException(NoHandlerFoundException ne, WebRequest req) {
        ErrorDetails ed = new ErrorDetails();
        ed.setMessage(ne.getMessage());
        ed.setTimeStamp(LocalDateTime.now());
        ed.setUri(req.toString());

        return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AdminException.class)
    public ResponseEntity<ErrorDetails> adminException(AdminException ae, WebRequest req) {
        ErrorDetails ed = new ErrorDetails();
        ed.setMessage(ae.getMessage());
        ed.setTimeStamp(LocalDateTime.now());
        ed.setUri(req.toString());

        return new ResponseEntity<>(ed, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookingException.class)
    public ResponseEntity<ErrorDetails> bookingException(BookingException ae, WebRequest req) {
        ErrorDetails ed = new ErrorDetails();
        ed.setMessage(ae.getMessage());
        ed.setTimeStamp(LocalDateTime.now());
        ed.setUri(req.toString());

        return new ResponseEntity<>(ed, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BusException.class)
    public ResponseEntity<ErrorDetails> busException(BusException ae, WebRequest req) {
        ErrorDetails ed = new ErrorDetails();
        ed.setMessage(ae.getMessage());
        ed.setTimeStamp(LocalDateTime.now());
        ed.setUri(req.toString());

        return new ResponseEntity<>(ed, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomerException.class)
    public ResponseEntity<ErrorDetails> customerException(CustomerException ae, WebRequest req) {
        ErrorDetails ed = new ErrorDetails();
        ed.setMessage(ae.getMessage());
        ed.setTimeStamp(LocalDateTime.now());
        ed.setUri(req.toString());

        return new ResponseEntity<>(ed, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FeedbackException.class)
    public ResponseEntity<ErrorDetails> feedbackException(FeedbackException ae, WebRequest req) {
        ErrorDetails ed = new ErrorDetails();
        ed.setMessage(ae.getMessage());
        ed.setTimeStamp(LocalDateTime.now());
        ed.setUri(req.toString());

        return new ResponseEntity<>(ed, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HotelException.class)
    public ResponseEntity<ErrorDetails> hotelException(HotelException ae, WebRequest req) {
        ErrorDetails ed = new ErrorDetails();
        ed.setMessage(ae.getMessage());
        ed.setTimeStamp(LocalDateTime.now());
        ed.setUri(req.toString());

        return new ResponseEntity<>(ed, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PackageException.class)
    public ResponseEntity<ErrorDetails> packageException(PackageException ae, WebRequest req) {
        ErrorDetails ed = new ErrorDetails();
        ed.setMessage(ae.getMessage());
        ed.setTimeStamp(LocalDateTime.now());
        ed.setUri(req.toString());

        return new ResponseEntity<>(ed, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ReportException.class)
    public ResponseEntity<ErrorDetails> reportException(ReportException ae, WebRequest req) {
        ErrorDetails ed = new ErrorDetails();
        ed.setMessage(ae.getMessage());
        ed.setTimeStamp(LocalDateTime.now());
        ed.setUri(req.toString());

        return new ResponseEntity<>(ed, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RouteException.class)
    public ResponseEntity<ErrorDetails> routeException(RouteException ae, WebRequest req) {
        ErrorDetails ed = new ErrorDetails();
        ed.setMessage(ae.getMessage());
        ed.setTimeStamp(LocalDateTime.now());
        ed.setUri(req.toString());

        return new ResponseEntity<>(ed, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TicketDetailsException.class)
    public ResponseEntity<ErrorDetails> ticketDetailsException(TicketDetailsException ae, WebRequest req) {
        ErrorDetails ed = new ErrorDetails();
        ed.setMessage(ae.getMessage());
        ed.setTimeStamp(LocalDateTime.now());
        ed.setUri(req.toString());

        return new ResponseEntity<>(ed, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TravelException.class)
    public ResponseEntity<ErrorDetails> travelException(TravelException ae, WebRequest req) {
        ErrorDetails ed = new ErrorDetails();
        ed.setMessage(ae.getMessage());
        ed.setTimeStamp(LocalDateTime.now());
        ed.setUri(req.toString());

        return new ResponseEntity<>(ed, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorDetails> userException(UserException ae, WebRequest req) {
        ErrorDetails ed = new ErrorDetails();
        ed.setMessage(ae.getMessage());
        ed.setTimeStamp(LocalDateTime.now());
        ed.setUri(req.toString());

        return new ResponseEntity<>(ed, HttpStatus.NOT_FOUND);
    }
}










