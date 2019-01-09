package com.meriame.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Agent")
public class Agent extends User implements Serializable {
	
	@ManyToOne
	@JoinColumn(name="id_admin")
	private Admin admin;
	@ManyToOne
	@JoinColumn(name="id_agence")
	private Agence agence;
	
	@OneToMany(mappedBy="agent", fetch=FetchType.LAZY)
	private List<Client> clients;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Agent(String cin, String nom, String prenom, String adresse, String telephone, String email, String login,
			String password, Date datedenaissance, Admin admin, Agence agence) {
		super(cin, nom, prenom, adresse, telephone, email, login, password, datedenaissance);
		this.admin = admin;
		this.agence = agence;
	}

	public Agent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Agent(String cin, String nom, String prenom, String adresse, String telephone, String email, String login,
			String password, Date datedenaissance) {
		super(cin, nom, prenom, adresse, telephone, email, login, password, datedenaissance);
		// TODO Auto-generated constructor stub
	}
	
	
}
