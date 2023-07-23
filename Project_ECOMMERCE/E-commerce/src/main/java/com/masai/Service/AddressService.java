package com.masai.Service;

import com.masai.Exception.AddressException;
import com.masai.Exception.CustomersException;
import com.masai.Model.Address;

public interface AddressService {

	public Address addAddress(Address address)throws AddressException;
	public Address getAddressByCustomerId(int cid) throws AddressException,CustomersException;
	public Address updateAddressByCustomerId(int cid,Address address)throws AddressException,CustomersException;
	public Address deleteAddressByCustomerId(int cid)throws AddressException,CustomersException;
	
}
