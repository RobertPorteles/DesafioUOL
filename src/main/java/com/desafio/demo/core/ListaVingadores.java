package com.desafio.demo.core;

import java.util.List;

public class ListaVingadores {

	private List<Vingadores> vingadores;

	public ListaVingadores(List<Vingadores> vingadores) {
		super();
		this.vingadores = vingadores;
	}

	public ListaVingadores() {
		super();
	}

	public List<Vingadores> getVingadores() {
		return vingadores;
	}

	public void setVingadores(List<Vingadores> vingadores) {
		this.vingadores = vingadores;
	}
	
	
}
