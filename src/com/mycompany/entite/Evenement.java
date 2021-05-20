package com.mycompany.entite;

public class Evenement {
	private int id ; 
	private String nom_evenement ; 
	private String Date ; 
	private String responsable ; 
	private String description ; 
	private int id_user ; 
	private String nbr_place ;
	public Evenement(String nom_evenement, String date, String responsable, String description, String nbr_place) {
		super();
		this.nom_evenement = nom_evenement;
		Date = date;
		this.responsable = responsable;
		this.description = description;
		this.nbr_place = nbr_place;
	}
	

	
	public Evenement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom_evenement() {
		return nom_evenement;
	}
	public void setNom_evenement(String nom_evenement) {
		this.nom_evenement = nom_evenement;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getNbr_place() {
		return nbr_place;
	}
	public void setNbr_place(String nbr_place) {
		this.nbr_place = nbr_place;
	} 
	
	
	
	

}
