package com.masai.Model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Feedback {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int feedbackId;
private String customerFeedback;
private boolean deliveredFeedback;
private boolean cancelationFeedback;
private boolean returnFeedback;
@Max(5)
private double rating;
@CreationTimestamp
private LocalDateTime feedbackCreatedDate;

@ManyToOne
@JoinColumn(name = "customerId")
private Customers customer;

@OneToOne(mappedBy = "feedback" , cascade = CascadeType.ALL , fetch = FetchType.EAGER)
private Orders order;

}
