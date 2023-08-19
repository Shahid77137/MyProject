package com.masai.otms.service.Implementations;


import com.masai.otms.exceptions.CustomerException;
import com.masai.otms.models.Customer;
import com.masai.otms.repository.CustomerRepo;
import com.masai.otms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo cRepo;
    @Override
    public Customer addCustomer(Customer C) {
        return cRepo.save(C);
    }

    @Override
    public String updateCustomer(Integer id, Customer c) {
        Customer customer = cRepo.findById(id).orElseThrow(() -> new CustomerException("Invalid Customer Id"));
        customer.setAddress(c.getAddress());
        customer.setEmail(c.getEmail());
        customer.setName(c.getName());
        customer.setPassword(c.getPassword());
        customer.setPhoneNumber(c.getPhoneNumber());
        cRepo.save(customer);
        return "Customer data has been updated.";
    }

    @Override
    public String deleteCustomer(Integer id) {
        Customer customer = cRepo.findById(id).orElseThrow(() -> new CustomerException("Invalid Customer Id"));
        cRepo.delete(customer);
        return "Customer with id: " + id + " has been removed.";
    }

    @Override
    public Customer viewCustomer(Integer id) {
        return cRepo.findById(id).orElseThrow(() -> new CustomerException("Invalid Customer Id"));
    }

    @Override
    public List<Customer> viewAllCustomer() {
        List<Customer> list = cRepo.findAll();
        if(!(list != null && list.size() == 0)) return list;
        throw new CustomerException("No Data available to show");
    }
}
