/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package host.and.Guest.entities;

import java.sql.Date;

/**
 *
 * @author esprit
 */
public class experiences {
    private int id ;
    private String titre ;
    private Date dateDebut;
    private Date dateFin;
    private int visibilite ;
    private int score;
    private int id_hotel; 
    private String image_name ;
    private Double rating; 

    public experiences()
    {}

    public experiences( int id,String titre,Date dateDebut,Date dateFin,int id_hotel,Double rating) {
        this.id=id;      
        this.titre=titre;
        this.dateDebut=dateDebut;
        this.dateFin=dateFin;
        this.id_hotel=id_hotel;
        this.rating=rating;
        
      
        
    }

   
    public experiences( String titre,Date dateDebut,Date dateFin,int id_hotel,String image_name) {
        this.titre=titre;
        this.dateDebut=dateDebut;
        this.dateFin=dateFin;
        this.id_hotel=id_hotel;
        this.image_name=image_name;
      
        
    }
     public experiences( int id,String titre,Date dateDebut,Date dateFin,int id_hotel,String image_name,Double rating) {
        this.titre=titre;
        this.dateDebut=dateDebut;
        this.dateFin=dateFin;
        this.id=id;
        this.id_hotel=id_hotel;
        this.image_name=image_name;
         this.rating=rating;

      
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    

    public int getVisibilite() {
        return visibilite;
    }

    public void setVisibilite(int visibilite) {
        this.visibilite = visibilite;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
    
    
    
    
    
    
    
    

    @Override
    public String toString() {
        return "experiences{" + "id=" + id + ", titre=" + titre + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", visibilite=" + visibilite + ", score=" + score + '}';
    }
    

   

   
    
    
    
    
    
    
}
