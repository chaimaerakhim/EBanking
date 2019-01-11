package com.meriame.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meriame.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
	
	public Client findByUsername(String username);
	public Client findById(long id);
	public Client findByCin(String cin);

}
