package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
