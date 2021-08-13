package com.conductor.demo.resource;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.conductor.demo.event.RecursoCriadoEvent;
import com.conductor.demo.model.Registro;
import com.conductor.demo.repositories.RegistroRepository;
import com.conductor.demo.service.RegistroService;


@RestController
@RequestMapping("/v1.0/entidade")
public class RegistroResource {
	
	
	@Autowired
	private RegistroRepository registroRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private RegistroService registroService;
	
	@Autowired
	Validator validator;
	
	@GetMapping()
	public List<Registro> listar() {
		return registroRepository.findAll();
	}
	
	@GetMapping("/{logic}")
	public ResponseEntity<Registro> buscarPeloCodigo(@PathVariable Long logic) {
		 Registro registro = registroRepository.findById(logic)
                 .orElse(null);
		 return registro != null ? ResponseEntity.ok(registro) : ResponseEntity.notFound().build();
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = {"application/json"},consumes= "text/html")
	public ResponseEntity<?> registrarLog(@RequestBody String params,HttpServletResponse response) {
		
        Registro registro = stringTransform(params);
		
       Set<ConstraintViolation<Registro>> violations = validator.validate(registro);
		if (!violations.isEmpty()) {
		  throw new ConstraintViolationException(violations);
		}

		try {
			
			registroRepository.save(registro);
			publisher.publishEvent(new RecursoCriadoEvent(this, response, registro.getLogic()));
			System.out.println("Registro salvo com sucesso");
		} catch(Exception ex) {
			
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).body(registro);
	}
	
	@PutMapping("/{logic}")
	public ResponseEntity<Registro> atualizar(@PathVariable Long logic, @Valid @RequestBody Registro registro) {
		Registro registroSalvo = registroService.atualizar(logic, registro);
		return ResponseEntity.ok(registroSalvo);
	}
	
	
	
	public Registro stringTransform(String s){
			Registro  m = new Registro();
				
			String[] splitted = Arrays.stream(s.split(";"))
					  .map(String::trim)
					  .toArray(String[]::new);
			
			try {
				
				m.setLogic((Long.valueOf(splitted[0])));
				m.setSerial(splitted[1]);
				m.setModel((splitted[2]));
				m.setSam(Long.valueOf(splitted[3]));
				m.setPtid((splitted[4]));
				m.setPlat(Long.valueOf(splitted[5]));
				m.setVersion((splitted[6]));
				m.setMxr(Long.valueOf(splitted[7]));
				m.setMxf(Long.valueOf(splitted[8]));
				m.setVerfm((splitted[9]));
				
			} catch(Exception ex) {
				
			
			}
			
			
		return m;
	}
}