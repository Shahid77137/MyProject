package com.masai.otms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.otms.exceptions.TravelException;
import com.masai.otms.models.Travels;
import com.masai.otms.service.TravelsService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
public class TravelsController {
	
	@Autowired
	private TravelsService travelservice;

	@PostMapping("/addTravels")
	public ResponseEntity<Travels> Addtravelshandler(@Valid @RequestBody Travels travel){
	Travels addTravel = travelservice.addTravels(travel);
		
		return new ResponseEntity<>(addTravel,HttpStatus.CREATED);
		
	}
	@PutMapping("/travels/{travelId}")
	public ResponseEntity<Travels> updateTravelsHandler(@Valid @RequestBody Travels travel, @PathVariable("travelId") Integer travelId){
		
		Travels updatetravel = travelservice.updateTravels( travel, travelId);
		
		return new ResponseEntity<>(updatetravel,HttpStatus.OK);
		
	}
	@DeleteMapping("/deleteTravel/{travelId}")
	public ResponseEntity<Travels> removeTravelsHandler(@Valid @PathVariable("travelId") Integer travelId){
 
     Travels removetravel = travelservice.removeTravels(travelId);
		
		return new ResponseEntity<>(removetravel,HttpStatus.OK);
	
	}
	
	
	@GetMapping("/searchTravel/{travelId}")
	public ResponseEntity<Travels> serchTravelsHandler(@Valid @PathVariable("travelId") Integer travelId){
        
	     Travels searchtravel = travelservice.serchTravels(travelId);
			return new ResponseEntity<>(searchtravel,HttpStatus.OK);


		
		
	}
		
		@GetMapping("/getTravels/")
	   public ResponseEntity<List<Travels>> viewTravelsHandler(){

		List<Travels> viewlist = travelservice.viewTravels();
		return new ResponseEntity<>(viewlist,HttpStatus.OK);
	
	}
	
}
