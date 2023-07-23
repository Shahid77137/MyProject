package com.masai.Service;

import com.masai.Exception.CartException;
import com.masai.Exception.ProductsException;
import com.masai.Model.Cart;
import com.masai.Model.Products;

public interface CartService {

	public Products addProductToCart(int pid,int quantity,int cid)throws ProductsException,CartException;
	public Cart updateProductQuantity(int newquantity,int pid,int cid)throws ProductsException,CartException;
	public String deleteProductFromCart(int pid,int cid)throws ProductsException,CartException;
	public Cart getCartById(int cid)throws CartException;
	
}
