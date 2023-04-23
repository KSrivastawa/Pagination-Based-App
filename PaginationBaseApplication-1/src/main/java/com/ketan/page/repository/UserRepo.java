package com.ketan.page.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ketan.page.entity.Users;

public interface UserRepo extends JpaRepository<Users, String>{

	public Optional<Users> findByMobile(String mobile);
	
}
