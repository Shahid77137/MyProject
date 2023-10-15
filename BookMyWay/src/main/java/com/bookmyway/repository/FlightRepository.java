package com.bookmyway.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookmyway.model.Bus;

import com.bookmyway.model.Flight;


/**
 * Repository interface for managing Flight entities.
 * This repository extends JpaRepository which provides CRUD operations for the Flight entity.
 * 
 * @Author HoshiyarJyani
 */
@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    /**
     * Retrieves a Flight entity by its airline name.
     *
     * @param airlineName The airline name to search for.
     * @return The Flight entity with the specified airline name, or null if not found.
     */
  
    List<Flight> findByAirlineName(String airlineName);

    Flight findByName(String flightName);
    
//    Flight findByAirlineName(String airlineName);

    /**
     * Retrieves a list of Flight entities based on the departure airport and destination airport.
     *
     * @param departureAirport   The departure airport to search for.
     * @param destinationAirport The destination airport to search for.
     * @return A list of Flight entities that match the specified departure and destination airports.
     */
    List<Flight> findByDepartureAirportAndDestinationAirport(String departureAirport, String destinationAirport);

    /**
     * Retrieves a list of Flight entities based on the ticket price range.
     *
     * @param minPrice The minimum ticket price to search for.
     * @param maxPrice The maximum ticket price to search for.
     * @return A list of Flight entities that fall within the specified ticket price range.
     */
    List<Flight> findByTicketPriceBetween(Double minPrice, Double maxPrice);

    /**
     * Checks if a specific flight has available seats for a given number of required seats.
     *
     * @param flightId       The ID of the flight to check for availability.
     * @param requiredSeats  The number of seats required to be available.
     * @return true if the flight has the required number of available seats, false otherwise.
     */
    @Query("SELECT f FROM Flight f WHERE f.flightId = :flightId AND f.availableSeats >= :requiredSeats")
    boolean checkFlightAvailability(@Param("flightId") Integer flightId, @Param("requiredSeats") Integer requiredSeats);

    
    @Query("SELECT f FROM Flight f WHERE f.departureAirport = :departureAirport AND f.destinationAirport = :destinationAirport")
    List<Flight> findFlightByRoute(@Param("departureAirport") String departureAirport,@Param("destinationAirport") String destinationAirport);
    

}
