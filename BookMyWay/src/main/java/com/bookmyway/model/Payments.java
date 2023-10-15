package com.bookmyway.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Payments {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer paymentId;

	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

	@NotNull(message = "Payment date/time cannot be null")
	private LocalDateTime paymentDateTime;

	@DecimalMin(value = "0.0", message = "Amount must be a non-negative value")
	private double totalAmount;

	@Enumerated(EnumType.STRING)
	private Status status;

	@Enumerated(EnumType.STRING)
	private MethodType methodType;

}
