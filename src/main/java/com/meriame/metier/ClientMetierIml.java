package com.meriame.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.meriame.dao.ClientRepository;
import com.meriame.model.Client;

@Service
public class ClientMetierIml implements ClientMetier {

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private BCryptPasswordEncoder bcp;
	
	@Override
	public Client SaveClient(Client c) {
		String hashPW=bcp.encode(c.getPassword());
		c.setPassword(hashPW);
		return clientRepository.save(c);
	}
	@Override
	public Client editClient(Client client){
		return clientRepository.save(client);
	}
	@Override
	public List<Client> getAllClients(){
		return clientRepository.findAll();
	}
	@Override
	public Client getClientbyId(long id_client)
	{
		Client client =clientRepository.findById(id_client);
		return client;
		
	}
	
	@Override
	public void deleteClientbyId(long id_client)
	{
		Client client=getClientbyId(id_client);
		clientRepository.delete(client);
		
	}
	

}
