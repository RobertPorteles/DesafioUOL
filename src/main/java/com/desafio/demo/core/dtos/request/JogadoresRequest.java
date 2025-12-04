package com.desafio.demo.core.dtos.request;

public class JogadoresRequest {
	
	private String nome;
	
	private String email;
	
	private String telefone;
	
	private String grupo;

	
	
	public JogadoresRequest() {
		super();
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


	public String getGrupo() {
		return grupo;
	}



	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	
	
	
}
