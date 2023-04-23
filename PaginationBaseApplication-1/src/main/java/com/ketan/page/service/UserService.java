package com.ketan.page.service;

import java.util.List;

import com.ketan.page.entity.Users;
import com.ketan.page.exception.UserException;

public interface UserService {

	public Users saveUser(Users user)throws UserException;
	
	public List<Users> getAllUserList();
	
}
