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
public class Hotel {
    
    protected SimpleIntegerProperty id;
    private SimpleStringProperty nom;
    private SimpleStringProperty adresse;
    
    private SimpleIntegerProperty numberetoil;
    private SimpleIntegerProperty numberchambre;
    
    private SimpleStringProperty path;
    

    public Hotel() {
    }

    
    public Hotel(int id, String nom, String adresse, Integer numberetoil , Integer numberchambre, String path) {
        this.id = new SimpleIntegerProperty(id);
        this.nom = new SimpleStringProperty(nom);
        this.adresse = new SimpleStringProperty(adresse);
        this.numberetoil = new SimpleIntegerProperty(numberetoil);
   
        this.numberchambre = new SimpleIntegerProperty(numberchambre);
        this.path = new SimpleStringProperty(path);
        
        
    }

    public Hotel(String nom, String adresse,Integer numberetoil,Integer numberchambre, String path) {
        this.nom = new SimpleStringProperty(nom);
        this.adresse = new SimpleStringProperty(adresse);
        this.numberetoil = new SimpleIntegerProperty(numberetoil);
        
        this.numberchambre = new SimpleIntegerProperty(numberchambre);
         this.path = new SimpleStringProperty(path);
      
    }
    
    
      public Hotel(String nom, String prenom,Integer numberetoil) {
        this.nom = new SimpleStringProperty(nom);
        this.adresse = new SimpleStringProperty(prenom);
       this.numberetoil = new SimpleIntegerProperty(numberetoil);
      
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
    
  
    
    
    
    public Integer getNumberetoil() {
        return numberetoil.get();
    }

    public void setNumberetoil(Integer numberetoil) {
        this.numberetoil = new SimpleIntegerProperty(numberetoil);
    }
    
       
    
       public Integer getNumberchambre() {
        return numberchambre.get();
    }

    public void setNumberchambre(Integer numberchambre) {
        this.numberchambre = new SimpleIntegerProperty(numberchambre);
    }
    
    
    
     public SimpleIntegerProperty getNumberetoilProperty(){
        return numberetoil;
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
        return "Hotel{" + "id=" + id.get() + ", nom=" + nom.get() + ", adresse=" + adresse.get() +", prix=" + numberetoil.get() +", numberchambre=" + numberchambre.get() + '}';
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
        final Hotel other = (Hotel) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
