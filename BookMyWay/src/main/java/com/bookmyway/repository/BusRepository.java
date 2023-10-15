package com.bookmyway.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookmyway.model.Bus;

/**
 * Repository interface for managing Bus entities.
 * This repository extends JpaRepository which provides CRUD operations for the Bus entity.
 * @Author HoshiyarJyani
 */
@Repository
public interface BusRepository extends JpaRepository<Bus, Integer> {

    /**
     * Retrieves a Bus entity by its bus company name.
     *
     * @param busCompany The bus company name to search for.
     * @return The Bus entity with the specified company name, or null if not found.
     */
    Bus findByBusCompany(String busCompany);

    /**
     * Retrieves a list of Bus entities based on the departure city and destination city.
     *
     * @param departureCity   The departure city to search for.
     * @param destinationCity The destination city to search for.
     * @return A list of Bus entities that match the specified departure and destination cities.
     */
    List<Bus> findByDepartureCityAndDestinationCity(String departureCity, String destinationCity);

    /**
     * Retrieves a list of Bus entities based on the ticket price range.
     *
     * @param minPrice The minimum ticket price to search for.
     * @param maxPrice The maximum ticket price to search for.
     * @return A list of Bus entities that fall within the specified ticket price range.
     */
    List<Bus> findByTicketPriceBetween(Double minPrice, Double maxPrice);

    /**
     * Checks if a specific bus has available seats for a given number of required seats.
     *
     * @param busId          The ID of the bus to check for availability.
     * @param requiredSeats  The number of seats required to be available.
     * @return true if the bus has the required number of available seats, false otherwise.
     */
    @Query("SELECT b FROM Bus b WHERE b.busId = :busId AND b.availableSeats >= :requiredSeats")
    boolean checkBusSeatAvailability(@Param("busId") Integer busId, @Param("requiredSeats") Integer requiredSeats);

    @Query("SELECT b FROM Bus b WHERE b.departureCity = :departureCity AND b.destinationCity = :destinationCity")
    List<Bus> findBusByRoute(@Param("departureCity") String departureCity,@Param("destinationCity") String destinationCity);
    

}
