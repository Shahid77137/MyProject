package com.masai.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Orders {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int orderId;
private String orderStatus;
private LocalDate expectedDeliveryDate;
private boolean isOrderreplaced;
private boolean isOrdercancelled;
private boolean isOrderreturned;
@CreationTimestamp
private LocalDateTime orderCreatedDate;
@UpdateTimestamp
private LocalDateTime orderUpdatedDate;



@ManyToOne
@JoinColumn(name = "customerId")
private Customers customers;

@ManyToOne
@JoinColumn(name = "cartId")
private Cart cart;

@OneToOne
@JoinColumn(name = "feedbackId")
private Feedback feedback;

@OneToOne(mappedBy = "orders" , cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
private Payments payments;

@OneToMany(mappedBy = "orders" , cascade = CascadeType.ALL , fetch = FetchType.LAZY)
private List<Products> products;

}
