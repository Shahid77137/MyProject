package com.masai.otms.service.Implementations;


import java.util.ArrayList;  
import java.util.List; 

import java.util.ArrayList; 
import java.util.List; 

import java.util.ArrayList;
import java.util.List;


import java.util.Optional;

import com.masai.otms.service.BookingService;

//import io.jsonwebtoken.lang.Collections;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.otms.exceptions.BookingException;
import com.masai.otms.exceptions.CustomerException;
import com.masai.otms.models.Booking;
import com.masai.otms.repository.BookingRepo;
import com.masai.otms.repository.PackageRepo;
import com.masai.otms.repository.UserRepo;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
	PackageRepo pkgRepo;
	
	@Autowired
	BookingRepo bookRepo;
	
	@Autowired
	UserRepo userRepo;

	
	
	
    @Override
    public Booking makeBooking(Booking booking){
    	
    	booking.setBookingId(booking.getBookingId());
    	try {
    		 bookRepo.save(booking);
    	}catch(Exception e) {
    		throw new BookingException("Error making booking "+e.getMessage());
    	}
    	
		return booking;
		
	
		
		
//	    Package pkg;
//        Optional<Package> optionalPackage = pkgRepo.findById(pkg.getp);
//        Optional<User> optionalUser = userRepo.findById(booking.getUser().getId());
//        if (optionalPackage.isPresent() && optionalUser.isPresent()) {
//            Package aPackage = optionalPackage.get();
//            User user = optionalUser.get();
//            if (aPackage.getAvailableSlots() >= booking.getNumberOfPeople()) {
//                aPackage.setAvailableSlots(aPackage.getAvailableSlots() - booking.getNumberOfPeople());
//                packageRepo.save(aPackage);
//                booking.setaPackage(aPackage);
//                booking.setUser(user);
//                return bookRepo.save(booking);
//            } else {
//                throw new BookingException("Not enough available slots for this package");
//            }
//        } else {
//            throw new BookingException("Package or user not found");
//        }
    }

    @Override
    public Booking cancelBooking(Integer bookingId){
        Optional<Booking> optionalBooking = bookRepo.findById(bookingId);
        if (optionalBooking.isPresent()) {
            Booking booking = optionalBooking.get();
            bookRepo.delete(booking);
            return booking;
        } else {
            throw new BookingException("Booking not found");
        }
    }


    
    
    @Override
    public Booking viewBookings(Integer bookingId){
    	Optional<Booking> bookinglist = bookRepo.findById(bookingId);

		return bookinglist.orElseThrow(()-> new BookingException("invalid Booking id "+ bookingId));
    }
    
    

    @Override
    public List<Booking> viewAllBookings(){
	
	List<Booking> bookings = bookRepo.findAll();
	
	if(bookings.isEmpty()){
	    throw new CustomerException("No Bookings found");
	}
        return bookings;
    }
}





