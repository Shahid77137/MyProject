package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Exception.AddressException;
import com.masai.Exception.CartException;
import com.masai.Exception.CustomersException;
import com.masai.Exception.ProductsException;
import com.masai.Model.Address;
import com.masai.Model.Cart;
import com.masai.Model.Products;
import com.masai.Service.AddressService;
import com.masai.Service.CartService;

@RestController
@RequestMapping("/Cart")
@CrossOrigin("*")
public class CartController {

	
	@Autowired
	public CartService cartService;
	
	
	@PostMapping("/addProductToCart/{pid}/{cid}/{quantity}")
	public ResponseEntity<Products> addProductToCart(@PathVariable int pid,@PathVariable int quantity,@PathVariable int cid)throws ProductsException,CartException{
		Products crt = cartService.addProductToCart(pid, quantity, cid);
		return new ResponseEntity<>(crt,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/updateProductQuantity/{cid}/{pid}/{newquantity}")
	public ResponseEntity<Cart> updateProductQuantity(@PathVariable int newquantity,@PathVariable int pid,@PathVariable int cid)throws ProductsException,CartException{
		
	Cart crt = cartService.updateProductQuantity(newquantity, pid, cid);
		return new ResponseEntity<>(crt,HttpStatus.OK);
	}
	
	
	
	@PutMapping("/deleteProductFromCart/{cid}/{pid}")
	public ResponseEntity<String> deleteProductFromCart(@PathVariable int pid,@PathVariable int cid)throws ProductsException,CartException{
		String crt = cartService.deleteProductFromCart(pid, cid);
		return new ResponseEntity<>(crt,HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/getCartById/{cid}")
	public ResponseEntity<Cart> getCartById(@PathVariable int cid)throws CartException{
		Cart crt = cartService.getCartById(cid);
		return new ResponseEntity<>(crt,HttpStatus.OK);
		
	}
	
}
