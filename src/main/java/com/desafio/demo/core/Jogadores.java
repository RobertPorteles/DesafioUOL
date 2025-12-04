package com.desafio.demo.core;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "Jogadores")
public class Jogadores {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	
	@Column(name = "nome")
	private String nome;
	@Column(name = "email", unique = true)
	private String email;
	@Column(name = "telefone", unique = true)
	private String telefone;
	@Column(name = "codinome", unique = true)
	private String codinome;
	
	@Column(name = "grupo")
	private String grupo;

	
	
	public Jogadores() {
		super();
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
