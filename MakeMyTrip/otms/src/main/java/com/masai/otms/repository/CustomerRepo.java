package com.masai.otms.repository;

import com.masai.otms.models.Admin;
import com.masai.otms.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    public Optional<Customer> findByEmail(String email);
}
