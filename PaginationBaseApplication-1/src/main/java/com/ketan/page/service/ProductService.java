package com.ketan.page.service;

import java.util.List;

import com.ketan.page.entity.Products;

public interface ProductService {

	public Products saveProduct(Products product);
	
	public List<Products> getAllProductList();
	
	// for pagination
	public List<Products> getAllProductsPageWise(Integer pageNumber, Integer numberOfRecords);
	
}
