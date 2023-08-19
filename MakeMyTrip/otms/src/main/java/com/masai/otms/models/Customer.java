package com.masai.otms.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

//    @NotNull(message = "Name Cannot be empty or blank or null")
//    @NotEmpty(message = "Name Cannot be empty or blank or null")
//    @NotBlank(message = "Name Cannot be empty or blank or null")
    @Size(min = 3, max = 20, message = "Name should be 3 to 20 letters")
    private String name;

//    @NotBlank(message = "Password Cannot be empty or blank or null")
//    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Password must be at least 8 characters long, and contain at least one uppercase letter, one lowercase letter, one digit, and one special character")
    private String password;

//    @NotNull(message = "Address Cannot be empty or blank or null")
//    @NotEmpty(message = "Address Cannot be empty or blank or null")
//    @NotBlank(message = "Address Cannot be empty or blank or null")
    @Size(min = 3, max = 20, message = "Address should be 3 to 20 letters")
    private String address;

//    @NotNull(message = "Email Cannot be empty or blank or null")
//    @NotEmpty(message = "Email Cannot be empty or blank or null")
//    @NotBlank(message = "Email Cannot be empty or blank or null")
    @Size(min = 3, max = 20, message = "Email should be 3 to 20 letters")
    @Email
//    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email Format: abc1234@domain.com")
    private String email;

//    @NotNull(message = "Phone Number Cannot be empty or blank or null")
//    @NotEmpty(message = "Phone Number Cannot be empty or blank or null")
//    @NotBlank(message = "Phone Number Cannot be empty or blank or null")
    @Size(min = 10, max = 13, message = "Country Code(+91) + 10 digit Phone Number ")
//    @Pattern(regexp = "^\\+91[1-9]\\d{9}$", message = "Format: +911234567809")
    private String phoneNumber;


    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Feedback> feedbacks;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private List<TicketDetails> ticketDetails;

}
