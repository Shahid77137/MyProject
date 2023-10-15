package com.bookmyway.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookmyway.exception.BusException;
import com.bookmyway.model.Bus;
import com.bookmyway.repository.BusRepository;

@Service
public class BusServiceImpl implements BusService {

	@Autowired
	private BusRepository busRepository;

	@Override
	public Bus addBus(Bus bus) throws BusException {

		Optional<Bus> b = busRepository.findById(bus.getBusId());

		if (b.isPresent()) {
			throw new BusException("bus with id " + bus.getBusId() + " already exists");
		}

		return busRepository.save(bus);
	}

	@Override
	public List<Bus> getAllBuses() throws BusException {

		List<Bus> buslist = busRepository.findAll();
		
		if(buslist.isEmpty()) {
			throw new BusException("No bus found");
		}

		return buslist;
	}

	@Override
	public Bus getBusById(Integer busId) throws BusException {

		Optional<Bus> b = busRepository.findById(busId);

		if (b.isPresent()) {
			throw new BusException("bus with id " + busId + " already exists");
		}

		return b.get();

	}

	@Override
	public Bus updateBus(Integer busId, Bus bus) throws BusException {

		Optional<Bus> b = busRepository.findById(busId);

		if (b.isEmpty()) {
			throw new BusException("bus with id " + busId + " doesn't exists");
		}

		Bus bs = b.get();
		bs.setBusCompany(bus.getBusCompany());
		bs.setBusNumber(bus.getBusNumber());
		bs.setDepartureCity(bus.getDepartureCity());
		bs.setDestinationCity(bus.getDestinationCity());
		bs.setDepartureDateTime(bus.getDepartureDateTime());
		bs.setArrivalDateTime(bus.getArrivalDateTime());
		bs.setTicketPrice(bus.getTicketPrice());
		bs.setAvailableSeats(bus.getAvailableSeats());
		bs.setBusCapacity(bus.getBusCapacity());
		bs.setImage(bus.getImage());

		return busRepository.save(bs);
	}

	@Override
	public Bus deleteBus(Integer busId) throws BusException {

		Optional<Bus> b = busRepository.findById(busId);

		if (b.isEmpty()) {
			throw new BusException("bus with id " + busId + " doesn't exists");
		}

		busRepository.delete(b.get());

		return b.get();
	}

	@Override
	public List<Bus> searchBusesByRoute(String departureCity, String destinationCity) throws BusException {

		List<Bus> buslist = busRepository.findBusByRoute(departureCity, destinationCity);

		if (buslist.isEmpty()) {
			throw new BusException("No buses found for route " + departureCity + " to " + destinationCity);
		}

		return buslist;
	}

	@Override
	public List<Bus> searchBusesByPriceRange(Double minPrice, Double maxPrice) throws BusException {

		List<Bus> buslist = busRepository.findByTicketPriceBetween(minPrice, maxPrice);

		if (buslist.isEmpty()) {
			throw new BusException("No buses found with ticket prices between ₹" + minPrice + " - ₹" + maxPrice);
		}

		return buslist;
	}

	@Override
	public boolean checkBusAvailability(Integer busId, Integer requiredSeats) throws BusException {

		Optional<Bus> b = busRepository.findById(busId);

		if (b.isEmpty()) {
			throw new BusException("bus with id " + busId + " doesn't exists");
		}

		boolean availability = busRepository.checkBusSeatAvailability(busId, requiredSeats);

		return availability;
	}

}
