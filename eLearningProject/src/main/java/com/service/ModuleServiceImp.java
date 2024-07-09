package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.dao.ModuleRepo;
import com.model.Module;


@Service
public class ModuleServiceImp implements ModuleService {

	@Autowired
	ModuleRepo mrepo;

	@Override
	public Module save(Module module) {
		// TODO Auto-generated method stub
		return mrepo.save(module);
	}

	@Override
	public Module getOne(long id) {
		
		return mrepo.findById((long) id).orElse(null);
	}

	@Override
	public List<Module> getAllModule() {
		
		return mrepo.findAll();
	}

	@Override
	public Map<String, Object> deleteModule(long id) throws ClassNotFoundException, Exception {
		
		Map<String,Object>response=new HashMap<String,Object>();
		try {
			Module m=mrepo.findById(id).orElseThrow(()-> new ClassNotFoundException("Module Not Exits"+id));
			mrepo.delete(m);
			response.put("deleted", Boolean.TRUE);
		}
		catch(ClassNotFoundException m)
		{
			response.put("not deleted", m.getMessage());
		}
		
		return response;
	}

	@Override
	public Module updateModule(Module module) {
		
		System.out.println(module.getId());
		Module m=mrepo.findById(module.getId()).orElse(null);
		
		m.setModuleName(m.getModuleName());
		m.setContent(m.getContent());
		m.setDuration(m.getDuration());
		return mrepo.save(m);
	}
	
	
}

	
