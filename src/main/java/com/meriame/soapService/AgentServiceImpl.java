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
		System.out.println(username+" "+password);
		if(agent!=null) {
			if(agent.getPassword().equals(password)) return true;
			System.out.println("bad password"+agent.getPassword());
		}
		System.out.println("Agent not found");
		
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
			Compte cmt=new Compte(compte.getSolde(), "active", client);
			if(compteMetier.saveCompte(cmt)!=null) {
				return true;
			}
						
		}
		
		return false;
	}

	@Override
	public boolean editCompte(CompteSOAP_DTO compte) {
		Compte cmpt=compteMetier.getCompteById(compte.getIdCompte());
		if(cmpt!=null) {
			cmpt.setSolde(compte.getSolde());
			cmpt.setEtat(compte.getEtat());
			compteMetier.saveCompte(cmpt);
			
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteCompte(Long id) {
		Compte cmpt=compteMetier.getCompteById(id);
		if(cmpt!=null) {
			compteMetier.deleteCompte(cmpt);
		}
		return false;
	}

	@Override
	public List<CompteSOAP_DTO> getCompteClient(String cin) {
		Client client=clientMetier.findClientByCin(cin);
		if(client!=null) {
			if(client.getComptes()!=null) {
				List<CompteSOAP_DTO> listCompte=new Vector<>();
				client.getComptes().forEach(c->{
					listCompte.add(new CompteSOAP_DTO(c.getIdCompte(), c.getSolde(), c.getEtat()));
				});
			}
		}
		return null;
	}
	
	
	
	//*******************************Profile********************************

	@Override
	public AgentSOAP_DTO getProfilAgent(String username) {
		Agent agent=agentMetier.findAgentByUsername(username);
		AgentSOAP_DTO ag=null;
		if(agent!=null) {
			ag=new AgentSOAP_DTO(agent.getNom(), agent.getPrenom(), agent.getAdresse(), agent.getAdresse(), agent.getEmail(), username, agent.getPassword(), agent.getDatedenaissance(), agent.getCin());
		}
		return ag;
	}

	@Override
	public boolean updateAgent(AgentSOAP_DTO agent, String username) {
		Agent ag=agentMetier.findAgentByUsername(username);
		if(ag!=null) {
			ag.setAdresse(agent.getAdresse());
			ag.setCin(agent.getCin());
			ag.setDatedenaissance(agent.getDatedenaissance());
			ag.setEmail(agent.getEmail());
			ag.setNom(agent.getNom());
			ag.setPassword(agent.getPassword());
			ag.setPrenom(agent.getPrenom());
			ag.setTelephone(agent.getTelephone());
			if(agentMetier.saveAgent(ag)!=null)
				return true;
		}
		return false;
	}

	
}
