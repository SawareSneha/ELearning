package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.courseRepo;
import com.model.Course;

@Service
public  class CourseServiceImp implements CourseService{

	@Autowired
	courseRepo crepo;
	
	@Override
	public Course save(Course course) {
		
			return crepo.save(course);

	}

	@Override
	public List<Course> getAllcourse() {
		
		return crepo.findAll();
	}

	@Override
	public Course getOne(long id) {
		return crepo.findById((long) id).orElse(null);
	}

	@Override
	public Map<String, Object> deleteCourse(long id) throws ClassNotFoundException, Exception {
		
		Map<String,Object>response=new HashMap<String,Object>();
		try {
			Course c=crepo.findById(id).orElseThrow(()-> new ClassNotFoundException("Course Not Exits"+id));
			crepo.delete(c);
			response.put("deleted", Boolean.TRUE);
		}
		catch(ClassNotFoundException c)
		{
			response.put("not deleted", c.getMessage());
		}
		
		return response;
	}


	@Override
	public Course updateCourse(Course course) {
		
		System.out.println(course.getCid());
		Course c=crepo.findById(course.getCid()).orElse(null);
		
		c.setCname(c.getCname());;
		c.setDuration(c.getDuration());
		return crepo.save(c);
	}

	
	
}
