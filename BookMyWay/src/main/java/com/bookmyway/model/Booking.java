package com.bookmyway.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingId;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	@OneToMany(mappedBy = "booking")
	private List<BookingItem> bookingItems;

	@NotNull(message = "Booking date/time cannot be null")
	private LocalDateTime bookingDateTime;

	@DecimalMin(value = "0.0", message = "Total price must be a non-negative value")
	private double totalPrice;

	@Enumerated(EnumType.STRING)
	private Status status;
	
	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "hotelId")
	private Hotel hotel;

	@ManyToOne
	@JoinColumn(name = "flightId")
	private Flight flight;

	@ManyToOne
	@JoinColumn(name = "trainId")
	private Train train;

	@ManyToOne
	@JoinColumn(name = "busId")
	private Bus bus;
	
}