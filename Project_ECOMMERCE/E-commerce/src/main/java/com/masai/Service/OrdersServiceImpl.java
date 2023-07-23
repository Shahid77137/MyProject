package com.masai.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exception.CustomersException;
import com.masai.Exception.OrdersException;
import com.masai.Model.Customers;
import com.masai.Model.Orders;
import com.masai.Repository.OrdersRepository;

@Service
public class OrdersServiceImpl implements OrdersService{

	@Autowired
	private OrdersRepository orderRepository;
	
	@Override
	public Orders createOrder(Orders order) throws OrdersException {
		
		if(orderRepository.existsById(order.getOrderId())) {
			throw new OrdersException("Order already exists with id "+order.getOrderId());
		}
		
		return orderRepository.save(order);
	}

	@Override
	public Orders getOrderById(int oid) throws OrdersException {
Optional<Orders> orders = orderRepository.findById(oid);
		
		if(orders.isEmpty()) {
			throw new OrdersException("Order doesn't exists with id "+oid);
		}
		
		return orders.get();
	}

	@Override
	public List<Orders> getAllOrders() throws OrdersException {
List<Orders> list = orderRepository.findAll();
		
		if(list.isEmpty()) {
			throw new OrdersException("No order found");
		}
		
		return list;
	}

	@Override
	public Orders updateOrders(int oid,Orders orders) throws OrdersException {
Optional<Orders> order = orderRepository.findById(oid);
		
		if(order.isEmpty()) {
			throw new OrdersException("Order doesn't exists with id "+oid);
		}
		
		Orders custo = order.get();
		
		custo.setOrderStatus(orders.getOrderStatus());
		custo.setExpectedDeliveryDate(orders.getExpectedDeliveryDate());
		custo.setOrderreplaced(orders.isOrderreplaced());
		custo.setOrdercancelled(orders.isOrdercancelled());
		custo.setOrderreturned(orders.isOrderreturned());
		custo.setOrderCreatedDate(orders.getOrderCreatedDate());
		custo.setOrderUpdatedDate(orders.getOrderUpdatedDate());
		
		return orderRepository.save(custo);
	}

	@Override
	public Orders deleteOrders(int oid) throws OrdersException {
Optional<Orders> orders = orderRepository.findById(oid);
		
		if(orders.isEmpty()) {
			throw new OrdersException("No customer exists with id "+oid); 
		}
		
		orderRepository.delete(orders.get());
		
		return orders.get();
	}

}
