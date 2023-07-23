package com.masai.Model;

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
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int categoryId;
private String categoryname;
private String categorydescripiton;
private boolean activate;
@CreationTimestamp
private LocalDateTime addressCreatedDate;
@UpdateTimestamp
private LocalDateTime addressUpdatedDate;

@OneToMany(mappedBy = "category" , cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
private List<Products> products;


}
