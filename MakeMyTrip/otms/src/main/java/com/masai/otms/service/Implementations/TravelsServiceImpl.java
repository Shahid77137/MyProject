package com.masai.otms.service.Implementations;

import java.util.ArrayList; 
import java.util.List;
import java.util.Optional;

import com.masai.otms.service.TravelsService;
import org.springframework.beans.factory.annotation.Autowired;

import com.masai.otms.exceptions.TravelException;
import com.masai.otms.models.Package;
import com.masai.otms.models.Travels;
import com.masai.otms.repository.BookingRepo;
import com.masai.otms.repository.PackageRepo;
import com.masai.otms.repository.TravelsRepo;
import com.masai.otms.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class TravelsServiceImpl implements TravelsService {

	@Autowired
	PackageRepo pkgRepo;
	
	@Autowired
	BookingRepo bookRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	TravelsRepo travRepo;
	
	
	
	
	
	
	@Override
	public Travels addTravels(Travels travel) throws TravelException {
		// TODO Auto-generated method stub
		Travels trav= travRepo.save(travel);
		
		return trav;
	}

	
	
	
	
	
	
	@Override
	public Travels updateTravels(Travels travel, Integer travelId) throws TravelException {
		// TODO Auto-generated method stub
		
		Optional<Travels> travelupdate = travRepo.findById(travelId);
		
		if(travelupdate.isPresent()) {
			Travels existingtravel = travelupdate.get();
			existingtravel.setTravelsName(travel.getTravelsName());
			existingtravel.setAddress(travel.getAddress());
			existingtravel.setAgentName(travel.getAgentName());
			existingtravel.setPhoneNumber(travel.getPhoneNumber());
			
			travRepo.save(existingtravel);
			
		return 	travel;
			
		}else {
			throw new TravelException("Invalid Travel Supplied...");
		}
		
	}

	@Override
	public Travels removeTravels(Integer travelId) throws TravelException {
		// TODO Auto-generated method stub
		
		Optional<Travels> travelremove = travRepo.findById(travelId);
        if(travelremove.isPresent()) {
        	Travels existingTravels = travelremove.get();
        	travRepo.delete(existingTravels);
        	return existingTravels;
        }else {
			throw new TravelException("Travel doesn't exist by this ..."+travelId);

        }
		
		
	}

	
	
	
	
	
	
	
	
	@Override
	public Travels serchTravels(Integer travelId) {
		// TODO Auto-generated method stub
		Optional<Travels> serchTravels = travRepo.findById(travelId);
		 if(serchTravels.isPresent()) {
	        	Travels existingTravels = serchTravels.get();
	        	
	        	return existingTravels;
	        }else {
				throw new TravelException("Travel doesn't exist by this ..."+travelId);

	        }   
		
		
	}

	
	
	
	//EXTRA METHOD 
	
//	@Override
//	public Travels getTravelsById(Integer travelId) {
//		Optional<Travels> getTravelsById = travRepo.findById(travelId);
//		 if(getTravelsById.isPresent()) {
//	        	Travels existingTravels = getTravelsById.get();
	        	
//	        	return existingTravels;
//	        }else {
//				throw new TravelException("Travel doesn't exist by this ..."+travelId);

//	        }   
//	}
	
	
	
	
	@Override
	public List<Travels> viewTravels() throws TravelException {
		// TODO Auto-generated method stub
		
		List<Travels> viewTravel = travRepo.viewTravels();
		
		if(viewTravel.isEmpty()) {
        	
			throw new TravelException("Travel doesn't exist");
        	
        }else {

        	return viewTravel;
        }   
		
	
	}

}






