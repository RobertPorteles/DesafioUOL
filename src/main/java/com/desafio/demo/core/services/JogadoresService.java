package com.desafio.demo.core.services;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.desafio.demo.core.Jogadores;
import com.desafio.demo.core.ListaVingadores;
import com.desafio.demo.core.dtos.request.JogadoresRequest;
import com.desafio.demo.core.dtos.response.JogadoresResponse;
import com.desafio.demo.infrastructure.H2Persistence;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;

@Service
@Data
public class JogadoresService {
	
	
	private H2Persistence persistence;
	
	
	
	public JogadoresService(H2Persistence persistence) {
		super();
		this.persistence = persistence;
	}



	public JogadoresResponse registro(JogadoresRequest entitieRequest) throws Exception{
		
		Jogadores entities = new Jogadores();
		
		entities.setNome(entitieRequest.getNome());
		entities.setEmail(entitieRequest.getEmail());
		entities.setTelefone(entitieRequest.getTelefone());
		entities.setCodinome(entitieRequest.getCodinome());
		entities.setGrupo(entitieRequest.getGrupo());
		
		
		persistence.save(entities);
		
		JogadoresResponse response = new JogadoresResponse();
		
		response.setNome(entities.getNome());
		response.setEmail(entities.getEmail());
		response.setTelefone(entities.getTelefone());
		response.setCodinome(entities.getCodinome());
		response.setGrupo(entities.getGrupo());
		
		String grupo = entitieRequest.getGrupo();
		play(entitieRequest.getGrupo().toString() ) ;
		
		return response;
		
		
		
	}
	
	public List<JogadoresResponse> finAll() {
		
		var lista = persistence.findAll();
		
		return lista.stream().map(this::toResponse).toList();
	}
	
	private JogadoresResponse toResponse(Jogadores entities) {
		
		JogadoresResponse response = new JogadoresResponse();
		
		response.setId(entities.getId());
		response.setNome(entities.getNome());
		response.setEmail(entities.getEmail());
		response.setTelefone(entities.getTelefone());
		response.setCodinome(entities.getCodinome());
		response.setGrupo(entities.getGrupo());
		
		return response;
	}
	private List<String> play(String lista) {
		
	List<String> codinomes = new ArrayList<>();
		
		try {
			ObjectMapper obj = new ObjectMapper();

			if (lista.equals("Vingadores")) {
				var url = new URL(
						"https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/vingadores.json");
				
				var codinome = obj.readValue(url, ListaVingadores.class);
				
				
			
			}
		} catch (Exception e) {
			e.printStackTrace();

			return null;

		}
		
		return null;
	}
	
}
