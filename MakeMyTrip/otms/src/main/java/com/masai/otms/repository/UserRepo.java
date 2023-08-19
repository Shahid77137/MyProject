package com.masai.otms.repository;

import com.masai.otms.models.Customer;
import com.masai.otms.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {
    public Optional<Users> findByUserType(String userType);

}
