package com.meriame.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Agence implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String adresse;
	private Date datedouverture;
	
	@ManyToOne
	@JoinColumn(name="id_admin")
	@JsonBackReference(value="adminAgence")
	private Admin admin;
	
	@OneToMany(mappedBy="agence", fetch=FetchType.LAZY)
	@JsonManagedReference(value="agentsAgence")
	private List<Agent> agents;
	
	@OneToMany(mappedBy="agence", fetch=FetchType.LAZY)
	@JsonManagedReference(value="clientsAgence")
	private List<Client> clients;

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Date getDatedouverture() {
		return datedouverture;
	}

	public void setDatedouverture(Date datedouverture) {
		this.datedouverture = datedouverture;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public List<Agent> getAgents() {
		return agents;
	}

	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public Agence(String adresse, Date datedouverture, Admin admin) {
		super();
		this.adresse = adresse;
		this.datedouverture = datedouverture;
		this.admin = admin;
	}

	public Agence() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
