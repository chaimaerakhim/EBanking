package com.meriame.soapService;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meriame.metier.AdminMetier;
import com.meriame.metier.AgenceMetier;
import com.meriame.metier.AgentMetier;
import com.meriame.model.Admin;
import com.meriame.model.Agence;
import com.meriame.model.Agent;
import com.meriame.soapDTO.AgenceSOAP_DTO;
import com.meriame.soapDTO.AgentSOAP_DTO;




@Service
public class AdminServiceImpl implements AdminService  {
	@Autowired
	private AgenceMetier  agenceMetier;
	@Autowired
	private AdminMetier adminMetier;
	@Autowired
	private AgentMetier agentMetier;
	

	@Override
	public boolean AdminLogin(String username, String password) {
		
		Admin admin=adminMetier.findAdminByUsername(username);
		if(admin.getPassword().equals(password)) return true;
		
		return false;
	}

	@Override
	public AgentSOAP_DTO addAgent(AgentSOAP_DTO c, String usernameAdmin) {
		Agent agent=agentMetier.findAgentByUsername(c.getUsername());
		AgentSOAP_DTO agentdto=null;
		if(agent==null) {
			Admin admin=adminMetier.findAdminByUsername(usernameAdmin);
			agent=new Agent(c.getCin(), c.getNom(), c.getPrenom(), c.getAdresse(), c.getTelephone(), c.getEmail(), c.getUsername(), c.getPassword(), c.getDatedenaissance(), admin, agent.getAgence());
			agentMetier.saveAgent(agent);
			agentdto=c;
			
		}
		return agentdto;
	}

	@Override
	public AgentSOAP_DTO editAgent(AgentSOAP_DTO c, String usernameAdmin) {
		Agent agent=agentMetier.findAgentByUsername(c.getUsername());
		AgentSOAP_DTO agentdto=null;
		if(agent!=null) {
			Admin admin=adminMetier.findAdminByUsername(usernameAdmin);
			agent=new Agent(c.getCin(), c.getNom(), c.getPrenom(), c.getAdresse(), c.getTelephone(), c.getEmail(), c.getUsername(), c.getPassword(), c.getDatedenaissance(), admin, agent.getAgence());
			agentMetier.saveAgent(agent);
			agentdto=c;
			
		}
		return agentdto;
	}

	@Override
	public boolean deleteAgent(String cin) {
		Agent agent=agentMetier.findAgentByCin(cin);
		if(agent!=null) {
			agentMetier.deleteAgentByCin(cin);
			return true;
		}
		return false;
	}

	@Override
	public List<AgentSOAP_DTO> getAgent(String usernameAdmin) {
		// TODO Auto-generated method stub
		Admin admin=adminMetier.findAdminByUsername(usernameAdmin);
		List<Agent> agents=admin.getAgents();
		List<AgentSOAP_DTO> agentsDto=new Vector<>();
		if(agents!=null) {
			agents.forEach(c->{
				agentsDto.add(new AgentSOAP_DTO(c.getNom(), c.getPrenom(), c.getAdresse(), c.getTelephone(), c.getEmail(), c.getUsername(), c.getPassword(), c.getDatedenaissance(), c.getCin()));
			});
			
		}
		
		return agentsDto ;
	}

	@Override
	public AgenceSOAP_DTO addAgence(AgenceSOAP_DTO agc, String usernameAdmin) {
		Agence agence=agenceMetier.findAgenceById_agence(agc.getId());
		AgenceSOAP_DTO agencedto=null;
		if(agence==null) {
			Admin admin=adminMetier.findAdminByUsername(usernameAdmin);
			agence=new Agence(agc.getAdresse(), agc.getDatedouverture(), admin);
			agenceMetier.saveAgence(agence);
			agencedto=agc;
		
		}
		return agencedto;
	}

	@Override
	public AgenceSOAP_DTO editAgence(AgenceSOAP_DTO agc, String usernameAdmin) {
		Agence agence=agenceMetier.findAgenceById_agence(agc.getId());
		AgenceSOAP_DTO agencedto=null;
		if(agence!=null) {
			Admin admin=adminMetier.findAdminByUsername(usernameAdmin);
			agence=new Agence(agc.getAdresse(), agc.getDatedouverture(), admin);
			agenceMetier.saveAgence(agence);
			agencedto=agc;
		
		}
		return agencedto;
	}

	@Override
	public boolean deleteAgence(Long id) {
		Agence agence=agenceMetier.findAgenceById_agence(id);
		if(agence!=null) {
			agenceMetier.deleteAgenceById_agence(id);
			return true;
		}
		return false;
	}

	@Override
	public List<AgenceSOAP_DTO> getAgence(String usernameAdmin) {
		// TODO Auto-generated method stub
		Admin admin=adminMetier.findAdminByUsername(usernameAdmin);
		List<Agence> agences=admin.getAgences();
		List<AgenceSOAP_DTO> agencesDto=new Vector<>();
		if(agences!=null) {
			agences.forEach(agc->{
				agencesDto.add(new AgenceSOAP_DTO(agc.getId(), agc.getAdresse(),agc.getDatedouverture()));
			});
			
		}
		
		return agencesDto ;
	}

}
