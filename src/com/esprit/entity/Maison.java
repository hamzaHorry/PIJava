/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.entity;

import java.util.Objects;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author sindamtar
 */
public class Maison {
    
    protected SimpleIntegerProperty id;
    private SimpleStringProperty nom;
    private SimpleStringProperty adresse;
    private SimpleIntegerProperty prix;
    private SimpleIntegerProperty jourprix;
    private SimpleIntegerProperty numberchambre;
    private SimpleStringProperty path;
    

    public Maison() {
    }

    
    public Maison(int id, String nom, String adresse, Integer prix ,Integer jourprix, Integer numberchambre, String path) {
        this.id = new SimpleIntegerProperty(id);
        this.nom = new SimpleStringProperty(nom);
        this.adresse = new SimpleStringProperty(adresse);
        this.prix = new SimpleIntegerProperty(prix);
        this.jourprix = new SimpleIntegerProperty(jourprix);
        this.numberchambre = new SimpleIntegerProperty(numberchambre);
        this.path = new SimpleStringProperty(path);
        
        
    }

    public Maison(String nom, String adresse,Integer prix, Integer jourprix,Integer numberchambre, String path) {
        this.nom = new SimpleStringProperty(nom);
        this.adresse = new SimpleStringProperty(adresse);
        this.prix = new SimpleIntegerProperty(prix);
        this.jourprix = new SimpleIntegerProperty(jourprix);
        this.numberchambre = new SimpleIntegerProperty(numberchambre);
         this.path = new SimpleStringProperty(path);
      
    }
    
    
      public Maison(String nom, String prenom,Integer prix) {
        this.nom = new SimpleStringProperty(nom);
        this.adresse = new SimpleStringProperty(prenom);
       this.prix = new SimpleIntegerProperty(prix);
      
    }
    
    
    
    
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id = new SimpleIntegerProperty(id);
    }

    public String getNom() {
        return nom.get();
    }

    public void setNom(String nom) {
        this.nom = new SimpleStringProperty(nom);
    }
    
    
     public String getPath() {
        return path.get();
    }

    public void setPath(String path) {
        this.path = new SimpleStringProperty(path);
    }
    
    
    
    
    
    

      public String getAdresse() {
        return adresse.get();
    }
    public void setAdresse(String adresse) {
        this.adresse = new SimpleStringProperty(adresse);
    }
    
  
    
    
    
    public Integer getPrix() {
        return prix.get();
    }

    public void setPrix(Integer prix) {
        this.prix = new SimpleIntegerProperty(prix);
    }
    
     public Integer getJourprix() {
        return jourprix.get();
    }

    public void setJourprix(Integer jourprix) {
        this.jourprix = new SimpleIntegerProperty(jourprix);
    }
    
    
       public Integer getNumberchambre() {
        return numberchambre.get();
    }

    public void setNumberchambre(Integer numberchambre) {
        this.numberchambre = new SimpleIntegerProperty(numberchambre);
    }
    
    
    
     public SimpleIntegerProperty getPrixProperty(){
        return prix;
    }
     
     public SimpleIntegerProperty getJourprixProperty(){
        return jourprix;
    }
    public SimpleIntegerProperty getNumberchambreProperty(){
        return numberchambre;
    }
    
    
    
    public SimpleStringProperty getNomProperty(){
        return nom;
    }
    public SimpleStringProperty getAdresseProperty(){
        return adresse;
    }
    


    @Override
    public String toString() {
        return "Maison{" + "id=" + id.get() + ", nom=" + nom.get() + ", adresse=" + adresse.get() +", prix=" + prix.get() +", jourprix=" + jourprix.get() +", numberchambre=" + numberchambre.get() + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Maison other = (Maison) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
