package com.masai.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.masai.Model.Customers;
@Repository
public interface CustomerRepository extends JpaRepository<Customers, Integer>{

	
//	
	@Query("SELECT c FROM Customers c WHERE c.name = ?1")
    public List<Customers> findByName(String name);
	
	
	public boolean existsByEmail(String email);
	
	
	public boolean existsByPhone(Long phone);
	
	
	public Customers findByEmail(String email);
	
	public Customers findByPhone(Long phone);
	
	
}
