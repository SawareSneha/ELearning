package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.model.Admin;
import com.service.AdminService;

@RestController
//@RequestMapping("/ad/admin")
public class AdminController {

	@Autowired
	AdminService adminservice;
	
	@PostMapping("/saveAdmin")
	public Admin save(@RequestBody Admin admin) {
		
		return adminservice.save(admin);
	}
	@GetMapping("/getOneAdmin/{id}")
	public Admin getOne(@PathVariable("id")long id)
	{
		return adminservice.getOne(id);
	}

	@GetMapping("/getallAdmin")
	public List<Admin> getAll() {
	
		return adminservice.getAll();
	}
	
	
	@DeleteMapping("/deleteAdmin/{id}")
	public ResponseEntity<Map<String,Object>> deleteAdmin(@PathVariable("id")long id) throws Exception
	{
		Map<String,Object> response =adminservice.deleteAdmin(id);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/updateAdmin")
	public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin)
	{
		Admin a=adminservice.updateAdmin(admin);
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("update", "Admin updated").body(a);
	}
}
