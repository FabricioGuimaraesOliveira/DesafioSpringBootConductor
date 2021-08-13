package com.conductor.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conductor.demo.model.Registro;



public interface RegistroRepository extends JpaRepository<Registro, Long> {

}