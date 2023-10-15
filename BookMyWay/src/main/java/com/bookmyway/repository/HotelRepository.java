package com.bookmyway.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookmyway.model.Flight;

import com.bookmyway.model.Hotel;

/**
 * Repository interface for managing Hotel entities.
 * This repository extends JpaRepository which provides CRUD operations for the Hotel entity.
 * 
 * @Author HoshiyarJyani
 */
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    /**
     * Retrieves a Hotel entity by its hotel name.
     *
     * @param hotelName The hotel name to search for.
     * @return The Hotel entity with the specified hotel name, or null if not found.
     */
    Hotel findByHotelName(String hotelName);

    /**
     * Retrieves a list of Hotel entities based on the location.
     *
     * @param location The location to search for hotels.
     * @return A list of Hotel entities that match the specified location.
     */
    List<Hotel> findByLocation(String location);

    /**
     * Retrieves a list of Hotel entities based on the price range.
     *
     * @param minPrice The minimum price to search for.
     * @param maxPrice The maximum price to search for.
     * @return A list of Hotel entities that fall within the specified price range.
     */
    List<Hotel> findByPriceBetween(Double minPrice, Double maxPrice);

    /**
     * Checks if a specific hotel has available rooms for a given number of required rooms.
     *
     * @param hotelId       The ID of the hotel to check for availability.
     * @param requiredRooms The number of rooms required to be available.
     * @return true if the hotel has the required number of available rooms, false otherwise.
     */
    @Query("SELECT h FROM Hotel h WHERE h.hotelId = :hotelId AND h.availableRooms >= :requiredRooms")
    boolean checkHotelAvailability(@Param("hotelId") Integer hotelId, @Param("requiredRooms") Integer requiredRooms);

    
    @Query("SELECT h FROM Hotel h WHERE h.location = :location")
    List<Hotel> findHotelByLocation(@Param("location") String location);
    
    

}
