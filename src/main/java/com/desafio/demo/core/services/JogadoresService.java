package com.desafio.demo.core.services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.desafio.demo.core.Jogadores;
import com.desafio.demo.core.ListaLigaDaJustica;
import com.desafio.demo.core.ListaVingadores;
import com.desafio.demo.core.Vingadores;
import com.desafio.demo.core.dtos.request.JogadoresRequest;
import com.desafio.demo.core.dtos.response.JogadoresResponse;
import com.desafio.demo.infrastructure.H2Persistence;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;

import lombok.RequiredArgsConstructor;
	
@Service
@RequiredArgsConstructor
public class JogadoresService {
	
	
	private final H2Persistence persistence;
	
	
	private static final String urlVingadores = "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/vingadores.json";
	private static final String urlLigaJustica = "https://raw.githubusercontent.com/uolhost/test-backEnd-Java/master/referencias/liga_da_justica.xml";
	

	public JogadoresResponse registro(JogadoresRequest entitieRequest) throws Exception{
		
		Jogadores entities = new Jogadores();
		
		
		
		entities.setNome(entitieRequest.getNome());
		entities.setEmail(entitieRequest.getEmail());
		entities.setTelefone(entitieRequest.getTelefone());
		
		
		String grupo = entitieRequest.getGrupo();
		
		var codinomes = play(grupo);
		
		
		for(String codinome : codinomes) {
			if(!persistence.existsByCodinome(codinome)) {
				entities.setCodinome(codinome);
			}
			else {
				throw new RuntimeException("A lista não possui codinomes disponiveis!");
			}
		}
		
		entities.setGrupo(entitieRequest.getGrupo());
		
		
		persistence.save(entities);
		
		JogadoresResponse response = new JogadoresResponse();
		
		response.setNome(entities.getNome());
		response.setEmail(entities.getEmail());
		response.setTelefone(entities.getTelefone());
		response.setCodinome(entities.getCodinome());
		response.setGrupo(entities.getGrupo());
		
		
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
	

			if (lista.equals("Vingadores")) {
				
				HttpClient client = HttpClient.newHttpClient();

	            // 2. Criar a requisição HTTP (GET)
	            HttpRequest request = HttpRequest.newBuilder()
	                    .uri(URI.create(urlVingadores))
	                    .build();

	            // 3. Enviar a requisição e obter a resposta como String
	            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	            
	            String json = response.body();
	            
				var gson = new Gson();
				
				var codinome = gson.fromJson(json, ListaVingadores.class);
				
				var listAll = codinome.getVingadores();
				
				for(Vingadores c : listAll) {
					
					codinomes.add(c.getCodinome());
				
				}
				
				return codinomes;
			}
			
			if(lista.equalsIgnoreCase("Liga da Justiça")) {
				
				HttpClient client = HttpClient.newHttpClient();

	            // 2. Criar a requisição HTTP (GET)
	            HttpRequest request = HttpRequest.newBuilder()
	                    .uri(URI.create(urlLigaJustica))
	                    .build();

	            // 3. Enviar a requisição e obter a resposta como String
	            HttpResponse<String> resp = client.send(request, HttpResponse.BodyHandlers.ofString());
	            
	            String xmlInput = resp.body();
	            
	            XmlMapper xmlMapper = new XmlMapper();
			
	            xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

	            var justiceLeague = xmlMapper.readValue(xmlInput, ListaLigaDaJustica.class);
				
				
				for(String codinome : justiceLeague.getCodinomesWrapper().getCodinomes()) {
					codinomes.add(codinome);
				}
				
				return codinomes;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();

			return null;

		}
		
		return null;
	}
	
}
