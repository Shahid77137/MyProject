package com.masai.otms.service;

import java.util.List; 

import com.masai.otms.exceptions.TravelException;
import com.masai.otms.models.Travels;

public interface TravelsService {
	
   public Travels addTravels(Travels travel) throws TravelException;
	
	public Travels updateTravels(Travels travel,Integer travelId) throws TravelException;

	public Travels removeTravels(Integer travelId) throws TravelException;
	
	public Travels serchTravels(Integer travelId) throws TravelException;
	
	public List<Travels> viewTravels() throws TravelException;
	
	
	//extra
//	public Travels getTravelsById(Integer travelId) throws TravelException;
}
