package com.bookmyway.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookmyway.model.Flight;

import com.bookmyway.model.Train;

/**
 * Repository interface for managing Train entities.
 * This repository extends JpaRepository which provides CRUD operations for the Train entity.
 * 
 * @Author HoshiyarJyani
 */
@Repository
public interface TrainRepository extends JpaRepository<Train, Integer> {

    /**
     * Retrieves a Train entity by its train name.
     *
     * @param trainName The train name to search for.
     * @return The Train entity with the specified train name, or null if not found.
     */
    Train findByTrainName(String trainName);

    /**
     * Retrieves a list of Train entities based on the departure station and destination station.
     *
     * @param departureStation The departure station to search for trains.
     * @param destinationStation The destination station to search for trains.
     * @return A list of Train entities that match the specified departure and destination stations.
     */
    List<Train> findByDepartureStationAndDestinationStation(String departureStation, String destinationStation);

    /**
     * Retrieves a list of Train entities based on the ticket price range.
     *
     * @param minPrice The minimum ticket price to search for.
     * @param maxPrice The maximum ticket price to search for.
     * @return A list of Train entities that have ticket prices within the specified range.
     */
    List<Train> findByTicketPriceBetween(Double minPrice, Double maxPrice);

    /**
     * Checks if a specific train has available seats for a given number of required seats.
     *
     * @param trainId The ID of the train to check for seat availability.
     * @param requiredSeats The number of seats required to be available.
     * @return true if the train has the required number of available seats, false otherwise.
     */
    @Query("SELECT t FROM Train t WHERE t.trainId = :trainId AND t.availableSeats >= :requiredSeats")
    boolean checkTrainSeatAvailability(@Param("trainId") Integer trainId, @Param("requiredSeats") Integer requiredSeats);
    
    @Query("SELECT t FROM Train t WHERE t.departureStation = :departureStation AND f.destinationStation = :destinationStation")
    List<Train> findTrainByRoute(@Param("departureStation") String departureStation,@Param("destinationStation") String destinationStation);
    
}
