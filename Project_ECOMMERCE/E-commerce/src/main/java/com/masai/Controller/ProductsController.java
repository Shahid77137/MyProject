package com.masai.Controller;

import java.util.List;

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

import com.masai.Exception.CategoryException;
import com.masai.Exception.ProductsException;
import com.masai.Model.Category;
import com.masai.Model.Products;
import com.masai.Service.CategoryService;
import com.masai.Service.ProductsService;

@RestController
@RequestMapping("/Products")
@CrossOrigin("*")
public class ProductsController {

	@Autowired
	public ProductsService productsService;
	
	
	@PostMapping("/addProduct")
	public ResponseEntity<Products> addProduct(@RequestBody Products product)throws ProductsException{
		Products cat = productsService.addProduct(product);
		return new ResponseEntity<>(cat,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/getProductById/{prodId}")
	public ResponseEntity<Products> getProductById(@PathVariable int prodId)throws ProductsException{
		
		Products cat = productsService.getProductById(prodId);
		return new ResponseEntity<>(cat,HttpStatus.OK);
	}
	
	
	
	@PutMapping("/updateProduct/{prodId}")
	public ResponseEntity<Products> updateProduct(@PathVariable int prodId,@RequestBody Products products)throws ProductsException{
		Products cat = productsService.updateProduct(prodId, products);
		return new ResponseEntity<>(cat,HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/deleteProduct/{prodId}")
	public ResponseEntity<Products> deleteProduct(@PathVariable int prodId)throws ProductsException {
		Products cat = productsService.deleteProduct(prodId);
		return new ResponseEntity<>(cat,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/getAllProducts")
	public ResponseEntity<List<Products>> getAllProducts()throws ProductsException{
		List<Products> list = productsService.getAllProducts();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
	@GetMapping("/searchByName/{productName}")
    public ResponseEntity<List<Products>> searchByName(@PathVariable String productName)throws ProductsException{
    	

    	List<Products> list = productsService.searchByName(productName);
    	
    	return new ResponseEntity<>(list,HttpStatus.OK);
    }
 	
	@GetMapping("/searchByBrand/{productBrand}")
 	public ResponseEntity<List<Products>> searchByBrand(@PathVariable String productBrand)throws ProductsException{
 		
 		List<Products> list = productsService.searchByBrand(productBrand);
 		
 		return new ResponseEntity<>(list,HttpStatus.OK);
 	}

	
	@GetMapping("/searchByType/{productType}")
 	public ResponseEntity<List<Products>> searchByType(@PathVariable String productType)throws ProductsException{
 		
 		List<Products> list = productsService.searchByType(productType);
 		
 		return new ResponseEntity<>(list,HttpStatus.OK);
 	}

	
	@GetMapping("/searchByRating/{rating}")
 	public ResponseEntity<List<Products>> searchByRating(@PathVariable double rating)throws ProductsException{
 		
 		List<Products> list = productsService.searchByRating(rating);
 		
 		return new ResponseEntity<>(list,HttpStatus.OK);
 	}

	
	@GetMapping("/searchByisAvailable/{isAvailable}")
 	public ResponseEntity<List<Products>> searchByisAvailable(@PathVariable boolean isAvailable)throws ProductsException{
 		
 		List<Products> list = productsService.searchByisAvailable(isAvailable);
 		
 		return new ResponseEntity<>(list,HttpStatus.OK);
 	}
	
	
	
}
