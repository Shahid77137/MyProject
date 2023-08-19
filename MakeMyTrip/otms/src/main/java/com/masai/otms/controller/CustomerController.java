package com.masai.otms.controller;

import com.masai.otms.models.Customer;
import com.masai.otms.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",  allowedHeaders = "*")
@RequestMapping("/cs-con")
public class CustomerController {

    @Autowired
    CustomerService customerService;

//    @Autowired
//    private PasswordEncoder passwordEncoder;
    private Customer customer;

    @PostMapping("/customers")
    public ResponseEntity<Customer> saveCustomerHandler(@RequestBody Customer customer){

//        customer.setPassword(passwordEncoder.encode(customer.getPassword()));

        Customer registeredCustomer= customerService.addCustomer(customer);

        return new ResponseEntity<>(registeredCustomer, HttpStatus.ACCEPTED);

    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomerHandler(){


        List<Customer> customers= customerService.viewAllCustomer();

        return new ResponseEntity<>(customers,HttpStatus.ACCEPTED);

    }
    @PostMapping("/customers/{cId}")
    public ResponseEntity<String> updateDetails(@PathVariable @Valid Integer cId, @Valid @RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.updateCustomer(cId, customer));
    }

    @DeleteMapping("/customers/{cId}")
    public ResponseEntity<String> deleteCustomer(@Valid @PathVariable("cId") Integer id) {
        return ResponseEntity.ok(customerService.deleteCustomer(id));
    }

    @GetMapping("/customers/{cId}")
    public ResponseEntity<Customer> getById(@PathVariable("cId") Integer id) {
        return ResponseEntity.ok(customerService.viewCustomer(id));
    }

}
