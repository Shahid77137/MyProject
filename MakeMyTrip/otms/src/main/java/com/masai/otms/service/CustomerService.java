package com.masai.otms.service;

import com.masai.otms.models.Customer;

import java.util.List;

public interface CustomerService {
    Customer addCustomer(Customer C);
    String updateCustomer(Integer id, Customer c);
    String deleteCustomer(Integer id);
    Customer viewCustomer(Integer id);
    List<Customer> viewAllCustomer();
}
