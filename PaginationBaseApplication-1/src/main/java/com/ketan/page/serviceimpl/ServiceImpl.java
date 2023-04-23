package com.ketan.page.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ketan.page.entity.Products;
import com.ketan.page.entity.Users;
import com.ketan.page.exception.UserException;
import com.ketan.page.repository.ProductRepo;
import com.ketan.page.repository.UserRepo;
import com.ketan.page.service.ProductService;
import com.ketan.page.service.UserService;

@Service
public class ServiceImpl implements UserService,ProductService {

	private UserRepo uRepo;
	private ProductRepo pRepo;

	@Autowired
	public ServiceImpl(UserRepo uRepo, ProductRepo pRepo) {
		this.uRepo = uRepo;
		this.pRepo = pRepo;
	}

	@Override
	public Users saveUser(Users user) throws UserException {
		Optional<Users> optional = uRepo.findByMobile(user.getMobile());
		if(optional.isPresent()) {
			throw new UserException("User Exist with same mobile: "+user.getMobile()+", please change!");
		}
		Users u = uRepo.save(user);
		return u;
	}

	@Override
	public List<Users> getAllUserList() {
		List<Users> list = uRepo.findAll();
		
		return list;
	}

	@Override
	public Products saveProduct(Products product){
		Products products = pRepo.save(product);
		return products;
	}

	@Override
	public List<Products> getAllProductList() {
		List<Products> list = pRepo.findAll();
		return list;
	}

	// pagination
	@Override
	public List<Products> getAllProductsPageWise(Integer pageNumber, Integer numberOfRecords) {
		Pageable p = PageRequest.of(pageNumber-1, numberOfRecords);
		
		//using method of PagingAndSortingRepository
		Page<Products> page= pRepo.findAll(p);
		
		List<Products> list = page.getContent();
		
		return list;
	}

}
