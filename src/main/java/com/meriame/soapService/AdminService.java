package com.meriame.soapService;

import java.util.List;

import javax.jws.WebService;

import com.meriame.soapDTO.AgenceSOAP_DTO;
import com.meriame.soapDTO.AgentSOAP_DTO;

@WebService(name = "Admin", serviceName = "AdminService")
public interface AdminService {
	
	public boolean AdminLogin(String username, String password);
	//******Agent********
	public AgentSOAP_DTO addAgent(AgentSOAP_DTO c,String usernameAdmin);
	public AgentSOAP_DTO editAgent(AgentSOAP_DTO c, String usernameAdmin);
	public boolean deleteAgent(String cin);
	public List<AgentSOAP_DTO> getAgent(String usernameAdmin);
	//******Agence*******
	public AgenceSOAP_DTO addAgence(AgenceSOAP_DTO agc, String usernameAdmin );
	public AgenceSOAP_DTO editAgence(AgenceSOAP_DTO agc, String usernameAdmin);
	public boolean deleteAgence(Long id);
	public List<AgenceSOAP_DTO> getAgence(String usernameAdmin);

}
