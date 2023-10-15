package com.bookmyway.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmyway.exception.HotelException;
import com.bookmyway.model.Hotel;
import com.bookmyway.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel addHotel(Hotel hotel) throws HotelException {

		Optional<Hotel> h = hotelRepository.findById(hotel.getHotelId());

		if (h.isPresent()) {
			throw new HotelException("hotel with id " + hotel.getHotelId() + " already exists");
		}

		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotels() throws HotelException {
		List<Hotel> hotellist = hotelRepository.findAll();

		if (hotellist.isEmpty()) {
			throw new HotelException("No hotel found");
		}

		return hotellist;
	}

	@Override
	public Hotel getHotelByName(String hotelName) throws HotelException {

		Hotel hotel = hotelRepository.findByHotelName(hotelName);

		if (hotel == null) {
			throw new HotelException("Hotel with name " + hotelName + " doesn't exists");
		}

		return hotel;
	}

	@Override
	public Hotel updateHotel(Integer hotelId, Hotel hotel) throws HotelException {

		Optional<Hotel> h = hotelRepository.findById(hotelId);

		if (h.isEmpty()) {
			throw new HotelException("Hotel not found with id " + hotelId);
		}

		Hotel htl = h.get();

		htl.setHotelName(hotel.getHotelName());
		htl.setImage(hotel.getImage());
		htl.setLocation(hotel.getLocation());
		htl.setCategory(hotel.getCategory());
		htl.setDescription(hotel.getDescription());
		htl.setPrice(hotel.getPrice());
		htl.setAvailableRooms(hotel.getAvailableRooms());
		htl.setTotalRooms(hotel.getTotalRooms());
		htl.setRating(hotel.getRating());
		htl.setImage(hotel.getImage());

		return hotelRepository.save(htl);
	}

	@Override
	public Hotel deleteHotelById(Integer hotelId) throws HotelException {

		Optional<Hotel> hotel = hotelRepository.findById(hotelId);

		if (hotel.isEmpty()) {
			throw new HotelException("Hotel with id " + hotelId + " doesn't exists");
		}

		hotelRepository.delete(hotel.get());

		return hotel.get();
	}

	@Override
	public List<Hotel> searchHotelsByLocation(String location) throws HotelException {

		List<Hotel> hotellist = hotelRepository.findHotelByLocation(location);

		if (hotellist.isEmpty()) {
			throw new HotelException("No Hotel found for location " + location);
		}

		return hotellist;
	}

	@Override
	public List<Hotel> searchHotelsByPriceRange(Double minPrice, Double maxPrice) throws HotelException {

		List<Hotel> hotellist = hotelRepository.findByPriceBetween(minPrice, maxPrice);

		if (hotellist.isEmpty()) {
			throw new HotelException("No hotels found with ticket prices between ₹" + minPrice + " - ₹" + maxPrice);
		}

		return hotellist;
	}

	@Override
	public boolean checkHotelAvailability(Integer hotelId, Integer requiredRooms) throws HotelException {
		
		Optional<Hotel> hotel = hotelRepository.findById(hotelId);

		if (hotel.isEmpty()) {
			throw new HotelException("hotel with id " + hotelId + " doesn't exists");
		}

		boolean availability = hotelRepository.checkHotelAvailability(hotelId, requiredRooms);

		return availability;
	}

}
