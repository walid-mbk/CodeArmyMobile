/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entite;

/**
 *
 * @author walid
 */
public class Matiere {
    private int id_matiere , cofficient , volume_h ;
    private String nom_matiere ;

    public Matiere() {
    }

    public Matiere(int id_matiere, int cofficient, int volume_h, String nom_matiere) {
        this.id_matiere = id_matiere;
        this.cofficient = cofficient;
        this.volume_h = volume_h;
        this.nom_matiere = nom_matiere;
    }

    public int getId_matiere() {
        return id_matiere;
    }

    public void setId_matiere(int id_matiere) {
        this.id_matiere = id_matiere;
    }

    public int getCofficient() {
        return cofficient;
    }

    public void setCofficient(int cofficient) {
        this.cofficient = cofficient;
    }

    public int getVolume_h() {
        return volume_h;
    }

    public void setVolume_h(int volume_h) {
        this.volume_h = volume_h;
    }

    public String getNom_matiere() {
        return nom_matiere;
    }

    public void setNom_matiere(String nom_matiere) {
        this.nom_matiere = nom_matiere;
    }

    @Override
    public String toString() {
        return  nom_matiere ;
    }
    
    
    
}
