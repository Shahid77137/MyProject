package com.bookmyway.service;

import java.util.List;


import com.bookmyway.exception.BusException;
import com.bookmyway.model.Bus;

public interface BusService {
	Bus addBus(Bus bus) throws BusException;

	List<Bus> getAllBuses() throws BusException;

	Bus getBusById(Integer busId) throws BusException;

	Bus updateBus(Integer busId, Bus bus) throws BusException;

	Bus deleteBus(Integer busId) throws BusException;

	List<Bus> searchBusesByRoute(String departureCity, String destinationCity) throws BusException;

	List<Bus> searchBusesByPriceRange(Double minPrice, Double maxPrice) throws BusException;

	boolean checkBusAvailability(Integer busId, Integer requiredSeats) throws BusException;



}
