package com.example.demo.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entitys.Pacientes;
import com.example.demo.repository.PacientesRepo;

@RestController
@RequestMapping(value = "/pacientes")
public class PacientesController {
	
	@Autowired
	PacientesRepo repository;
	
	@GetMapping
	public Collection<Pacientes> getListaPacientes(){
		Iterable<Pacientes> listaPacientes = repository.findAll();
		
		return (Collection<Pacientes>) listaPacientes;
	}

	@GetMapping(value = "/{id}")
	public Pacientes getPacientes(@PathVariable(name = "id") Long id) {
		
		Optional<Pacientes> paciente = repository.findById(id);
		Pacientes result = null;
		if(paciente.isPresent()) {
			result = paciente.get();
		}
		return result;
	}
	@PostMapping
	public Pacientes createPaciente(@RequestBody Pacientes pacientes) {
		Pacientes nuevoPaciente = repository.save(pacientes);
		return nuevoPaciente;
	}
	
	@DeleteMapping(value = "/{id}")
	public void deletePaciente (@PathVariable(name = "id") Long id) {
		repository.deleteById(id);
	}
	
	@PutMapping(value = "/{id}")
	public Pacientes uptadePaciente(@PathVariable(name = "id") Long id,
			@RequestBody Pacientes pacientes) {
		Optional<Pacientes> Paciente1 = repository.findById(id);
		if(Paciente1.isPresent()) {
			Pacientes actual = Paciente1.get();
			actual.setId(id);
			actual.setPrimerNombre(pacientes.getPrimerNombre());
			actual.setSegundoNombre(pacientes.getSegundoNombre());
			actual.setPrimerApellido(pacientes.getPrimerApellido());
			actual.setSegundoApellido(pacientes.getSegundoApellido());
			actual.setEdad(pacientes.getEdad());
			Pacientes uptatedPaciente = repository.save(actual);
			return uptatedPaciente;
			
		}
		return null;
	}
	
}
