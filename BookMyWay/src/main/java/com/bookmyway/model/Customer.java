package com.bookmyway.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;

	@NotBlank(message = "First name cannot be blank")
	private String firstName;

	@NotBlank(message = "Last name cannot be blank")
	private String lastName;

	@NotNull(message = "Gender cannot be null")
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@NotBlank(message = "Seat number cannot be blank")
	private String seatNumber;

	@NotBlank(message = "Nationality cannot be blank")
	private String nationality;

	@Min(value = 18, message = "Age must be at least 18")
	private int age;

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

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Feedback> feedbacksList = new ArrayList<>();

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Payments> paymentList = new ArrayList<>();

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Coupon> couponList = new ArrayList<>();
}
