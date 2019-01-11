package com.meriame.controller;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meriame.dao.CompteRepository;
import com.meriame.dto.VersementDTO;
import com.meriame.exception.BankTransactionException;
import com.meriame.metier.ClientMetier;
import com.meriame.metier.CompteMetier;
import com.meriame.metier.VersementMetier;
import com.meriame.model.Client;
import com.meriame.model.Compte;
import com.meriame.model.Versement;

@RestController
public class ClientController {
	public static final String datePattern = "dd/MM/yyyy HH:mm:ss";
	
	@Autowired
	private CompteMetier compteMetier;
	@Autowired
	private ClientMetier clientmetier;
	@Autowired
	private VersementMetier versementmetier;
	
	@RequestMapping(value = "/clients/{idClient}/mycomptes")
	public List<Compte> myComptes(@PathVariable long idClient){
		return compteMetier.getComptesByClientId(idClient);
	}
	@RequestMapping(value = "/clients/{idClient}/profil")
	public Client profil(@PathVariable long idClient){
		return clientmetier.getClientbyId(idClient);
	}
	
	@RequestMapping(value = "/clients/{idClient}/mes-virements")
	public List<Versement> mesVirements(@PathVariable long idClient){
		List<Compte> comptes = compteMetier.getComptesByClientId(idClient);
		List<Versement> virements = new ArrayList<>();
		
		if(comptes!=null) {
			comptes.forEach(c -> {
				if(c.getVersementsour()!=null)virements.addAll(c.getVersementsour());
				if(c.getVersementdest()!=null)virements.addAll(c.getVersementdest());
				
			});
		}
		
		return virements;
	}
	
	@RequestMapping(value = "/clients/verser", method = RequestMethod.POST)
	public String virement(@RequestBody  VersementDTO virement) throws ParseException {
		
		try {
			versementmetier.verse(virement);
			
		} catch (BankTransactionException e) {
			return "Error: " + e.getMessage();
		}
		
		return "transaction reussite ";
		
	}
	
	
	
	

}
