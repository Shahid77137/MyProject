package com.masai.otms.repository;

import com.masai.otms.exceptions.TravelException;
import com.masai.otms.models.Admin;
import com.masai.otms.models.Travels;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface TravelsRepo extends JpaRepository<Travels, Integer> {
	@Query("select t from Travels t where t.travelId =?1")
	
	public Travels serchTravels(Integer travelId);
	
	
	
	@Query("select t from Travels t ")
	public List<Travels> viewTravels();

	
	
	
}
