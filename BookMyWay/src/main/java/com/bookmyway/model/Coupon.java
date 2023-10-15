package com.bookmyway.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Coupon {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer couponId;

	@NotNull(message = "Coupon code cannot be null")
	@Size(min = 1, max = 50, message = "Coupon code must be between 1 and 50 characters")
	private String couponCode;

	@NotNull(message = "Description cannot be null")
	@Size(min = 1, max = 255, message = "Description must be between 1 and 255 characters")
	private String description;

	@DecimalMin(value = "0.0", message = "Discount amount must be a non-negative value")
	private double discountAmount;

	@NotNull(message = "Expiry date cannot be null")
	@FutureOrPresent(message = "Expiry date must be a future or present date")
	private LocalDate expiryDate;

	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

}
