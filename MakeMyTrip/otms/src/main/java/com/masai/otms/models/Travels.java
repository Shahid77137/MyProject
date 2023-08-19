package com.masai.otms.models;


import java.time.LocalDate; 
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import jakarta.persistence.*;

import jakarta.validation.constraints.*;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
//@Data
@Setter
@Getter
@NoArgsConstructor
public class Travels {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer travelId;

    @NotNull(message = "Travels Name Cannot be empty or blank or null")
    @NotEmpty(message = "Travels Name Cannot be empty or blank or null")
    @NotBlank(message = "Travels Name Cannot be empty or blank or null")
    @Size(min = 3, max = 20, message = "Travels Name should be 3 to 20 letters")
    private String travelsName;

    @NotNull(message = "Name Cannot be empty or blank or null")
    @NotEmpty(message = "Name Cannot be empty or blank or null")
    @NotBlank(message = "Name Cannot be empty or blank or null")
    @Size(min = 3, max = 20, message = "Name should be 3 to 20 letters")
    private String agentName;

    @NotNull(message = "Address Cannot be empty or blank or null")
    @NotEmpty(message = "Address Cannot be empty or blank or null")
    @NotBlank(message = "Address Cannot be empty or blank or null")
    @Size(min = 3, max = 20, message = "Address should be 3 to 20 letters")
    private String address;

    @NotNull(message = "Phone Number Cannot be empty or blank or null")
    @NotEmpty(message = "Phone Number Cannot be empty or blank or null")
    @NotBlank(message = "Phone Number Cannot be empty or blank or null")
    @Size(min = 13, max = 13, message = "Country Code(+91) + 10 digit Phone Number ")
    @Pattern(regexp = "^\\+91[1-9]\\d{9}$", message = "Format: +911234567809")
    private String phoneNumber;

    
    
  
    
    
    
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "travel")
    private List<Package> pkglist = new ArrayList<>();
    
    


    @ManyToOne
    @JoinColumn(name = "package_id")
    private Package aPackage;

}
