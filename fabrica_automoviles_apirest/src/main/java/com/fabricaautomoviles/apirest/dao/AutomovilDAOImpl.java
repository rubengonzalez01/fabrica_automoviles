package com.fabricaautomoviles.apirest.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabricaautomoviles.apirest.entity.Automovil;
import com.fabricaautomoviles.apirest.repository.AutomovilRepository;

@Service
public class AutomovilDAOImpl implements AutomovilDAO{

	@Autowired
	private AutomovilRepository automovilRepository;
	
	@Override
	public Automovil save(Automovil auto) {
		
		auto.obtenerCosto();
		
		return automovilRepository.save(auto);		
	}	
	
	@Override
	public List<Automovil> findAll() {
		return automovilRepository.findAll();		
	}
	
	@Override
	public Automovil findById(int id) {
		
		try {
			Optional<Automovil> valor = automovilRepository.findById(id);
			return valor.get();
		}
		catch(Exception e) {
			throw new RuntimeException("Automovil ID not found: "+id);
		}
		
	}
	
	@Override
	public void delete(Automovil auto) {
		automovilRepository.delete(auto);		
	}	
	
}
