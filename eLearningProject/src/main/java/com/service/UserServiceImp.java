package com.service;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.userRepo;
import com.model.User;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	userRepo urepo;
	
	@Override
	public User save(User user) {
		
		return urepo.save(user);
	}

	@Override
	public List<User> getAll() {
	
		return urepo.findAll();
	}

	@Override
	public User getOne(long id) {
		return urepo.findById((long) id).orElse(null);

	}

	@Override
	public Map<String, Object> deleteUser(long id) throws ClassNotFoundException, Exception {
		
		Map<String,Object>response=new HashMap<String,Object>();
		try {
			User u=urepo.findById(id).orElseThrow(()-> new ClassNotFoundException("User Not Exits"+id));
			urepo.delete(u);
			response.put("deleted", Boolean.TRUE);
		}
		catch(ClassNotFoundException u)
		{
			response.put("not deleted", u.getMessage());
		}
		
		return response;
	}

	@Override
	public User updateUser(User user) {
		
		System.out.println(user.getId());
		User u=urepo.findById(user.getId()).orElse(null);
		
		u.setName(u.getName());;
		u.setEmail(u.getEmail());
		u.setMobile(u.getMobile());
		return urepo.save(u);
	}

}
