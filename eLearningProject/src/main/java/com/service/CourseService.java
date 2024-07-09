package com.service;
import java.util.List;

import java.util.Map;

import com.model.Course;



public interface CourseService 
{
	public Course save(Course course);
	
	public Course getOne(long id);
	
	public List<Course> getAllcourse();
	
	public Map<String,Object> deleteCourse(long id) throws ClassNotFoundException,Exception;
	
	public Course updateCourse(Course course);

}
