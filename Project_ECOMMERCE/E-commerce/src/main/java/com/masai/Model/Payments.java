package com.masai.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payments {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int paymentId;
private String paymentType;
@CreationTimestamp
private LocalDateTime paymentCreatedDate;
@UpdateTimestamp
private LocalDateTime paymentUpdatedDate;
private boolean allowed;

@OneToOne
@JoinColumn(name = "orderId")
private Orders orders;

}
