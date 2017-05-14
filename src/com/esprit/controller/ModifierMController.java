/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controller;








/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import static com.esprit.controller.ModifierMController.path;

import com.esprit.dao.MaisonDao;

import com.esprit.entity.Maison;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sindamtar
 */
public class ModifierMController implements Initializable {

   static File path =new File("");
    
    
    @FXML
    private Button btn_modifier;
    
    @FXML
    private TextField nomm;
    @FXML
    private TextField adressem;
 @FXML
    private TextField prixm;
    @FXML
    private TextField jourprixm;
    @FXML
    private TextField numbrechambrem;
    @FXML
   
    private ImageView imageViewm;
     @FXML
    private Button retour1;
    @FXML
    private Button show1;
    
    
     @FXML
    private TextField testm;
    
    
    
    
     
     
     
     
     
     
     
     
     
     
    
   
       
       
       @FXML
    void choisirPhotom() {
        
 FileChooser fc = new FileChooser();
        File sf = fc.showOpenDialog(null);
        System.out.println("bbbbb");
        if (sf != null) {
            System.out.println("aaaaa");
            fc.setTitle("Ajouter");
            fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Images", "*.jpg", "*.png", "*.jpeg"));
            if (sf != null) {
                ModifierMController.path = sf.getAbsoluteFile();
                String pathImg=sf.toURI().toString();
                testm.setText(pathImg);
                Image i = new Image(pathImg);
                imageViewm.setImage(i);
                System.out.println("aaaaa");
            }
        }
    }
 
       
        Maison c= new Maison();
    MaisonDao cs=new MaisonDao();
    AfficherMaisonController l;   
       
    
    public boolean estUnEntier(String chaine) {
		try {
			Integer.parseInt(chaine);
		} catch (NumberFormatException e){
			return false;
		}
 
		return true;
	}
    
    
    
    
    
    @FXML
    void btn_modifier(ActionEvent event) {
       // LocalDate db = dPdatedebut.getValue();
       // c.setDatedebut(java.sql.Date.valueOf(db));
        
         
      if (nomm.getText().equals("") || adressem.getText().equals("")||prixm.getText().equals("")||jourprixm.getText().equals("")||numbrechambrem.getText().equals(""))
                {
                     Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Inserer les informations!");
        alert.show();}
                 
       
           
           
            else 
       
       
if ( estUnEntier(nomm.getText())||!estUnEntier(prixm.getText())||!estUnEntier(numbrechambrem.getText())||estUnEntier(adressem.getText())||!estUnEntier(jourprixm.getText()))
                  {
                   Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("champ non valide !!");
        alert.show();
                
                  }
           else
{
       
       c.setPrix(Integer.parseInt(prixm.getText()));
       
       
        c.setNom(nomm.getText());
        c.setAdresse(adressem.getText());
         c.setPrix(Integer.parseInt(prixm.getText()));
 c.setJourprix(Integer.parseInt(jourprixm.getText()));  
  c.setNumberchambre(Integer.parseInt(numbrechambrem.getText()));
  c.setPath(testm.getText());
    
       
      int d= AfficherMaisonController.id;
        cs.update(c, d);
        
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("information");
        alert.setHeaderText(null);
        alert.setContentText("modification faite avec succes!");
        alert.showAndWait();
      
    
    }
    
    }
    
    
       
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
       testm.setVisible(false);
        
       System.out.println(AfficherMaisonController.id);
       
            c = cs.displayById(AfficherMaisonController.id);
            
          
          
           // dPdatedebut.setValue(df.toLocalDate());
        
        
        
        
        nomm.setText(c.getNom());
         adressem.setText(c.getAdresse());
         prixm.setText(Integer.toString(c.getPrix()));
         jourprixm.setText(Integer.toString(c.getJourprix()));
         numbrechambrem.setText(Integer.toString(c.getNumberchambre()));
        imageViewm.setImage(new Image(AfficherMaisonController.maison.getPath()));
      
      
        
        
        // TODO   
        
       
      
           // System.out.println("sinda wasss"+affiche.getid());
       
         //   c = pado.displayById(affiche.getid());
            
          
        
        
        
       
        
        
       
        retour1.setOnAction(event -> {

            try {
                Parent page3 = FXMLLoader.load(getClass().getResource("/com/esprit/view/AfficherMaison.fxml"));
                Scene scene = new Scene(page3);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });   
        
          show1.setOnAction(event -> {

            try {
                Parent page4 = FXMLLoader.load(getClass().getResource("/com/esprit/view/AfficherMaison.fxml"));
                Scene scene = new Scene(page4);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AccueilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); 
    
          
          
          
          
          
       
       System.out.println("jsbdhjsbdjhsbj");
 
          
}
            
 @FXML
    private void exit(MouseEvent event) {
          System.exit(0);
        
    }
    
}

         
   
          
          
          
        
        
   




    
    
   
            
        
