package com.meriame.soapService;

import java.util.List;

import javax.jws.WebService;

import com.meriame.soapDTO.AgentSOAP_DTO;
import com.meriame.soapDTO.ClientSOAP_DTO;
import com.meriame.soapDTO.CompteSOAP_DTO;

@WebService(name = "Agent", serviceName = "AgentService")
public interface AgentService {

	public boolean agentLogin(String username, String password);
	//******Client********
	public ClientSOAP_DTO addClient(ClientSOAP_DTO c,String usernameAgent);
	public ClientSOAP_DTO editClient(ClientSOAP_DTO c, String usernameAgent);
	public boolean deleteClient(String username);
	public List<ClientSOAP_DTO> getClients(String usernameAgent);
	//******Compte*******
	public boolean addCompte(CompteSOAP_DTO compte, String cinClient);
	public boolean editCompte(CompteSOAP_DTO compte);
	public boolean deleteCompte(Long id);
	public List<CompteSOAP_DTO> getCompteClient(String cin);
	public boolean activateCompte(Long id);
	//******Agent********
	public AgentSOAP_DTO getProfilAgent(String username);
	public boolean updateAgent(AgentSOAP_DTO agent, String username);
	
	
}
