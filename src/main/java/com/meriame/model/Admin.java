package com.meriame.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.meriame.dto.AdminDTO;


@Entity
public class Admin extends User implements Serializable {
	
	@OneToMany(mappedBy="admin", fetch=FetchType.LAZY)
	@JsonManagedReference(value="adminAgent")
	private List<Agent> agents;
	@OneToMany(mappedBy="admin", fetch=FetchType.LAZY)
	@JsonManagedReference(value="adminAgence")
	private List<Agence> agences;
	public List<Agent> getAgents() {
		return agents;
	}
	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}
	public List<Agence> getAgences() {
		return agences;
	}
	public void setAgences(List<Agence> agences) {
		this.agences = agences;
	}
	public Admin() {
		super();
		agents=new Vector<Agent>();
		agences=new Vector<Agence>();
	}
	public Admin(String cin, String nom, String prenom, String adresse, String telephone, String email, String username,
			String password, Date datedenaissance) {
		super(cin, nom, prenom, adresse, telephone, email, username, password, datedenaissance);
		agents=new Vector<Agent>();
		agences=new Vector<Agence>();
	}
	
	public Admin(AdminDTO dto) {
		super(dto.getCin(), dto.getNom(), dto.getPrenom(), dto.getAdresse(), dto.getTelephone(), dto.getEmail(), dto.getLogin(), dto.getPassword(), dto.getDatedenaissance());
	}
	

	

	
	
	
	

}
