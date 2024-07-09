package com.service;
import java.util.List;

import java.util.Map;

import com.model.User;

public interface UserService 
{
	public User save(User user);
	
	public User getOne(long id);

	public List<User> getAll();
	
	public Map<String,Object> deleteUser(long id) throws ClassNotFoundException,Exception;
	
	public User updateUser(User user);
}
