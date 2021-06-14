package com.example.demo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entitys.Citas;
import com.example.demo.entitys.Pacientes;
import com.example.demo.repository.CitasRepo;

import java.util.Optional;

@RestController
@RequestMapping(value = "/citas")
public class CitasController {
	
	@Autowired
	CitasRepo repository;
	
	@GetMapping
	public Collection<Citas> getCitas(){
		Iterable<Citas> listaCitas = repository.findAll();
		
		return(Collection<Citas>) listaCitas;
	}
	
	@GetMapping(value = "/{id}")
	public Citas getCitas(@PathVariable(name = "id") Long id) {
		
		Optional<Citas> citas = repository.findById(id);
		Citas result = null;
		if(citas.isPresent()) {
			result = citas.get();
			
		}
		return result;
	}
	
	@PostMapping
	public Citas createCita(@RequestBody Citas citas) {
		Citas nuevaCita = repository.save(citas);
		return nuevaCita;
	}
	
	@DeleteMapping(value = "/{id}")
	public void deleteCita (@PathVariable(name = "id") Long id) {
		repository.deleteById(id);
	}
	
	@PutMapping(value = "/{id}")
	public Citas uptadeCitas(@PathVariable(name = "id") Long id,
			@RequestBody Citas cita) {
		Optional<Citas> Citas1 = repository.findById(id);
		if(Citas1.isPresent()) {
			Citas actual = Citas1.get();
			actual.setId(id);
			actual.setFecha(cita.getFecha());
			actual.setHora(cita.getHora());
			actual.setPaciente(cita.getPaciente());
			actual.setEstado(cita.getEstado());
			actual.setObservaciones(cita.getObservaciones());
			Citas uptatedCitas = repository.save(actual);
			return uptatedCitas;	
		}
		return null;
	}
	
	
	

}
