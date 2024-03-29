package com.masai.Model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customers {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int customerId;

//private String firstname;
//
//private String lastname;
@NotNull(message = "age cannot be null")
private String name;

@NotNull(message = "age cannot be null")

@Min(value = 18, message = "Age should be 18 or greater")
private int age;
@NotNull(message = "gender cannot be null")

@Enumerated(EnumType.STRING)
private GenderTypeEnum gender; //Enum

@NotNull(message = "email cannot be null")
@NotEmpty(message = "email cannot be empty")
@NotBlank(message = "email cannot be blank")
@Column(unique = true)
@Email(message = "Invalid email format")
private String email;

@NotNull(message = "email cannot be null")
@NotEmpty(message = "email cannot be empty")
@NotBlank(message = "email cannot be blank")
@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%!]).{8,}$",
message = "Password must have at least 8 characters, one uppercase letter, one lowercase letter, one number, and one special character")
@JsonProperty(access = Access.WRITE_ONLY)
private String password;

@NotNull(message = "email cannot be null")
@NotEmpty(message = "email cannot be empty")
@NotBlank(message = "email cannot be blank")
@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%!]).{8,}$",
message = "Password must have at least 8 characters, one uppercase letter, one lowercase letter, one number, and one special character")
@JsonProperty(access = Access.WRITE_ONLY)
private String confirm_password;

@NotNull(message = "phone cannot be null")
@Digits(integer = 10, fraction = 0, message = "Phone number should have exactly 10 digits")
@Column(unique = true)
private long phone;

	
@JsonFormat(pattern = "dd-MM-yyyy")
private LocalDate DateofBirth;






@OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER , mappedBy = "customers")
private Address address;

@OneToOne(cascade = CascadeType.ALL , fetch = FetchType.EAGER , mappedBy = "customers")
private Cart cart;

@OneToMany(mappedBy = "customers", cascade = CascadeType.ALL)
private List<Orders> orders;

	
@OneToMany(mappedBy = "customer" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
private List<Feedback> feedbacks;


}
