package com.masai.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int AddressId;
@NotNull(message = "address cannot be null")
@NotEmpty(message = "address cannot be empty")
@NotBlank(message = "address cannot be blank")
private String address;
private String addressTwo;
private String buildingName;
private int houseNumber;
private String landmark;
@NotNull(message = "state cannot be null")
@NotEmpty(message = "state cannot be empty")
@NotBlank(message = "state cannot be blank")
private String country;
@NotNull(message = "state cannot be null")
@NotEmpty(message = "state cannot be empty")
@NotBlank(message = "state cannot be blank")
private String state;
@NotNull(message = "city cannot be null")
@NotEmpty(message = "city cannot be empty")
@NotBlank(message = "city cannot be blank")
private String city;
@NotNull(message = "pin cannot be null")
@NotEmpty(message = "pin cannot be empty")
@NotBlank(message = "pin cannot be blank")
private int pin;
@CreationTimestamp
private LocalDateTime addressCreatedDate;
@UpdateTimestamp
private LocalDateTime addressUpdatedDate;

@OneToOne
@JoinColumn(name = "customerId")
private Customers customers;
	
	
}
