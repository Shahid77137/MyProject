package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.Model.Orders;
@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>{

}
