package com.meriame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meriame.metier.ClientMetier;
import com.meriame.model.Client;

@RestController
public class ClientController {
	
	@Autowired
	private ClientMetier clientMetier;

	@RequestMapping(value="/clients", method=RequestMethod.POST)
	public Client SaveClient(@RequestBody Client c) {
		return clientMetier.SaveClient(c);
	}

	@RequestMapping(value="/clients", method=RequestMethod.GET)
	public List<Client> ListClent() {
		return clientMetier.ListClent();
	}
	
	
	

}
