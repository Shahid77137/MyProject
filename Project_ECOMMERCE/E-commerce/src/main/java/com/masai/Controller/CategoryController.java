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

import com.masai.Exception.AddressException;
import com.masai.Exception.CategoryException;
import com.masai.Exception.CustomersException;
import com.masai.Model.Address;
import com.masai.Model.Cart;
import com.masai.Model.Category;
import com.masai.Service.AddressService;
import com.masai.Service.CategoryService;

@RestController
@RequestMapping("/Category")
@CrossOrigin("*")
public class CategoryController {

	@Autowired
	public CategoryService categoryService;
	
	
	@PostMapping("/addCategory")
	public ResponseEntity<Category> addCategory(@RequestBody Category category)throws CategoryException{
		Category cat = categoryService.addCategory(category);
		return new ResponseEntity<>(cat,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/getAllProductsByCategoryId/{catid}")
	public ResponseEntity<Category> getAllProductsByCategoryId(@PathVariable int catid)throws CategoryException{
		
		Category cat = categoryService.getAllProductsByCategoryId(catid);
		return new ResponseEntity<>(cat,HttpStatus.OK);
	}
	
	
	
	@PutMapping("/updateCategoryById/{catId}")
	public ResponseEntity<Category> updateCategoryById(@PathVariable int catId,@RequestBody Category category)throws CategoryException{
		Category cat = categoryService.updateCategoryById(catId, category);
		return new ResponseEntity<>(cat,HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("/deleteCategoryById/{catId}")
	public ResponseEntity<Category> deleteCategoryById(@PathVariable int catId)throws CategoryException{
		Category cat = categoryService.deleteCategoryById(catId);
		return new ResponseEntity<>(cat,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/getAllCategory")
	public ResponseEntity<List<Category>> getAllCategory()throws CategoryException{
		List<Category> list = categoryService.getAllCategory();
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	
}
