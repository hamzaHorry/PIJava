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
public class ListData {
    
     /**
     * The data as an observable list of Persons.
     */
    
    private ObservableList<Maison> persons=FXCollections.observableArrayList();
        private ObservableList<Hotel> hotels=FXCollections.observableArrayList();

    public ListData() {
        
        MaisonDao pdao=MaisonDao.getInstance();
        persons= pdao.displayAll();
       
        //persons= pdao.displayById(id);
        System.out.println(persons);
       
       
        //persons= pdao.displayById(id);
        System.out.println(persons);
       
    }
    
     
    
    public ObservableList<Maison> getPersons(){
        return persons;
    }
    
  
      
    
   

   
}
