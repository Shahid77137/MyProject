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
import lombok.Data;

@Data
@Entity
public class Train {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer trainId;

	@NotBlank(message = "Train name cannot be blank")
	private String trainName;

	@NotBlank(message = "Train number cannot be blank")
	private String trainNumber;

	@NotBlank(message = "Departure station cannot be blank")
	private String departureStation;

	@NotBlank(message = "Destination station cannot be blank")
	private String destinationStation;

	@NotNull(message = "Departure date/time cannot be null")
	private LocalDateTime departureDateTime;

	@NotNull(message = "Arrival date/time cannot be null")
	private LocalDateTime arrivalDateTime;

	@DecimalMin(value = "0.0", message = "Ticket price must be a non-negative value")
	private Double ticketPrice;

	@Min(value = 0, message = "Available seats must be a non-negative integer")
	private Integer availableSeats;

	@Min(value = 1, message = "Train capacity must be at least 1")
	private Integer trainCapacity;

	@NotBlank(message = "Image URL cannot be blank")
	private String image;
	

    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL)
    private List<Booking> bookings = new ArrayList<>();

    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL)
    private List<Feedback> feedbacks = new ArrayList<>();

    @OneToMany(mappedBy = "train", cascade = CascadeType.ALL)
    private List<Customer> customers = new ArrayList<>();

}
