package com.masai.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.AddressException;
import com.masai.Exception.CustomersException;
import com.masai.Model.Address;
import com.masai.Model.Customers;
import com.masai.Repository.AddressRepository;
import com.masai.Repository.CustomerRepository;

@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Address addAddress(Address address) throws AddressException {
        
		if(addressRepository.existsById(address.getAddressId())) {
			throw new AddressException("Address alreday exists");
		}else {
			return addressRepository.save(address);
		}
		

	}

	@Override
	public Address getAddressByCustomerId(int cid) throws AddressException, CustomersException {
		
		Optional<Customers> customer = customerRepository.findById(cid);
		
		if(customer.isEmpty()) {
			throw new CustomersException("Customer doesn't exists with id "+cid);
		}else {
			return customer.get().getAddress();
		}

	}

	@Override
	public Address updateAddressByCustomerId(int cid, Address address) throws AddressException, CustomersException {
	    Optional<Customers> customer = customerRepository.findById(cid);

	    if (customer.isEmpty()) {
	        throw new CustomersException("Customer doesn't exist with id " + cid);
	    }

	    Customers existingCustomer = customer.get();
	    Address existingAddress = existingCustomer.getAddress();

	    if (existingAddress == null) {
	        throw new AddressException("Customer doesn't have an address");
	    }

	    // Update the address properties with the new values
	    existingAddress.setAddress(address.getAddress());
	    existingAddress.setAddressTwo(address.getAddressTwo());
	    existingAddress.setBuildingName(address.getBuildingName());
	    existingAddress.setHouseNumber(address.getHouseNumber());
	    existingAddress.setLandmark(address.getLandmark());
	    existingAddress.setCountry(address.getCountry());
	    existingAddress.setState(address.getState());
	    existingAddress.setCity(address.getCity());
	    existingAddress.setPin(address.getPin());
	    existingAddress.setAddressCreatedDate(address.getAddressCreatedDate());
	    existingAddress.setAddressUpdatedDate(address.getAddressUpdatedDate());
	    
	    

	    // Save the updated address
	    Address updatedAddress = addressRepository.save(existingAddress);

	    return updatedAddress;
	}

	@Override
	public Address deleteAddressByCustomerId(int cid) throws AddressException, CustomersException {
		
		Optional<Customers> customer = customerRepository.findById(cid);
		
		
		if(customer.isEmpty()) {
			throw new CustomersException("Customer doesn't exists with id "+cid);
		}
		
		Address ad = customer.get().getAddress();
		addressRepository.delete(ad);
		return ad;
		
	}

}
