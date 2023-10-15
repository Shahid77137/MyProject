package com.bookmyway.service;

import java.util.List;

import com.bookmyway.exception.HotelException;
import com.bookmyway.model.Hotel;

public interface HotelService {
	
	Hotel addHotel(Hotel hotel) throws HotelException;

	List<Hotel> getAllHotels() throws HotelException;

	Hotel getHotelByName(String hotelName) throws HotelException;

	Hotel updateHotel(Integer hotelId, Hotel hotel) throws HotelException;

	Hotel deleteHotelById(Integer hotelId) throws HotelException;

	List<Hotel> searchHotelsByLocation(String location) throws HotelException;

	List<Hotel> searchHotelsByPriceRange(Double minPrice, Double maxPrice) throws HotelException;

	boolean checkHotelAvailability(Integer hotelId, Integer requiredRooms) throws HotelException;
	
}


