package com.desafio.demo.core;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lombok.Data;

@Data
public class CodinomeWrapper {

	@JacksonXmlProperty(localName = "codinome")
    @JacksonXmlElementWrapper(useWrapping = false) 
    private List<String> codinomes;
}
