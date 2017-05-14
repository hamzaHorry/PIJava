/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pi.models;

import java.io.File;
import java.sql.Date;
import java.util.Objects;
import host.and.Guest.entities.User;

/**
 *
 * @author bali
 */
public class Event {

    private int id;
    private User idUser;
    private Hotel idHotel;
    private String nom;
    private int nbrTicket;
    private float prix;
    private Date dateEvent;
    private File image;
    private String imageName;

    public Event(int id, User idUser, Hotel idHotel, String nom, int nbrTicket, float prix, Date dateEvent, File image) {
        this.id = id;
        this.idUser = idUser;
        this.idHotel = idHotel;
        this.nom = nom;
        this.nbrTicket = nbrTicket;
        this.prix = prix;
        this.dateEvent = dateEvent;
        this.image = image;
    }

    public Event(int id, User idUser, Hotel idHotel, String nom, int nbrTicket, float prix, Date dateEvent) {
        this.id = id;
        this.idUser = idUser;
        this.idHotel = idHotel;
        this.nom = nom;
        this.nbrTicket = nbrTicket;
        this.prix = prix;
        this.dateEvent = dateEvent;
    }

    public Event(User idUser, Hotel idHotel, String nom, int nbrTicket, float prix, Date dateEvent) {
        this.idUser = idUser;
        this.idHotel = idHotel;
        this.nom = nom;
        this.nbrTicket = nbrTicket;
        this.prix = prix;
        this.dateEvent = dateEvent;
    }

    public Event(int id) {
        this.id = id;
    }

    public Event() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.id;
        hash = 61 * hash + Objects.hashCode(this.idUser);
        hash = 61 * hash + Objects.hashCode(this.idHotel);
        hash = 61 * hash + Objects.hashCode(this.nom);
        hash = 61 * hash + this.nbrTicket;
        hash = 61 * hash + Float.floatToIntBits(this.prix);
        hash = 61 * hash + Objects.hashCode(this.dateEvent);
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
        final Event other = (Event) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.idUser, other.idUser)) {
            return false;
        }
        if (!Objects.equals(this.idHotel, other.idHotel)) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (this.nbrTicket != other.nbrTicket) {
            return false;
        }
        if (Float.floatToIntBits(this.prix) != Float.floatToIntBits(other.prix)) {
            return false;
        }
        return Objects.equals(this.dateEvent, other.dateEvent);
    }

    @Override
    public String toString() {
        return "Event: \n " + "id=" + id + ", \n User=" + idUser.getUsername() + ", \n Hotel=" + idHotel + ", \n nom=" + nom + ", \n nbrTicket=" + nbrTicket + ", \n prix=" + prix + ", \n dateEvent=" + dateEvent + "\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getIdUser() {
        return idUser;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public Hotel getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Hotel idHotel) {
        this.idHotel = idHotel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbrTicket() {
        return nbrTicket;
    }

    public void setNbrTicket(int nbrTicket) {
        this.nbrTicket = nbrTicket;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Date getDateEvent() {
        return dateEvent;
    }

    public void setDateEvent(Date dateEvent) {
        this.dateEvent = dateEvent;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageName() {
        return imageName;
    }
}
