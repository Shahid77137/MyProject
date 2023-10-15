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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BookingItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookingItemId;

    @Enumerated(EnumType.STRING)
    private BookingType type;
 
    @ManyToOne
    @JoinColumn(name = "bookingId")
    private Booking booking;

}
