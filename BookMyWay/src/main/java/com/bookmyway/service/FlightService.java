package com.bookmyway.service;

import java.util.List;

import com.bookmyway.exception.FlightException;
import com.bookmyway.model.Flight;

public interface FlightService {
	Flight addFlight(Flight flight) throws FlightException;

	List<Flight> getAllFlights() throws FlightException;

	Flight getFlightByName(String flightName) throws FlightException;

	Flight getFlightById(Integer flightId) throws FlightException;

	Flight updateFlight(Integer flightId, Flight flight) throws FlightException;

	Flight deleteFlightById(Integer flightId) throws FlightException;

	List<Flight> searchFlightsByRoute(String departureAirport, String destinationAirport) throws FlightException;

	List<Flight> searchFlightsByAirline(String airlineName) throws FlightException;

	List<Flight> searchFlightsByPriceRange(Double minPrice, Double maxPrice) throws FlightException;

	boolean checkFlightAvailability(Integer flightId, Integer requiredSeats) throws FlightException;

}

