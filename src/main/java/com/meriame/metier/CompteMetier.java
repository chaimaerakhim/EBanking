package com.meriame.metier;

import java.util.List;

import com.meriame.model.Compte;

public interface CompteMetier {
	
	public List<Compte> getComptesByClientId(Long id);
	public Compte saveCompte(Compte compte);
	public Compte getCompteById(Long id);
	public void deleteCompte(Compte compte);

}
