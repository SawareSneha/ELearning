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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Module;
import com.service.ModuleService;

@RestController
//@RequestMapping("/mo/module")
public class ModuleController {

	@Autowired
	ModuleService moduleservice;
	
	@PostMapping("/saveModule")
	public Module save(@RequestBody Module module) {
		
		return moduleservice.save(module);
	}
	
	@GetMapping("/getOneModule/{id}")
	public Module getOne(@PathVariable("id")long id)
	{
		return moduleservice.getOne(id);
	}

	@GetMapping("/getallModule")
	public List<Module> getAll() {
	
		return moduleservice.getAllModule();
	}
	
	
	@DeleteMapping("/deleteModule/{id}")
	public ResponseEntity<Map<String,Object>> deleteModule(@PathVariable("id")long id) throws Exception
	{
		Map<String,Object> response =moduleservice.deleteModule(id);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/updateModule")
	public ResponseEntity<Module> updateModule(@RequestBody Module module)
	{
		Module m=moduleservice.updateModule(module);
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("update", "Module updated").body(m);
	}
}
