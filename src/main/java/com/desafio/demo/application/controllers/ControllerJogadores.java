package com.desafio.demo.application.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.demo.core.dtos.request.JogadoresRequest;
import com.desafio.demo.core.dtos.response.JogadoresResponse;
import com.desafio.demo.core.services.JogadoresService;

@RestController
@RequestMapping("/api/v1/cadastro")
public class ControllerJogadores {
	
	JogadoresService service;
	
	
	

	public ControllerJogadores(JogadoresService service) {
		super();
		this.service = service;
	}


	@PostMapping()
	public JogadoresResponse registro(@RequestBody JogadoresRequest play) throws Exception{
		
		
		
		return service.registro(play);
		
	}
	
	@GetMapping()
	public List<JogadoresResponse> GetRegistro() {
		return service.finAll();
		
	}
	
	
	
}
