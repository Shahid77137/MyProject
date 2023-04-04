package com.masaischool.dao;

import java.util.List;

import com.masaischool.dto.Orders;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomeThingWrongException;

public interface OrderDAO {
	public void purchaseProduct(int prodId, int quantity) throws SomeThingWrongException;
	public List<Orders> getAllOrders() throws SomeThingWrongException, NoRecordFoundException;
	public List<Orders> getOrdersOfLoggedInUser() throws SomeThingWrongException, NoRecordFoundException;
}
