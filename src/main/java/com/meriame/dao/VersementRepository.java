package com.meriame.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meriame.model.Versement;

public interface VersementRepository extends JpaRepository<Versement, Long> {

}
