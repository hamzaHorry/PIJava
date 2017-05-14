/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package host.and.Guest.entities;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author home
 */
public class hotel {
    private int id;
    private String name;
     private String adresse;
    
    private int numberetoil;
    private int numberchambre;
    
    private  String path;
    
   
    public hotel(){}
    public hotel(int id,String name){
        this.id=id;
        this.name=name;
    }
    public hotel(int id,String name,String adresse,int numberetoil,int numberchambre,String path){
        this.id=id;
        this.name=name;
        this.adresse=adresse;
        this.numberchambre=numberchambre;
        this.numberetoil=numberetoil;
        this.path=path;
        
    }

    
    
    
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setNumberetoil(int numberetoil) {
        this.numberetoil = numberetoil;
    }

    public void setNumberchambre(int numberchambre) {
        this.numberchambre = numberchambre;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getNumberetoil() {
        return numberetoil;
    }

    public int getNumberchambre() {
        return numberchambre;
    }

    public String getPath() {
        return path;
    }
    
    
    
    
    
    
    
    
    

    @Override
    public String toString() {
        return "hotel{" + "id=" + id + ", name=" + name + '}';
    }
    
    
    
}
