/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controller;

import com.esprit.dao.HotelDao;

import com.esprit.dao.MaisonDao;
import com.esprit.entity.Hotel;

import com.esprit.entity.Maison;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;



/**
 *
 * @author sindamtar
 */
public class ListDatah {
    
     /**
     * The data as an observable list of Persons.
     */
    
        private ObservableList<Hotel> hotels=FXCollections.observableArrayList();

   
     public ListDatah() {
        
        HotelDao pdao=HotelDao.getInstance();
        hotels= pdao.displayAll();
       
        //persons= pdao.displayById(id);
        System.out.println(hotels);
       
       
        //persons= pdao.displayById(id);
        System.out.println(hotels);
       
    }
    
    public ObservableList<Hotel> getHotels(){
        return hotels;
    }
}