package com.meriame.metier;

import com.meriame.model.Agence;


public interface AgenceMetier {
	public Agence findAgenceById_agence(Long id_agence);
	public Agence saveAgence(Agence admin);
	
	public void deleteAgenceById_agence(Long id_agence);
}
