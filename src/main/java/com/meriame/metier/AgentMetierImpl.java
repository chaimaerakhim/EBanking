package com.meriame.metier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meriame.dao.AgentRepository;
import com.meriame.model.Agent;

@Service
public class AgentMetierImpl implements AgentMetier {

	@Autowired
	private AgentRepository agentRepository;
	
	@Override
	public Agent findAgentByUsername(String username) {
		
		return agentRepository.findByUsername(username);
	}

}
