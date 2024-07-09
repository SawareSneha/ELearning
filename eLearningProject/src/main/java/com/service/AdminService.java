package com.service;

import java.util.List;

import java.util.Map;

import com.model.Admin;



public interface AdminService {

	public Admin save(Admin admin);
	
	public Admin getOne(long id);

	public List<Admin> getAll();
	
	public Map<String,Object> deleteAdmin(long id) throws ClassNotFoundException,Exception;
	
	public Admin updateAdmin(Admin admin);
}
