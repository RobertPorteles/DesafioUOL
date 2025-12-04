package com.desafio.demo.infrastructure;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.desafio.demo.core.Jogadores;

@Repository
public interface H2Persistence extends JpaRepository<Jogadores, UUID>{

	@Query("""
			SELECT COUNT(j) > 0 
			FROM Jogadores j
			WHERE j.codinome = :codinome
			""")
	boolean existsByCodinome(@Param("codinome") String codinome);
}
