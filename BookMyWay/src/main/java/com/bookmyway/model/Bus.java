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
public class Bus {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer busId;

	@NotBlank(message = "Bus company name cannot be blank")
	private String busCompany;

	@NotBlank(message = "Bus number cannot be blank")
	private String busNumber;

	@NotBlank(message = "Departure city cannot be blank")
	private String departureCity;

	@NotBlank(message = "Destination city cannot be blank")
	private String destinationCity;

	@NotNull(message = "Departure date/time cannot be null")
	private LocalDateTime departureDateTime;

	@NotNull(message = "Arrival date/time cannot be null")
	private LocalDateTime arrivalDateTime;

	@DecimalMin(value = "0.0", message = "Ticket price must be a non-negative value")
	private double ticketPrice;

	@Min(value = 0, message = "Available seats must be a non-negative integer")
	private int availableSeats;

	@Min(value = 1, message = "Bus capacity must be at least 1")
	private int busCapacity;

	@NotBlank(message = "Image URL cannot be blank")
	private String image;

    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL)
    private List<Booking> bookings = new ArrayList<>();

    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL)
    private List<Feedback> feedbacks = new ArrayList<>();

    @OneToMany(mappedBy = "bus", cascade = CascadeType.ALL)
    private List<Customer> customers = new ArrayList<>();
	
}
