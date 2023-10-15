package com.bookmyway.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer flightId;

	@NotBlank(message = "Airline name cannot be blank")
	private String airlineName;

	@NotBlank(message = "Flight number cannot be blank")
	private String flightNumber;

	@NotBlank(message = "Departure airport cannot be blank")
	private String departureAirport;

	@NotBlank(message = "Destination airport cannot be blank")
	private String destinationAirport;

	@NotNull(message = "Departure date/time cannot be null")
	private LocalDateTime departureDateTime;

	@NotNull(message = "Arrival date/time cannot be null")
	private LocalDateTime arrivalDateTime;

	@DecimalMin(value = "0.0", message = "Ticket price must be a non-negative value")
	private Double ticketPrice;

	@Min(value = 0, message = "Available seats must be a non-negative integer")
	private Integer availableSeats;

	@Min(value = 1, message = "Flight capacity must be at least 1")
	private Integer flightCapacity;

	@NotBlank(message = "Image URL cannot be blank")
	private String image;

	@OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
	private List<Booking> bookings = new ArrayList<>();

	@OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
	private List<Feedback> feedbacks = new ArrayList<>();

	@OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
	private List<Customer> customers = new ArrayList<>();

}
