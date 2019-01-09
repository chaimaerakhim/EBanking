package com.meriame.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="AdminDTO")
public class AdminDTO {
	
	private String cin;
	private String nom;
	private String prenom;
	private String adresse;
	private String telephone;
	private String email;
	private String login;
	private String password;
	private Date datedenaissance;
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
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
	public AdminDTO(String cin, String nom, String prenom, String adresse, String telephone, String email, String login,
			String password, Date datedenaissance) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		this.login = login;
		this.password = password;
		this.datedenaissance = datedenaissance;
	}
	public AdminDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
