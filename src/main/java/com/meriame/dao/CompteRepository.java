package com.meriame.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meriame.model.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long>{

}
