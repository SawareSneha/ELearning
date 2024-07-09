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

import com.model.User;
import com.service.UserService;

@RestController
//@RequestMapping("/us/user")
public class UserController {
	
	@Autowired
	UserService userservice;

	@PostMapping("/saveUser")
	public User save(@RequestBody User user) {
		
		return userservice.save(user);
	}
	@GetMapping("/getallUser")
	public List<User> getAll() {
	
		return userservice.getAll();
	}
	
	@GetMapping("/getOneUser/{id}")
	public User getOne(@PathVariable("id")long id)
	{
		return userservice.getOne(id);
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<Map<String,Object>> deleteUser(@PathVariable("id")long id) throws Exception
	{
		Map<String,Object> response =userservice.deleteUser(id);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/updateUser/{id}")
	public ResponseEntity<User> updateUser(@RequestBody User user)
	{
		User u=userservice.updateUser(user);
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("update", "User updated").body(u);
	}
}
