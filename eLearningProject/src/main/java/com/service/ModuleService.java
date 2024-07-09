package com.service;
import java.util.List;
import java.util.Map;

import com.model.Module;

public interface ModuleService {

	public Module save(Module module);
	
	public Module getOne(long id);
	
	public List<Module> getAllModule();
	
	public Map<String,Object> deleteModule(long id) throws ClassNotFoundException,Exception;
	
	public Module updateModule(Module module);

}
