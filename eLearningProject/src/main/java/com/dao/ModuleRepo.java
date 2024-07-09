package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.model.Module;

public interface ModuleRepo extends JpaRepository<Module,Long>{

}
