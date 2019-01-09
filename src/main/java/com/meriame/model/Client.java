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
@XmlRootElement(name="Client")
public class Client extends User implements Serializable {
	
	@ManyToOne
	@JoinColumn(name="id_agent")
	private Agent agent;
	@ManyToOne
	@JoinColumn(name="id_agence")
	private Agence agence;
	private Date adhesionDate;
	@OneToMany(mappedBy="client", fetch=FetchType.EAGER )
	private List<Compte> comptes;

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(String cin, String nom, String prenom, String adresse, String telephone, String email, String login,
			String password, Date datedenaissance, Agent agent, Agence agence, Date adhesionDate,
			List<Compte> comptes) {
		super(cin, nom, prenom, adresse, telephone, email, login, password, datedenaissance);
		this.agent = agent;
		this.agence = agence;
		this.adhesionDate = adhesionDate;
		this.comptes = comptes;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Agence getAgence() {
		return agence;
	}

	public void setAgence(Agence agence) {
		this.agence = agence;
	}

	public Date getAdhesionDate() {
		return adhesionDate;
	}

	public void setAdhesionDate(Date adhesionDate) {
		this.adhesionDate = adhesionDate;
	}

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}
	
	public Client(String username, String password) {
		super(username, password);
	}

}
