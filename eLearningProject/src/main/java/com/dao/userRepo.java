package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.User;

public interface userRepo extends JpaRepository<User, Long> 
{

}
