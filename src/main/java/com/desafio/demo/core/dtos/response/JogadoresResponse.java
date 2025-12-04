package com.desafio.demo.core.dtos.response;

import java.util.UUID;



public class JogadoresResponse {
	private UUID id;
	
	private String nome;
	
	private String email;
	
	private String telefone;

	private String codinome;
	
	private String grupo;

	
	
	public JogadoresResponse() {
		super();
	}

	public JogadoresResponse(UUID id, String nome, String email, String telefone, String codinome, String grupo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.codinome = codinome;
		this.grupo = grupo;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCodinome() {
		return codinome;
	}

	public void setCodinome(String codinome) {
		this.codinome = codinome;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	
	
	
}
