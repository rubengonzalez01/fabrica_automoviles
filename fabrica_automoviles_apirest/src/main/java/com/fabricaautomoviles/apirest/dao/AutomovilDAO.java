package com.fabricaautomoviles.apirest.dao;

import java.util.List;
import com.fabricaautomoviles.apirest.entity.Automovil;

public interface AutomovilDAO {

	public List<Automovil> findAll();
	public void delete(Automovil auto);
	public Automovil save(Automovil auto);
	public Automovil findById(int id);	
}
