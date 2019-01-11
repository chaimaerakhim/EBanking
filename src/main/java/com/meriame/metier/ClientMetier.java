package com.meriame.metier;

import java.util.List;

import com.meriame.model.Client;

public interface ClientMetier {

	public Client SaveClient(Client c);
	public Client editClient(Client client);
	public List<Client> getAllClients();
	public Client getClientbyId(long id_client);
	public Client findClientByUsername(String username);
	public Client findClientByCin(String cin);
	public void deleteClientByCin(String cin);
}
