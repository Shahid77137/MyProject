package com.bookmyway.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookmyway.exception.FlightException;
import com.bookmyway.model.Flight;
import com.bookmyway.service.FlightService;


/**
 * FlightController handles HTTP requests related to Flight entities. It
 * provides CRUD operations for flights and additional methods for searching and
 * checking availability.
 *
 * @Author HoshiyarJyani
 */

@RestController
@RequestMapping("/flights")
public class FlightController {

	@Autowired
	private FlightService flightService;

	/**
	 * Adds a new flight to the database.
	 *
	 * @param flight The flight object to be added.
	 * @return The added flight with HttpStatus.CREATED status if successful.
	 * @throws FlightException 
	 */
	@PostMapping
	public ResponseEntity<Flight> addFlightHandler(@RequestBody Flight flight) throws FlightException {
		Flight addedFlight = flightService.addFlight(flight);
		return new ResponseEntity<>(addedFlight, HttpStatus.CREATED);
	}

	/**
	 * Retrieves a list of all flights from the database.
	 *
	 * @return A list of all flights with HttpStatus.OK status if successful.
	 * @throws FlightException 
	 */
	@GetMapping
	public ResponseEntity<List<Flight>> getAllFlightsHandler() throws FlightException {
		List<Flight> flights = flightService.getAllFlights();
		return new ResponseEntity<>(flights, HttpStatus.OK);
	}

	/**
	 * Retrieves a flight by its name from the database.
	 *
	 * @param flightName The name of the flight to be retrieved.
	 * @return The flight with HttpStatus.OK status if found, or
	 *         HttpStatus.NOT_FOUND if not found.
	 * @throws FlightException 
	 */
	@GetMapping("/{flightName}")
	public ResponseEntity<Flight> getFlightByNameHandler(@PathVariable String flightName) throws FlightException {
		Flight flight = flightService.getFlightByName(flightName);
		if (flight != null) {
			return new ResponseEntity<>(flight, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Retrieves a flight by its ID from the database.
	 *
	 * @param flightId The ID of the flight to be retrieved.
	 * @return The flight with HttpStatus.OK status if found, or
	 *         HttpStatus.NOT_FOUND if not found.
	 * @throws FlightException 
	 */
	@GetMapping("/{flightId}")
	public ResponseEntity<Flight> getFlightByIdHandler(@PathVariable Integer flightId) throws FlightException {
		Flight flight = flightService.getFlightById(flightId);
		if (flight != null) {
			return new ResponseEntity<>(flight, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Updates information of a flight in the database.
	 *
	 * @param flightId The ID of the flight to be updated.
	 * @param flight   The updated flight object.
	 * @return The updated flight with HttpStatus.OK status if successful, or
	 *         HttpStatus.NOT_FOUND if the flight does not exist.
	 * @throws FlightException 
	 */
	@PutMapping("/{flightId}")
	public ResponseEntity<Flight> updateFlightHandler(@PathVariable Integer flightId, @RequestBody Flight flight) throws FlightException {
		Flight updatedFlight = flightService.updateFlight(flightId, flight);
		if (updatedFlight != null) {
			return new ResponseEntity<>(updatedFlight, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Deletes a flight from the database by its ID.
	 *
	 * @param flightId The ID of the flight to be deleted.
	 * @return The deleted flight with HttpStatus.OK status if successful, or
	 *         HttpStatus.NOT_FOUND if the flight does not exist.
	 * @throws FlightException 
	 */
	@DeleteMapping("/{flightId}")
	public ResponseEntity<Flight> deleteFlightHandler(@PathVariable Integer flightId) throws FlightException {
		Flight deletedFlight = flightService.deleteFlightById(flightId);
		if (deletedFlight != null) {
			return new ResponseEntity<>(deletedFlight, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Searches for flights by departure and destination airports.
	 *
	 * @param departureAirport   The departure airport.
	 * @param destinationAirport The destination airport.
	 * @return A list of flights with HttpStatus.OK status if found, or
	 *         HttpStatus.NOT_FOUND if no matching flights are found.
	 * @throws FlightException 
	 */
	@GetMapping("/search/route")
	public ResponseEntity<List<Flight>> searchFlightsByRouteHandler(@RequestParam String departureAirport,
			@RequestParam String destinationAirport) throws FlightException {
		List<Flight> flights = flightService.searchFlightsByRoute(departureAirport, destinationAirport);
		return new ResponseEntity<>(flights, HttpStatus.OK);
	}

	/**
	 * Searches for flights by airline name.
	 *
	 * @param airlineName The name of the airline.
	 * @return A list of flights with HttpStatus.OK status if found, or
	 *         HttpStatus.NOT_FOUND if no matching flights are found.
	 * @throws FlightException 
	 */
	@GetMapping("/search/airline")
	public ResponseEntity<List<Flight>> searchFlightsByAirlineHandler(@RequestParam String airlineName) throws FlightException {
		List<Flight> flights = flightService.searchFlightsByAirline(airlineName);
		return new ResponseEntity<>(flights, HttpStatus.OK);
	}

	/**
	 * Searches for flights by ticket price range.
	 *
	 * @param minPrice The minimum ticket price.
	 * @param maxPrice The maximum ticket price.
	 * @return A list of flights with HttpStatus.OK status if found, or
	 *         HttpStatus.NOT_FOUND if no matching flights are found.
	 * @throws FlightException 
	 */
	@GetMapping("/search/price")
	public ResponseEntity<List<Flight>> searchFlightsByPriceRangeHandler(@RequestParam Double minPrice,
			@RequestParam Double maxPrice) throws FlightException {
		List<Flight> flights = flightService.searchFlightsByPriceRange(minPrice, maxPrice);
		return new ResponseEntity<>(flights, HttpStatus.OK);
	}

	/**
	 * Checks if a specific flight has available seats for a given number of
	 * required seats.
	 *
	 * @param flightId      The ID of the flight to check.
	 * @param requiredSeats The number of seats required.
	 * @return true with HttpStatus.OK status if seats are available, false with
	 *         HttpStatus.OK status if seats are not available, or
	 *         HttpStatus.NOT_FOUND if the flight does not exist.
	 * @throws FlightException 
	 */
	@GetMapping("/check-availability/{flightId}")
	public ResponseEntity<Boolean> checkFlightAvailabilityHandler(@PathVariable Integer flightId,
			@RequestParam Integer requiredSeats) throws FlightException {
		boolean isAvailable = flightService.checkFlightAvailability(flightId, requiredSeats);
		return new ResponseEntity<>(isAvailable, HttpStatus.OK);
	}
}
