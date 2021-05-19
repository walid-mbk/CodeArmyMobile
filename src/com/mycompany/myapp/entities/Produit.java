/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

import javafx.scene.image.ImageView;

/**
 *
 * @author ASUS
 */
public class Produit {
    
      private int id;
    private String nom;
    private String reference;
    private float prix;
    private String image;
   private String description;
    private String  categorie_id;
     ImageView  phot;

    public Produit(String nom, float prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public Produit(int id, String nom, String reference, float prix, String image, String description) {
        this.id = id;
        this.nom = nom;
        this.reference = reference;
        this.prix = prix;
        this.image = image;
        this.description = description;
    }

    public Produit(int id, String nom, String reference, float prix, String description) {
        this.id = id;
        this.nom = nom;
        this.reference = reference;
        this.prix = prix;
        this.description = description;
    }

    public ImageView getPhot() {
        return phot;
    }

    public Produit(int id, String nom, float prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }

    public Produit(String nom, String reference, float prix, String description, String categorie_id) {
        this.nom = nom;
        this.reference = reference;
        this.prix = prix;
        this.description = description;
        this.categorie_id = categorie_id;
    }

    public void setPhot(ImageView phot) {
        this.phot = phot;
    }

    public Produit(String nom, String reference, float prix, String description) {
        this.nom = nom;
        this.reference = reference;
        this.prix = prix;
        this.description = description;
    }

    public Produit(String nom, String reference, float prix, String image, String description, String categorie_id, ImageView phot) {
        this.nom = nom;
        this.reference = reference;
        this.prix = prix;
        this.image = image;
        this.description = description;
        this.categorie_id = categorie_id;
        this.phot = phot;
    }

    public Produit(int id, String nom, String reference, float prix, String image, String description, String categorie_id, ImageView phot) {
        this.id = id;
        this.nom = nom;
        this.reference = reference;
        this.prix = prix;
        this.image = image;
        this.description = description;
        this.categorie_id = categorie_id;
        this.phot = phot;
    }

    public Produit() {
    }

    public Produit(String nom, String reference, float prix, String image, String description, String categorie_id) {
        this.nom = nom;
        this.reference = reference;
        this.prix = prix;
        this.image = image;
        this.description = description;
        this.categorie_id = categorie_id;
    }

    public Produit(String nom, String reference, String image, String description, String categorie_id) {
        this.nom = nom;
        this.reference = reference;
        this.image = image;
        this.description = description;
        this.categorie_id = categorie_id;
    }

    public Produit(int id, String nom, String reference, String image, String description, String categorie_id) {
        this.id = id;
        this.nom = nom;
        this.reference = reference;
        this.image = image;
        this.description = description;
        this.categorie_id = categorie_id;
    }

    public Produit(int id, String nom, String reference, float prix, String image, String description, String categorie_id) {
        this.id = id;
        this.nom = nom;
        this.reference = reference;
        this.prix = prix;
        this.image = image;
        this.description = description;
        this.categorie_id = categorie_id;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", nom=" + nom + ", reference=" + reference + ", prix=" + prix + ", image=" + image + ", description=" + description + ", categorie_id=" + categorie_id + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategorie_id() {
        return categorie_id;
    }

    public void setCategorie_id(String categorie_id) {
        this.categorie_id = categorie_id;
    }
    
}
