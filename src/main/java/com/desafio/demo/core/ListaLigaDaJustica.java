package com.desafio.demo.core;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;

@JacksonXmlRootElement(localName = "liga_da_justica")
@Data
public class ListaLigaDaJustica {

	  @JacksonXmlProperty(localName = "codinomes")
	   private CodinomeWrapper codinomesWrapper;
}
