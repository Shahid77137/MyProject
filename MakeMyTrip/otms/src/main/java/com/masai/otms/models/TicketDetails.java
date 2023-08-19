package com.masai.otms.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class TicketDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ticketId;

    @NotNull(message = "Ticket Status Cannot be empty or blank or null")
    @Size(min = 3, max = 20, message = "Ticket Status should be 3 to 20 letters")
    private String status;
}
