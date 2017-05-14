/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controller;

import com.esprit.dao.MaisonDao;
import com.esprit.entity.Maison;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author wiemhjiri
 */
public class ChartGraphiqueController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private BarChart<String, Integer> chart;

    @FXML
    private CategoryAxis xaxis;
  

    private ObservableList<String> names = FXCollections.observableArrayList();

    private ListData listData = new ListData();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     names = FXCollections
                .observableArrayList(listData.getPersons().stream()
                        .map(p -> p.getNom()).collect(Collectors.toList()));
   xaxis.setCategories(names);
    
   
     MaisonDao pdao=MaisonDao.getInstance();
     List<Maison> persons=pdao.displayAllList();
        
      List<String> distinctNames=listData.getPersons().stream()
                .map(p->p.getNom())
           .distinct()
            .collect(Collectors.toList());
     
      
      
       int[] nameCounter =new int[distinctNames.size()];       
        
       for (Maison p : persons) {
           String name = p.getNom();
             
        }

        XYChart.Series<String, Integer> series = new XYChart.Series<>();

        // Create a XYChart.Data object for each month. Add it to the series.
        
    
    
    
    
    
    

    }}
