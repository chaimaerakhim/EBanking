package com.meriame.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.meriame.model.Agence;

public interface AgenceRepository extends JpaRepository<Agence, Long> {

	public Agence findAgenceById(long id_agence);
}
