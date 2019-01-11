package com.meriame.metier;

import com.meriame.model.Agent;

public interface AgentMetier {
	
	public Agent findAgentByUsername(String username);
	public Agent saveAgent(Agent agent);
	

}
