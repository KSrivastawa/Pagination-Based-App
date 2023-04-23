package com.ketan.page.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ketan.page.entity.Products;
import com.ketan.page.entity.Users;
import com.ketan.page.exception.UserException;
import com.ketan.page.service.ProductService;
import com.ketan.page.service.UserService;

@RestController
public class MyController {

	private UserService userService;
	private ProductService productService;
	
	@Autowired
	public MyController(UserService userService, ProductService productService) {
		this.userService = userService;
		this.productService = productService;
	}
	
	// ========Users=======
	
	@PostMapping("/saveu")
	public ResponseEntity<Users> saveUserHandler(@RequestBody Users users) throws UserException{
		Users savedUser=userService.saveUser(users);
		
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/getu")
	public ResponseEntity<List<Users>> getAllUsersHandler(){
		List<Users> users = userService.getAllUserList();
		
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	// ========Products=======
	
	@PostMapping("/savep")
	public ResponseEntity<Products> saveProductHandler(@RequestBody Products products) throws UserException{
		Products savedProduct = productService.saveProduct(products);
		
		return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
	}
	
	@GetMapping("/getp")
	public ResponseEntity<List<Products>> getAllProductsHandler(){
		List<Products> products = productService.getAllProductList();
		
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	// pagination
	
	@GetMapping("/page/{pageNumber}/{numberOfRecords}")
	public ResponseEntity<List<Products>> getAllProductsPageWise(@PathVariable Integer pageNumber, @PathVariable Integer numberOfRecords) {
	
		List<Products> list = productService.getAllProductsPageWise(pageNumber, numberOfRecords);
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
}




