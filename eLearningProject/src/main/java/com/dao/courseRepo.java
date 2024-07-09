package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Course;


public interface courseRepo extends JpaRepository<Course, Long> 
{

}
