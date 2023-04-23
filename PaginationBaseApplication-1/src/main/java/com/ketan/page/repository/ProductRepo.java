package com.ketan.page.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ketan.page.entity.Products;

public interface ProductRepo extends JpaRepository<Products, String>, PagingAndSortingRepository<Products, String>{

	@Query("from Products")
	Page<Products> getAllProducts(Pageable p);
	
}
