package com.meriame.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.meriame.dao.AgentRepository;
import com.meriame.model.Agent;


@Service
public class AgentMetierImpl implements AgentMetier {

	@Autowired
	private AgentRepository agentRepository;
	
	
	@Autowired
	private BCryptPasswordEncoder bcp;
	
	@Override
	public Agent SaveAgent(Agent c) {
		String hashPW=bcp.encode(c.getPassword());
		c.setPassword(hashPW);
		return agentRepository.save(c);
	}
	@Override
	public Agent editAgent(Agent agent){
		return agentRepository.save(agent);
	}
	@Override
	public List<Agent> getAllAgents(){
		return agentRepository.findAll();
	}
	@Override
	public Agent getAgentbyId(long id_agent)
	{
		Agent agent =agentRepository.findAgentById(id_agent);
		return agent;
		
	}
	
	@Override
	public void deleteAgentByCin(String cin)
	{
		Agent agent=findAgentByCin(cin);
		agentRepository.delete(agent);
		
	}
	@Override
	public Agent findAgentByCin(String cin) {
		
		return agentRepository.findByCin(cin);
	}

	@Override
	public Agent saveAgent(Agent agent) {
		
		return agentRepository.save(agent);
	}
	@Override
	public Agent findAgentByUsername(String username) {
		// TODO Auto-generated method stub
		return agentRepository.findByUsername(username);
	}

}
