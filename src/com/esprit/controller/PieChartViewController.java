/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controller;
import com.esprit.dao.HotelDao;
import javafx.event.ActionEvent;
import com.esprit.dao.MaisonDao;
import com.esprit.entity.Hotel;
import com.esprit.entity.Maison;
import java.awt.Rectangle;
import static java.awt.SystemColor.window;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.shape.Circle;
import javafx.print.PrinterJob;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javax.jnlp.PrintService;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;

/**
 * FXML Controller class
 *
 * @author sindamtar
 */
public class PieChartViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private PieChart pieChart;
    ObservableList<Data> list=FXCollections.
            observableArrayList();
  @FXML
    private Button retour;
  @FXML 
  Label var;

  
 @FXML
    private Text text;
   
 @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        

        
        
        
        
        
        
    // Code de l'impression ici.             

        MaisonDao pdao=MaisonDao.getInstance();
        List<Maison> pers=pdao.displayAllList();
        HotelDao dao=HotelDao.getInstance();
        List<Hotel> hls=dao.displayAllList();
        for (Maison p:pers) {
            list.addAll(new Data(p.getNom(), 1.0));
        }
        
        for (Hotel a:hls) {
            list.addAll(new Data(a.getNom(), 1.0));
            
        }
        pieChart.setAnimated(true);
        pieChart.setData(list);

     
    retour.setOnAction(event -> {

            try {
                Parent page3 = FXMLLoader.load(getClass().getResource("/com/esprit/view/Accueil.fxml"));
                Scene scene = new Scene(page3);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); 
    
 
    


       
     //    System.out.println(cs.displayAllV());
            
         
           // dPdatedebut.setValue(df.toLocalDate());
        
       
        
        
        
      
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    }
    
    
    
    
    
    
    
    
           Maison c= new Maison();
    MaisonDao cs=new MaisonDao();
    AfficherMaisonController l;  
    


 @FXML
    private void exit(MouseEvent event) {
          System.exit(0);
        
    }
}

    
    
    
