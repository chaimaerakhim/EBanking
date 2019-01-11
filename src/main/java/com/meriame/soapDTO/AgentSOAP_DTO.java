package com.meriame.soapDTO;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="AgentSOAP_DTO")
public class AgentSOAP_DTO {
	
	private String nom;
	private String prenom;
	private String adresse;
	private String telephone;
	private String email;
	private String username;
	private String password;
	private Date datedenaissance;
	private String cin;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getDatedenaissance() {
		return datedenaissance;
	}
	public void setDatedenaissance(Date datedenaissance) {
		this.datedenaissance = datedenaissance;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public AgentSOAP_DTO(String nom, String prenom, String adresse, String telephone, String email, String username,
			String password, Date datedenaissance, String cin) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		this.username = username;
		this.password = password;
		this.datedenaissance = datedenaissance;
		this.cin = cin;
	}
	public AgentSOAP_DTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
