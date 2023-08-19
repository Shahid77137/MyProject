package com.masai.otms.service;

import java.util.List;

import com.masai.otms.exceptions.BookingException;
import com.masai.otms.models.Booking;

public interface BookingService {
		public Booking makeBooking(Booking bookings);
		public Booking cancelBooking(Integer bookingId);
		public Booking viewBookings(Integer bookingId);
		public List<Booking> viewAllBookings();
	}
	
	
	

