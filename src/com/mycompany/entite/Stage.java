package com.mycompany.entite;


import java.util.Date;

public class Stage {
	private int id ; 
    private String email_societe ; 
    private String pays ;
    private String date_debut ;
    private String date_fin;
    


	private String type_stage ;
    
    
	public Stage() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Stage(String email_societe, String pays, String date_debut, String date_fin, String type_stage) {
		super();
		this.email_societe = email_societe;
		this.pays = pays;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.type_stage = type_stage;
	}
	


	public Stage(int id, String email_societe, String pays, String date_debut, String date_fin, String type_stage) {
		super();
		this.id = id;
		this.email_societe = email_societe;
		this.pays = pays;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.type_stage = type_stage;
	}


	public String getEmail_societe() {
		return email_societe;
	}


	public void setEmail_societe(String email_societe) {
		this.email_societe = email_societe;
	}


	public String getPays() {
		return pays;
	}


	public void setPays(String pays) {
		this.pays = pays;
	}


	public String getDate_debut() {
		return date_debut;
	}


	public void setDate_debut(String date_debut) {
		this.date_debut = date_debut;
	}


	public String getDate_fin() {
		return date_fin;
	}


	public void setDate_fin(String date_fin) {
		this.date_fin = date_fin;
	}


	public String getType_stage() {
		return type_stage;
	}


	public void setType_stage(String type_stage) {
		this.type_stage = type_stage;
	}
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
    
}