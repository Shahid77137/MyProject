package com.masai.otms.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.transform.sax.SAXTransformerFactory;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer routeId;

    @NotNull(message = "Name Cannot be empty or blank or null")
    @NotEmpty(message = "Name Cannot be empty or blank or null")
    @NotBlank(message = "Name Cannot be empty or blank or null")
    @Size(min = 3, max = 20, message = "Name should be 3 to 20 letters")
    private String routeFrom;

    @NotNull(message = "Name Cannot be empty or blank or null")
    @NotEmpty(message = "Name Cannot be empty or blank or null")
    @NotBlank(message = "Name Cannot be empty or blank or null")
    @Size(min = 3, max = 20, message = "Name should be 3 to 20 letters")
    private String routeTo;

    private LocalDateTime departureTime;

    private LocalDateTime arrivalTime;

    @Future(message = "Date of journey must be in the future with format: yyyy-MM-dd")
    private LocalDate doj;

    @NotNull(message = "Pickup Point Cannot be empty or blank or null")
    @NotEmpty(message = "Pickup Point Cannot be empty or blank or null")
    @NotBlank(message = "Pickup Point Cannot be empty or blank or null")
    @Size(min = 3, max = 20, message = "Pickup Point should be 3 to 20 letters")
    private String pickupPoint;

    @NotNull(message = "Fare cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Fare should be greater than 0.0")
    private Double fare;

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
    private List<Bus> buses;

}
