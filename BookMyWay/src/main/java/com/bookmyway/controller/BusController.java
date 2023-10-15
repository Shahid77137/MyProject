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

import com.bookmyway.exception.BusException;
import com.bookmyway.model.Bus;

import com.bookmyway.service.BusService;


/**
 * BusController handles HTTP requests related to Bus entities. It provides CRUD
 * operations for buses and additional methods for searching and checking
 * availability.
 *
 * @Author HoshiyarJyani
 */

@RestController
@RequestMapping("/buses")
public class BusController {

	@Autowired

	private BusService busService;

//	private final BusService busService;


	/**
	 * Adds a new bus to the database.
	 *
	 * @param bus The bus object to be added.
	 * @return The added bus with HttpStatus.CREATED status if successful.
	 * @throws BusException 
	 */
	@PostMapping
	public ResponseEntity<Bus> addBusHandler(@RequestBody Bus bus) throws BusException {
		Bus addedBus = busService.addBus(bus);
		return new ResponseEntity<>(addedBus, HttpStatus.CREATED);
	}

	/**
	 * Retrieves a list of all buses from the database.
	 *
	 * @return A list of all buses with HttpStatus.OK status if successful.
	 * @throws BusException 
	 */
	@GetMapping
	public ResponseEntity<List<Bus>> getAllBusesHandler() throws BusException {
		List<Bus> buses = busService.getAllBuses();
		return new ResponseEntity<>(buses, HttpStatus.OK);
	}

	/**
	 * Retrieves a bus by its ID from the database.
	 *
	 * @param busId The ID of the bus to be retrieved.
	 * @return The bus with HttpStatus.OK status if found, or HttpStatus.NOT_FOUND
	 *         if not found.
	 * @throws BusException 
	 */
	@GetMapping("/{busId}")
	public ResponseEntity<Bus> getBusByIdHandler(@PathVariable Integer busId) throws BusException {
		Bus bus = busService.getBusById(busId);
		if (bus != null) {
			return new ResponseEntity<>(bus, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Updates information of a bus in the database.
	 *
	 * @param busId The ID of the bus to be updated.
	 * @param bus   The updated bus object.
	 * @return The updated bus with HttpStatus.OK status if successful, or
	 *         HttpStatus.NOT_FOUND if the bus does not exist.
	 * @throws BusException 
	 */
	@PutMapping("/{busId}")
	public ResponseEntity<Bus> updateBusHandler(@PathVariable Integer busId, @RequestBody Bus bus) throws BusException {
		Bus updatedBus = busService.updateBus(busId, bus);
		if (updatedBus != null) {
			return new ResponseEntity<>(updatedBus, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Deletes a bus from the database by its ID.
	 *
	 * @param busId The ID of the bus to be deleted.
	 * @return The deleted bus with HttpStatus.OK status if successful, or
	 *         HttpStatus.NOT_FOUND if the bus does not exist.
	 * @throws BusException 
	 */
	@DeleteMapping("/{busId}")
	public ResponseEntity<Bus> deleteBusHandler(@PathVariable Integer busId) throws BusException {
		Bus deletedBus = busService.deleteBus(busId);
		if (deletedBus != null) {
			return new ResponseEntity<>(deletedBus, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Searches for buses by departure and destination cities.
	 *
	 * @param departureCity   The departure city.
	 * @param destinationCity The destination city.
	 * @return A list of buses with HttpStatus.OK status if found, or
	 *         HttpStatus.NOT_FOUND if no matching buses are found.
	 * @throws BusException 
	 */
	@GetMapping("/search/route")
	public ResponseEntity<List<Bus>> searchBusesByRouteHandler(@RequestParam String departureCity,
			@RequestParam String destinationCity) throws BusException {
		List<Bus> buses = busService.searchBusesByRoute(departureCity, destinationCity);
		return new ResponseEntity<>(buses, HttpStatus.OK);
	}

	/**
	 * Searches for buses by ticket price range.
	 *
	 * @param minPrice The minimum ticket price.
	 * @param maxPrice The maximum ticket price.
	 * @return A list of buses with HttpStatus.OK status if found, or
	 *         HttpStatus.NOT_FOUND if no matching buses are found.
	 * @throws BusException 
	 */
	@GetMapping("/search/price")
	public ResponseEntity<List<Bus>> searchBusesByPriceRangeHandler(@RequestParam Double minPrice,
			@RequestParam Double maxPrice) throws BusException {
		List<Bus> buses = busService.searchBusesByPriceRange(minPrice, maxPrice);
		return new ResponseEntity<>(buses, HttpStatus.OK);
	}

	/**
	 * Checks if a specific bus has available seats for a given number of required
	 * seats.
	 *
	 * @param busId         The ID of the bus to check.
	 * @param requiredSeats The number of seats required.
	 * @return true with HttpStatus.OK status if seats are available, false with
	 *         HttpStatus.OK status if seats are not available, or
	 *         HttpStatus.NOT_FOUND if the bus does not exist.
	 * @throws BusException 
	 */
	@GetMapping("/check-availability/{busId}")
	public ResponseEntity<Boolean> checkBusAvailabilityHandler(@PathVariable Integer busId,
			@RequestParam Integer requiredSeats) throws BusException {
		boolean isAvailable = busService.checkBusAvailability(busId, requiredSeats);
		return new ResponseEntity<>(isAvailable, HttpStatus.OK);
	}
}
