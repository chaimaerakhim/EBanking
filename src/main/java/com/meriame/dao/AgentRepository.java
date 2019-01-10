package com.meriame.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meriame.model.Agent;

public interface AgentRepository extends JpaRepository<Agent, Long> {
	
	public Agent findByUsername(String username);
	public Agent findAgentById(long id);

}
