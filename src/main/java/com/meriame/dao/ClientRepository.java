package com.meriame.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meriame.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
	
	public Client findByUsername(String username);

}
