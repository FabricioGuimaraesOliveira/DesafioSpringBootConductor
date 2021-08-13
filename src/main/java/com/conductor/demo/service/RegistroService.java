package com.conductor.demo.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.conductor.demo.model.Registro;
import com.conductor.demo.repositories.RegistroRepository;

@Service
public class RegistroService {
	
	@Autowired
	private RegistroRepository registroRepository;

	public Registro atualizar(Long logic, Registro registro) {
		Registro registroSalvo = registroRepository.findById(logic)
                .orElse(null);
		if (registroSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		
		BeanUtils.copyProperties(registro, registroSalvo, "codigo");
		return registroRepository.save(registroSalvo);
	}
	
	public Registro getRegistro(Long logic) {
		Registro registro = registroRepository.findById(logic)
                .orElse(null);
		if (registro == null) {
			throw new EmptyResultDataAccessException(1);
		}

		return registro;
	}
}
