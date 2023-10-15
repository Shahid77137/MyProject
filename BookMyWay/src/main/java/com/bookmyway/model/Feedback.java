package com.bookmyway.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer feedbackId;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	@Enumerated(EnumType.STRING)
	private BookingType bookingType;

	@Enumerated(EnumType.STRING)
	private Rating rating;

	private String comment;

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
