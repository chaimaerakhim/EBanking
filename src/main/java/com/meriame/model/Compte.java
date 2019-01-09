package com.meriame.model;

import java.io.Serializable;
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

@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Compte")
public class Compte implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCompte;
	private double solde;
	private String etat;
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;
	@OneToMany(mappedBy="cmptSource", fetch=FetchType.LAZY)
	private List<Versement> versements;
	public Long getIdCompte() {
		return idCompte;
	}
	public void setIdCompte(Long idCompte) {
		this.idCompte = idCompte;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	public List<Versement> getVersements() {
		return versements;
	}
	public void setVersements(List<Versement> versements) {
		this.versements = versements;
	}
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Compte(double solde, String etat, Client client) {
		super();
		this.solde = solde;
		this.etat = etat;
		this.client = client;
	}
	
	
	
	
}
