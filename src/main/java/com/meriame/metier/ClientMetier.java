package com.meriame.metier;

import java.util.List;

import com.meriame.model.Client;

public interface ClientMetier {

	public Client SaveClient(Client c);
	public List<Client> ListClent();
}
