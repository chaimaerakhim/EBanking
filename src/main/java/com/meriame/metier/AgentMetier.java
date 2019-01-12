package com.meriame.metier;

import java.util.List;

import com.meriame.model.Agent;


public interface AgentMetier {
	
	public Agent findAgentByCin(String cin);
	public Agent saveAgent(Agent agent);
	public Agent SaveAgent(Agent c);
	public Agent editAgent(Agent agent);
	public List<Agent> getAllAgents();
	public Agent getAgentbyId(long id_agent);
	public Agent findAgentByUsername(String username);
	
	public void deleteAgentByCin(String cin);

}
