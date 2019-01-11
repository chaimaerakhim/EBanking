package com.meriame.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.meriame.model.Compte;



public interface CompteRepository extends JpaRepository<Compte,  Long>{
	public Compte findByIdCompte(Long id_compte);
	
	@Query("select c from Compte c where c.client.id = :id")
	public List<Compte> findByClientId(@Param("id")long id);
	
}
