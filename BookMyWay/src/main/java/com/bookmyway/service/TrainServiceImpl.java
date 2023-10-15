package com.bookmyway.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmyway.exception.TrainException;
import com.bookmyway.model.Train;
import com.bookmyway.repository.TrainRepository;


@Service
public class TrainServiceImpl implements TrainService{

	@Autowired
	private TrainRepository trainRepository;
	
	@Override
	public Train addTrain(Train train) throws TrainException {
		
		Optional<Train> t = trainRepository.findById(train.getTrainId());

		if (t.isPresent()) {
			throw new TrainException("train with id " + train.getTrainId() + " already exists");
		}

		return trainRepository.save(train);
	}

	@Override
	public List<Train> getAllTrains() throws TrainException {
		
        List<Train> trainlist = trainRepository.findAll();
		
		if(trainlist.isEmpty()) {
			throw new TrainException("No train found");
		}

		return trainlist;
		
	}

	@Override
	public Train getTrainByName(String trainName) throws TrainException {
		
		
		Train train = trainRepository.findByTrainName(trainName);

		if (train == null) {
			throw new TrainException("Flight with name " + trainName + " doesn't exists");
		}

		return train;
		
	}

	@Override
	public Train getTrainById(Integer trainId) throws TrainException {
		
		Optional<Train> train = trainRepository.findById(trainId);

		if (train.isEmpty()) {
			throw new TrainException("Train with id " + trainId + " doesn't exists");
		}

		return train.get();
		
	}

	@Override
	public Train updateTrain(Integer trainId, Train train) throws TrainException {
		Optional<Train> t = trainRepository.findById(trainId);

		if (t.isEmpty()) {
			throw new TrainException("Flight not found with id " + trainId);
		}

		Train trains = t.get();

		trains.setTrainName(train.getTrainName());
		trains.setTrainNumber(train.getTrainNumber());
		trains.setDepartureStation(train.getDepartureStation());
		trains.setDestinationStation(train.getDestinationStation());
		trains.setDepartureDateTime(train.getDepartureDateTime());
		trains.setArrivalDateTime(train.getArrivalDateTime());
		trains.setTicketPrice(train.getTicketPrice());
		trains.setAvailableSeats(train.getAvailableSeats());
		trains.setTrainCapacity(train.getTrainCapacity());
		trains.setImage(train.getImage());

		return trainRepository.save(trains);
	}

	@Override
	public Train deleteTrainById(Integer trainId) throws TrainException {
		
		Optional<Train> train = trainRepository.findById(trainId);

		if (train.isEmpty()) {
			throw new TrainException("Train with id " + trainId + " doesn't exists");
		}

		trainRepository.delete(train.get());

		return train.get();
	}

	@Override
	public List<Train> searchTrainsByRoute(String departureStation, String destinationStation) throws TrainException {
		
		List<Train> trainlist = trainRepository.findTrainByRoute(departureStation, destinationStation);

		if (trainlist.isEmpty()) {
			throw new TrainException("No trains found for route " + departureStation + " to " + destinationStation);
		}

		return trainlist;
	}

	@Override
	public List<Train> searchTrainsByPriceRange(Double minPrice, Double maxPrice) throws TrainException {
        
		List<Train> trainlist = trainRepository.findByTicketPriceBetween(minPrice, maxPrice);
		
		if (trainlist.isEmpty()) {
			throw new TrainException("No trains found with ticket prices between ₹" + minPrice + " - ₹" + maxPrice);
		}

		return trainlist;
	}

	@Override
	public boolean checkTrainAvailability(Integer trainId, Integer requiredSeats) throws TrainException {
		
		Optional<Train> train = trainRepository.findById(trainId);

		if (train.isEmpty()) {
			throw new TrainException("train with id " + trainId + " doesn't exists");
		}

		boolean availability = trainRepository.checkTrainSeatAvailability(trainId, requiredSeats);

		return availability;
		
	}

}
