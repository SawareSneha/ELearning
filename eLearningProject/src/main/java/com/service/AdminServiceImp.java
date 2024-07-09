package com.service;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.adminRepo;
import com.model.Admin;

@Service
public class AdminServiceImp implements AdminService {

	@Autowired
	adminRepo arepo;
	
	@Override
	public Admin save(Admin admin) {
		
		return arepo.save(admin);
		
	}

	@Override
	public Admin getOne(long id) {
		// TODO Auto-generated method stub
		return  arepo.findById(id).orElse(null);

	}

	@Override
	public List<Admin> getAll() {
				return arepo.findAll();
	}

	@Override
	public Map<String, Object> deleteAdmin(long id) throws ClassNotFoundException, Exception {
	
		Map<String,Object>response=new HashMap<String,Object>();
		try {
			Admin a=arepo.findById(id).orElseThrow(()-> new ClassNotFoundException("Admin Not Exits"+id));
			arepo.delete(a);
			response.put("deleted", Boolean.TRUE);
		}
		catch(ClassNotFoundException a)
		{
			response.put("not deleted", a.getMessage());
		}
		
		
		return response;

	}

	@Override
	public Admin updateAdmin(Admin admin) {
		
		System.out.println(admin.getId());
		Admin a=arepo.findById(admin.getId()).orElse(null);
		
		a.setAdminEmail(a.getAdminEmail());
		a.setName(a.getName());
		return arepo.save(a);

	}

}
