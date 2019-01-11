package com.meriame.soapService;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meriame.metier.AgentMetier;
import com.meriame.metier.ClientMetier;
import com.meriame.metier.CompteMetier;
import com.meriame.model.Agent;
import com.meriame.model.Client;
import com.meriame.model.Compte;
import com.meriame.soapDTO.AgentSOAP_DTO;
import com.meriame.soapDTO.ClientSOAP_DTO;
import com.meriame.soapDTO.CompteSOAP_DTO;

@Service
public class AgentServiceImpl implements AgentService {

	@Autowired
	private CompteMetier compteMetier;
	@Autowired
	private ClientMetier clientMetier;
	@Autowired
	private AgentMetier agentMetier;
	
	@Override
	public boolean agentLogin(String username, String password) {
		 
		Agent agent=agentMetier.findAgentByUsername(username);
		if(agent.getUsername().equals(password)) return true;
		
		return false;
	}
	
	//*******************************Client********************************

	@Override
	public ClientSOAP_DTO addClient(ClientSOAP_DTO c, String usernameAgent) {
		Client client=clientMetier.findClientByUsername(c.getUsername());
		ClientSOAP_DTO clientdto=null;
		if(client==null) {
			Agent agent=agentMetier.findAgentByUsername(usernameAgent);
			List<Compte> compts=new Vector<>();
			client=new Client(c.getCin(), c.getNom(), c.getPrenom(), c.getAdresse(), c.getTelephone(), c.getEmail(), c.getUsername(), c.getPassword(), c.getDatedenaissance(), agent, agent.getAgence(), new Date(), compts);
			clientMetier.SaveClient(client);
			clientdto=c;
		}
		return clientdto;
	}

	@Override
	public ClientSOAP_DTO editClient(ClientSOAP_DTO c,  String usernameAgent) {
		Client client=clientMetier.findClientByUsername(c.getUsername());
		ClientSOAP_DTO clientdto=null;
		if(client!=null) {
			Agent agent=agentMetier.findAgentByUsername(usernameAgent);
			List<Compte> compts=new Vector<>();
			client=new Client(c.getCin(), c.getNom(), c.getPrenom(), c.getAdresse(), c.getTelephone(), c.getEmail(), c.getUsername(), c.getPassword(), c.getDatedenaissance(), agent, agent.getAgence(), new Date(), compts);
			clientMetier.SaveClient(client);
			clientdto=c;
		}
		return clientdto;
	}

	@Override
	public boolean deleteClient(String cin) {
		Client client=clientMetier.findClientByCin(cin);
		if(client!=null) {
			clientMetier.deleteClientByCin(cin);
			return true;
		}
		return false;
	}

	@Override
	public List<ClientSOAP_DTO> getClients(String usernameAgent) {
		Agent agent=agentMetier.findAgentByUsername(usernameAgent);
		List<Client> clients=agent.getClients();
		List<ClientSOAP_DTO> clientsDto=new Vector<>();
		if(clients!=null) {
			clients.forEach(c->{
				clientsDto.add(new ClientSOAP_DTO(c.getNom(), c.getPrenom(), c.getAdresse(), c.getTelephone(), c.getEmail(), c.getUsername(), c.getPassword(), c.getDatedenaissance(), c.getCin()));
			});
			
		}
		
		return clientsDto;
	}

	//*******************************Compte********************************

	@Override
	public boolean addCompte(CompteSOAP_DTO compte, String cinClient) {
		
		Client client=clientMetier.findClientByCin(cinClient);
		if(client!=null) {
			
		}
		
		return false;
	}

	@Override
	public boolean editCompte(CompteSOAP_DTO compte) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteCompte(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<CompteSOAP_DTO> getCompteClient(String username) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//*******************************Profile********************************

	@Override
	public AgentSOAP_DTO getProfilAgent(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateAgent(AgentSOAP_DTO agent, String username) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
