package com.bookmyway.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmyway.exception.FlightException;
import com.bookmyway.model.Flight;
import com.bookmyway.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepository flightRepository;

	@Override
	public Flight addFlight(Flight flight) throws FlightException {

		Optional<Flight> f = flightRepository.findById(flight.getFlightId());

		if (f.isPresent()) {
			throw new FlightException("flight with id " + flight.getFlightId() + " already exists");
		}

		return flightRepository.save(flight);

	}

	@Override
	public List<Flight> getAllFlights() throws FlightException {

		List<Flight> flightlist = flightRepository.findAll();

		if (flightlist.isEmpty()) {
			throw new FlightException("No flight found");
		}

		return flightlist;
	}

	@Override
	public Flight getFlightByName(String flightName) throws FlightException {

		Flight flight = flightRepository.findByName(flightName);

		if (flight == null) {
			throw new FlightException("Flight with name " + flightName + " doesn't exists");
		}

		return flight;
	}

	@Override
	public Flight getFlightById(Integer flightId) throws FlightException {
		
		Optional<Flight> flight = flightRepository.findById(flightId);

		if (flight.isEmpty()) {
			throw new FlightException("flight with id " + flightId + " doesn't exists");
		}

		return flight.get();
	}

	@Override
	public Flight updateFlight(Integer flightId, Flight flight) throws FlightException {

		Optional<Flight> f = flightRepository.findById(flightId);

		if (f.isEmpty()) {
			throw new FlightException("Flight not found with id " + flightId);
		}

		Flight fly = f.get();

		fly.setAirlineName(flight.getAirlineName());
		fly.setFlightNumber(flight.getFlightNumber());
		fly.setDepartureAirport(flight.getDepartureAirport());
		fly.setDestinationAirport(flight.getDestinationAirport());
		fly.setDepartureDateTime(flight.getDepartureDateTime());
		fly.setArrivalDateTime(flight.getArrivalDateTime());
		fly.setTicketPrice(flight.getTicketPrice());
		fly.setAvailableSeats(flight.getAvailableSeats());
		fly.setFlightCapacity(flight.getFlightCapacity());
		fly.setImage(flight.getImage());

		return flightRepository.save(fly);
	}

	@Override
	public Flight deleteFlightById(Integer flightId) throws FlightException {

		Optional<Flight> flight = flightRepository.findById(flightId);

		if (flight.isEmpty()) {
			throw new FlightException("Flight with id " + flightId + " doesn't exists");
		}

		flightRepository.delete(flight.get());

		return flight.get();

	}

	@Override
	public List<Flight> searchFlightsByRoute(String departureAirport, String destinationAirport)
			throws FlightException {

		List<Flight> flightlist = flightRepository.findFlightByRoute(departureAirport, destinationAirport);

		if (flightlist.isEmpty()) {
			throw new FlightException("No flights found for route " + departureAirport + " to " + destinationAirport);
		}

		return flightlist;

	}

	@Override
	public List<Flight> searchFlightsByAirline(String airlineName) throws FlightException {

		List<Flight> flightlist = flightRepository.findByAirlineName(airlineName);

		if (flightlist.isEmpty()) {
			throw new FlightException("No flights found from " + airlineName);
		}

		return flightlist;
	}

	@Override
	public List<Flight> searchFlightsByPriceRange(Double minPrice, Double maxPrice) throws FlightException {

		List<Flight> flightlist = flightRepository.findByTicketPriceBetween(minPrice, maxPrice);
		
		if (flightlist.isEmpty()) {
			throw new FlightException("No flights found with ticket prices between ₹" + minPrice + " - ₹" + maxPrice);
		}

		return flightlist;
	}

	@Override
	public boolean checkFlightAvailability(Integer flightId, Integer requiredSeats) throws FlightException {
		
		Optional<Flight> flight = flightRepository.findById(flightId);

		if (flight.isEmpty()) {
			throw new FlightException("flight with id " + flightId + " doesn't exists");
		}

		boolean availability = flightRepository.checkFlightAvailability(flightId, requiredSeats);

		return availability;
	}

}
