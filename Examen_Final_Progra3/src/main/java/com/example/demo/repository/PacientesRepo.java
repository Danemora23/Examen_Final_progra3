package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entitys.Pacientes;

public interface PacientesRepo extends CrudRepository<Pacientes, Long>{

}
