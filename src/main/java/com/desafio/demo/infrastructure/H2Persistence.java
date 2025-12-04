package com.desafio.demo.infrastructure;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.demo.core.Jogadores;

@Repository
public interface H2Persistence extends JpaRepository<Jogadores, UUID>{

}
