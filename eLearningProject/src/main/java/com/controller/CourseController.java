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

import com.model.Course;
import com.service.CourseService;

@RestController
//@RequestMapping("/co/course")
public class CourseController 
{

	@Autowired
	CourseService  courseservice;
	
	@PostMapping("/saveCourse")
	public Course csave(@RequestBody Course course)
	{
		return courseservice.save(course);
	}
	
	@GetMapping("/getAllCourse")
	public List<Course> getAllcourse() {
		
		return courseservice.getAllcourse();
	}

	@GetMapping("/getOneCourse/{id}")
	public Course getOne(@PathVariable("id")long id)
	{
		return courseservice.getOne(id);
	}
	
	@DeleteMapping("/deleteCourse/{id}")
	public ResponseEntity<Map<String,Object>> deleteCourse(@PathVariable("id")long id) throws Exception
	{
		Map<String,Object> response =courseservice.deleteCourse(id);
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/updateCourse")
	public ResponseEntity<Course> updateCourse(@RequestBody Course course)
	{
		Course c=courseservice.updateCourse(course);
		return ResponseEntity.status(HttpStatus.ACCEPTED).header("update", "Course updated").body(c);
	}

	
}
