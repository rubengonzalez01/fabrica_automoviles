package com.fabricaautomoviles.apirest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabricaautomoviles.apirest.dao.AutomovilDAO;
import com.fabricaautomoviles.apirest.entity.Automovil;

//Indico que es un controlador rest
@RestController
@RequestMapping("/api") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/api/

public class AutomovilRestController {
	
	//Inyecto el servicio para poder hacer uso de el
	@Autowired
	AutomovilDAO automovilDAO;

	//Este método guardará al automovil enviado
	/*http://127.0.0.1:8080/api/autos/  */
	@PostMapping("/autos")
	public Automovil createAutomovil(@Valid @RequestBody Automovil auto) {
		
		return automovilDAO.save(auto);
		
	}
	
	
	/*Este método retornará todos los automoviles
	http://127.0.0.1:8080/api/autos*/
	@GetMapping("/autos")
	public List<Automovil> getAllAutomovil(){
		
		return automovilDAO.findAll();
	}
	
			
	/*Este método retornará al automovil con id pasado en la url
	http://127.0.0.1:8080/api/autos/1*/
	@GetMapping("/autos/{id}")
	public ResponseEntity<Automovil> getAutomoviles(@PathVariable(value="id") int autoId){
		Automovil auto = automovilDAO.findById(autoId);
		
		if(auto == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok().body(auto);
	}
	
		
	/*Este método actualizará al automovil enviado segun el id
	http://127.0.0.1:8080/api/autos/  */
	@PutMapping("/autos/{id}")
	public ResponseEntity<Automovil> updateAutomovil(@PathVariable(value="id") int autoId, @RequestBody Automovil autoDetails) {
		
		Automovil auto = automovilDAO.findById(autoId);
		
		if(auto == null) {
			return ResponseEntity.notFound().build();
		}
		
		auto.setNombre(autoDetails.getNombre());
		auto.setOpcionales(autoDetails.getOpcionales());
		
		Automovil updateAuto = automovilDAO.save(auto);
		
		return ResponseEntity.ok().body(updateAuto);
	}
	
	
	/*Este método recibira el id de un automovil por URL y se borrará de la bd.
	http://127.0.0.1:8080/api/autos/1  */
	@DeleteMapping("autos/{id}")
	public ResponseEntity<Automovil> deleteAutomovil(@PathVariable(value="id") int autoId) {
		
		Automovil auto = automovilDAO.findById(autoId);
		
		if(auto == null) {
			return ResponseEntity.notFound().build();
		}
		
		automovilDAO.delete(auto);
		return ResponseEntity.ok().build();
	}
		
}

