/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package host.and.Guest.entities;

import java.util.Objects;

/**
 *
 * @author bali
 */
public class Hotel1 {
    
    private int idHotel;
    private User idUser;
    private String nom;
    private String adresse;
    private int nbrEtoile;
    private int nbrChambre;
    private int visibilite;
    private int aime;

    public Hotel1() {
    }

    public Hotel1(int idHotel) {
        this.idHotel = idHotel;
    }
    

    public Hotel1(int idHotel, User idUser, String nom, String adresse, int nbrEtoile, int nbrChambre, int visibilite, int aime) {
        this.idHotel = idHotel;
        this.idUser = idUser;
        this.nom = nom;
        this.adresse = adresse;
        this.nbrEtoile = nbrEtoile;
        this.nbrChambre = nbrChambre;
        this.visibilite = visibilite;
        this.aime = aime;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNbrEtoile() {
        return nbrEtoile;
    }

    public void setNbrEtoile(int nbrEtoile) {
        this.nbrEtoile = nbrEtoile;
    }

    public int getNbrChambre() {
        return nbrChambre;
    }

    public void setNbrChambre(int nbrChambre) {
        this.nbrChambre = nbrChambre;
    }

    public int getVisibilite() {
        return visibilite;
    }

    public void setVisibilite(int visibilite) {
        this.visibilite = visibilite;
    }

    public int getAime() {
        return aime;
    }

    public void setAime(int aime) {
        this.aime = aime;
    }

    @Override
    public String toString() {
        return "Hotel " + nom ;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.idHotel;
        hash = 53 * hash + Objects.hashCode(this.idUser);
        hash = 53 * hash + Objects.hashCode(this.nom);
        hash = 53 * hash + Objects.hashCode(this.adresse);
        hash = 53 * hash + this.nbrEtoile;
        hash = 53 * hash + this.nbrChambre;
        hash = 53 * hash + this.visibilite;
        hash = 53 * hash + this.aime;
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
        final Hotel1 other = (Hotel1) obj;
        if (this.idHotel != other.idHotel) {
            return false;
        }
        if (!Objects.equals(this.idUser, other.idUser)) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.adresse, other.adresse)) {
            return false;
        }
        if (this.nbrEtoile != other.nbrEtoile) {
            return false;
        }
        if (this.nbrChambre != other.nbrChambre) {
            return false;
        }
        if (this.visibilite != other.visibilite) {
            return false;
        }
        if (this.aime != other.aime) {
            return false;
        }
        return true;
    }
    
    
    }
    
