package com.masai.otms.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity
@Data
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer busId;

    @NotNull(message = "Name Cannot be empty or blank or null")
    @NotEmpty(message = "Name Cannot be empty or blank or null")
    @NotBlank(message = "Name Cannot be empty or blank or null")
    @Size(min = 3, max = 20, message = "Name should be 3 to 20 letters")
    private String busName;

    @NotNull(message = "Bus Type Cannot be empty or blank or null")
    @NotEmpty(message = "Bus Type Cannot be empty or blank or null")
    @NotBlank(message = "Bus Type Cannot be empty or blank or null")
    @Size(min = 3, max = 20, message = "Bus Type should be 3 to 20 letters")
    private String busType;

    private Integer capacity;

    @ManyToOne
    @JoinColumn(name = "route_id")
    private Route route;
}
