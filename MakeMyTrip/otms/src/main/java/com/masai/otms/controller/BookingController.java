package com.masai.otms.controller;

import java.util.List;

import com.masai.otms.models.TicketDetails;
import com.masai.otms.repository.TicketDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.otms.exceptions.BookingException;
import com.masai.otms.models.Booking;
import com.masai.otms.service.BookingService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;

	@Autowired
	private TicketDetailsRepo tRepo;
	 	 
	@PostMapping("/bookings")
	public ResponseEntity<Booking> makeBookingHandler(@Valid @RequestBody Booking booking){
	   
		Booking addbooking = bookingService.makeBooking(booking);
		TicketDetails td = new TicketDetails();
		td.setStatus("Pending");
		TicketDetails td2 = tRepo.save(td);
			
			return new ResponseEntity<>(addbooking,HttpStatus.CREATED);
	}

	@DeleteMapping("/cancelbooking/{bookingId}")
	public ResponseEntity<Booking> cancelBookingHandler(@Valid @PathVariable Integer bookingId){

	      Booking cancelbooking = bookingService.cancelBooking(bookingId);

		  return new ResponseEntity<>(cancelbooking,HttpStatus.OK); 
	}
	
	
	

	
//
//	public ResponseEntity <Booking>viewBookingsHandler(@Valid @PathVariable Integer bookingId) throws BookingException {
//
//	public ResponseEntity<Booking> viewBookingsHandler(@Valid @PathVariable Integer bookingId) throws BookingException {
//
//
	@GetMapping("/getbookings/{bookingId}")
	public ResponseEntity<Booking> viewBookingsHandler(@Valid @PathVariable Integer bookingId){



	       Booking viewbookings = bookingService.viewBookings(bookingId);
		   
		   return new ResponseEntity<>(viewbookings,HttpStatus.OK);
	}

	


	
	@GetMapping("/getbookingdetails")
	public ResponseEntity<List<Booking>> viewAllBookingsHandler() {
		
		List<Booking> viewALLbookings = bookingService.viewAllBookings();
		
		return new ResponseEntity<>(viewALLbookings,HttpStatus.OK); 
	}
	
	
	
	
	
}
