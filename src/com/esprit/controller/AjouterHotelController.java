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



import com.esprit.dao.HotelDao;

import com.esprit.entity.Hotel;
import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.*;
import com.lynden.gmapsfx.service.geocoding.GeocoderStatus;
import com.lynden.gmapsfx.service.geocoding.GeocodingResult;
import com.lynden.gmapsfx.service.geocoding.GeocodingService;
import java.net.URL;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
public  class AjouterHotelController implements Initializable , MapComponentInitializedListener {
    
    @FXML
    private GoogleMapView mapView;
    
  
    
    private GoogleMap map;
    
    private GeocodingService geocodingService;

    private StringProperty address = new SimpleStringProperty();


    static File path =new File("");
    
    @FXML
    private Button btn_ajouter;
 
    @FXML
    private TextField nom;
    
 @FXML
    private TextField numbrechambre;
  
    @FXML
    private TextField numberetoil;
    @FXML
   
    private ImageView imageView;
     @FXML
    private Button retour;
    @FXML
    private Button show;
    
     @FXML
    private TextField test;
 
    
   @FXML
    private TextField adresse;

  
   
    
 

    
    
    
    
       @FXML
    private TableView<Hotel> hotelsTable;
       
       
       
       
       
       
 
      

   
       
       
       
       
       
       @FXML
    void choisirPhoto(ActionEvent event) {
        
 FileChooser fc = new FileChooser();
        File sf = fc.showOpenDialog(null);
        System.out.println("bbbbb");
        if (sf != null) {
            System.out.println("aaaaa");
            fc.setTitle("Ajouter");
            fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Images", "*.jpg", "*.png", "*.jpeg"));
            if (sf != null) {
                AjouterMaisonController.path = sf.getAbsoluteFile();
                String pathImg=sf.toURI().toString();
                test.setText(pathImg);
                Image i = new Image(pathImg);
                imageView.setImage(i);
                System.out.println("aaaaa");
            }
        }
    }
  
        @FXML
    public void addressTextFieldAction(ActionEvent event) {
        geocodingService.geocode(address.get(), (GeocodingResult[] results, GeocoderStatus status) -> {
            
            LatLong latLong = null;
            
            if( status == GeocoderStatus.ZERO_RESULTS) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "No matching address found");
                alert.show();
                return;
            } else if( results.length > 1 ) {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Multiple results found, showing the first one.");
                alert.show();
                latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());
            } else {
                latLong = new LatLong(results[0].getGeometry().getLocation().getLatitude(), results[0].getGeometry().getLocation().getLongitude());
            }
            
            map.setCenter(latLong);
 
        });}
       
       
       
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
            //  mapView.addMapInializedListener((MapComponentInitializedListener) this);
       // address.bind(adresse.textProperty());
         mapView.addMapInializedListener(this);
        address.bind(adresse.textProperty());
        test.setVisible(false);
        
        // TODO     
        
        
        
        
        
        BooleanBinding bb = new BooleanBinding() {
    {
        super.bind(numberetoil.textProperty(),
                numbrechambre.textProperty(),
                nom.textProperty(),
        adresse.textProperty());
    }

    @Override
    protected boolean computeValue() {
        return (numberetoil.getText().isEmpty()
                || numbrechambre.getText().isEmpty()
                || nom.getText().isEmpty()
                || adresse.getText().isEmpty()
                );
    }
};

     
btn_ajouter.disableProperty().bind(bb);
        
        
        btn_ajouter.setOnAction(event -> {
            
            
            
            
            
            
            
           if ( estUnEntier(nom.getText())||!estUnEntier(numberetoil.getText())||!estUnEntier(numbrechambre.getText())||estUnEntier(adresse.getText()))
                  {
                   Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("champ non valide !!");
        alert.show();
                
                  } 
            
            
                else{
      int nume = Integer.parseInt(numberetoil.getText());
      int num = Integer.parseInt(numbrechambre.getText());
            Hotel p = new Hotel(nom.getText(), adresse.getText(),nume,num,test.getText());
            HotelDao pdao = HotelDao.getInstance();
            pdao.insert(p);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Hotel insérée avec succés!");
        alert.show();
        nom.setText("");
        adresse.setText("");
        numberetoil.setText("");
        
        numbrechambre.setText("");
       // path.getAbsolutePath();
       
        
     
     
      
        ObservableList<Hotel> list=FXCollections.observableArrayList(pdao.displayAll()); 
//            tableApprenant.setItems(list);
             hotelsTable.setItems(list);
             
           //  Image img = null;
       Image img = new Image(path.toURI().toString());
        imageView.setImage(img);
    
           }
            
        });
        
     
        
        
         
            
        
        
       
        retour.setOnAction(event -> {

            try {
                Parent page3 = FXMLLoader.load(getClass().getResource("/com/esprit/view/AfficherHotel.fxml"));
                Scene scene = new Scene(page3);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AjouterHotelController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });   
        
          
    
          show.setOnAction(event -> {

            try {
                Parent page3 = FXMLLoader.load(getClass().getResource("/com/esprit/view/AfficherHotel.fxml"));
                Scene scene = new Scene(page3);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AjouterHotelController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); 
        
        
        
        
    }
          
     @Override
    public void mapInitialized() {
        geocodingService = new GeocodingService();
         
       
              
           
        
        //Set the initial properties of the map.
        MapOptions mapOptions = new MapOptions();
        
        mapOptions.center(new LatLong(47.6097, -122.3331))
                .mapType(MapTypeIdEnum.ROADMAP)
                .overviewMapControl(false)
                .panControl(false)
                .rotateControl(false)
                .scaleControl(false)
                .streetViewControl(false)
                .zoomControl(false)
                .zoom(12);
                   
        map = mapView.createMap(mapOptions);
      //  map =mapView.getWebview().widthProperty();

        //Add markers to the map
        
        
    }   
    
       public boolean estUnEntier(String chaine) {
		try {
			Integer.parseInt(chaine);
		} catch (NumberFormatException e){
			return false;
		}
 
		return true;
	}    
          
        @FXML
    private void exit(MouseEvent event) {
          System.exit(0);
        
    } 
        
    }




    
    
   
            
        
