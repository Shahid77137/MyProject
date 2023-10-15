package com.bookmyway.service;

import java.util.List;

import com.bookmyway.exception.TrainException;
import com.bookmyway.model.Train;

public interface TrainService {
	
	Train addTrain(Train train) throws TrainException;

	List<Train> getAllTrains() throws TrainException;

	Train getTrainByName(String trainName) throws TrainException;

	Train getTrainById(Integer trainId) throws TrainException;

	Train updateTrain(Integer trainId, Train train) throws TrainException;

	Train deleteTrainById(Integer trainId) throws TrainException;

	List<Train> searchTrainsByRoute(String departureStation, String destinationStation) throws TrainException;

	List<Train> searchTrainsByPriceRange(Double minPrice, Double maxPrice) throws TrainException;

	boolean checkTrainAvailability(Integer trainId, Integer requiredSeats) throws TrainException;
	

}


