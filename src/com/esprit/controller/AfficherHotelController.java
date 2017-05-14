/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controller;
import com.esprit.dao.HotelDao;
import com.esprit.entity.Hotel;


import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.lynden.gmapsfx.javascript.object.LatLong;
import com.lynden.gmapsfx.javascript.object.MapOptions;
import com.lynden.gmapsfx.javascript.object.MapTypeIdEnum;
import com.lynden.gmapsfx.javascript.object.Marker;
import com.lynden.gmapsfx.javascript.object.MarkerOptions;
import com.lynden.gmapsfx.service.geocoding.GeocoderStatus;
import com.lynden.gmapsfx.service.geocoding.GeocodingResult;
import com.lynden.gmapsfx.service.geocoding.GeocodingService;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 * FXML Controller class
 *
 * @author sindamtar
 */
public class AfficherHotelController implements Initializable , MapComponentInitializedListener {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Hotel> hotelsTable;
    @FXML
    private TableColumn<Hotel, String> NomColonne;
    @FXML
    private TableColumn<Hotel, String> AdresseColonne;
   @FXML
    private TableColumn<Hotel, Integer>  NumberetoilColonne; 

   
     @FXML
    private TableColumn<Hotel, Integer>  NumberchambreColonne;

       ObservableList<Hotel> hotels;
     
     
    @FXML
    private Label idLabel;
    @FXML
    private Label nomLabel;
    @FXML
    private Label adresseLabel;
    
    @FXML
    private Label numberetoilLabel;
   
    
    @FXML
    private Label numbrechambreLabel;
 

 
   private ListDatah listdata = new ListDatah();

    @FXML
    private Button btn_pie;
   @FXML
    private Button show;
    @FXML
    private ImageView imageView;
 @FXML
    private Button retour;
 @FXML
    private GoogleMapView mapView;

  private GoogleMap map;
    
    private GeocodingService geocodingService;

    private StringProperty address = new SimpleStringProperty();

    
  @FXML
    private Button btn_modif;
 
    
    
@FXML 
        
   private TextField  idSearch;
     
  @FXML
  
   private TextField adr;
    
  
    
    
      
 
   
   
    
   
    static Hotel hotel;
      

    public static int id;
    
  
@FXML
    public void addressTextFieldAction(ActionEvent e) {
         
    
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
       


    @FXML
    void handleDeleteHotel() {
          if (hotelsTable.getSelectionModel().getSelectedItem() != null) {
        Hotel p = hotelsTable.getSelectionModel().getSelectedItem();
        HotelDao pdao = HotelDao.getInstance();
       System.out.println("clicked");
  

      
          
//        alert.show();
        pdao.delete(p);
          }
        
    
    else {
            Alerts("Choisir un  Hotel a  supprimer...");
        }
   this.refreshtable();
    
    }
    
   
    
    
     public void refreshtable(){
        HotelDao pdao = HotelDao.getInstance();
        ObservableList<Hotel> list=FXCollections.observableArrayList(pdao.displayAll()); 
//            tableApprenant.setItems(list);
             hotelsTable.setItems(list);
    }




    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
        
     
      
        
        
        
        
    mapView.addMapInializedListener(this);
       //adr.setVisible(false);
    address.bind(adr.textProperty());
 
   // address.bindBidirectional(adr.textProperty());
        
        hotelsTable.setItems(listdata.getHotels());
      //  NomColonne.setCellValueFactory(new PropertyValueFactory<>("nom"));
        
        NomColonne.setCellValueFactory(new PropertyValueFactory<>("nom"));
        
        
        AdresseColonne.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        
        NumberetoilColonne.setCellValueFactory(new PropertyValueFactory<>("numberetoil"));
    
        
       
        
        NumberchambreColonne.setCellValueFactory(new PropertyValueFactory<>("numberchambre"));
 
        // newimgButton.setVisible(false);
  this.refreshtable();
        
  
  
        
        hotelsTable.setOnMouseClicked(event->{
            
              
           
            
        idLabel.setText(String.valueOf(listdata.getHotels()
                .get(hotelsTable.getSelectionModel().getSelectedIndex())
                .getId()));
        nomLabel.setText(listdata.getHotels()
                .get(hotelsTable.getSelectionModel().getSelectedIndex())
                .getNom());
        adresseLabel.setText(listdata.getHotels()
                .get(hotelsTable.getSelectionModel().getSelectedIndex())
                .getAdresse());
        numberetoilLabel.setText(String.valueOf(listdata.getHotels()
                .get(hotelsTable.getSelectionModel().getSelectedIndex())
                .getNumberetoil()));
       
        numbrechambreLabel.setText(String.valueOf(listdata.getHotels()
                .get(hotelsTable.getSelectionModel().getSelectedIndex())
                .getNumberchambre()));
       
         adr.setText(listdata.getHotels()
                .get(hotelsTable.getSelectionModel().getSelectedIndex())
                .getAdresse());
        
        
        String path=listdata.getHotels()
                .get(hotelsTable.getSelectionModel().getSelectedIndex())
                .getPath();
        
   
                //.get(personsTable.getSelectionModel().getSelectedIndex()).getAdresse();
      // PrenomColonne.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        System.out.println("hkhkhjkhk"+adr);
        System.out.println("hkhkhjkhk"+address);
        Image image=new Image(path);
        imageView.setImage(image);
        
         


        
      
        
         
   
        hotel=new Hotel();
       hotel.setPath(path);
       
    });
        
        
             
     
    
    
                
            
            
            
            
      
       
        
     
 
      
             
             
       
        
     
            
        
    
        
    
        
        //Redirection vers l'interface PieChart
        btn_pie.setOnAction(event->{
            try {
                System.out.println("Bonjour Sinda");
                Parent pagePieChart=FXMLLoader.load(getClass().getResource("/com/esprit/view/PieChartView.fxml"));
                Scene scene=new Scene(pagePieChart);
                Stage stage=(Stage) ((Node) event.getSource())
                        .getScene()
                        .getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AfficherHotelController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
  
        
         retour.setOnAction(event -> {

            try {
                Parent page3 = FXMLLoader.load(getClass().getResource("/com/esprit/view/Accueil.fxml"));
                Scene scene = new Scene(page3);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AfficherHotelController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); 
        
        
         
         
         
         show.setOnAction(event -> {

            try {
                Parent page4 = FXMLLoader.load(getClass().getResource("/com/esprit/view/AjouterHotel.fxml"));
                Scene scene = new Scene(page4);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AfficherHotelController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); 
        
    
    
         
      
  
       
        idSearch.textProperty().addListener(new ChangeListener<String>() {
  
            
            
            
    @Override
    public void changed(ObservableValue<? extends String> observable,
            String oldValue, String newValue) {
         HotelDao pdao = HotelDao.getInstance();
        
         
         hotelsTable.setItems(pdao.hotelLiked(newValue));
    
        
        
        
       
        
        
   //  System.out.println(" Text Changed to  " + newValue + ")\n");
      //personsTable.getItems().clear();
 
        
       
       
    }
    
    
    
    
    
  }); 
   
   
   
   
       
    
    
   
                
       
     
        
       
        
        
        
}
      
    
    @FXML
     public  void modifier(ActionEvent event) throws IOException {
           if (hotelsTable.getSelectionModel().getSelectedItem() != null) {
       Hotel c = hotelsTable.getSelectionModel().getSelectedItem();
    
       Stage stage = (Stage) btn_modif.getScene().getWindow();
        // maison =personsTable.getSelectionModel().getSelectedItem();
        id=c.getId();
     
        
       Parent root = FXMLLoader.load(getClass().getResource("/com/esprit/view/ModifierH.fxml"));
       
        Scene scene = new Scene(root);

        stage.setScene(scene);

        stage.show(); }
         else {
            Alerts("Choisir Un Hotel  a modifier ...");
        } 

    }   
         
          
       HotelDao mos = new HotelDao();
  
         

     
       
       
          
      public static void Alerts(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    } 
       
    @Override
    public void mapInitialized() {
        geocodingService = new GeocodingService();
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
        
    
    MarkerOptions markerOptions = new MarkerOptions();

    markerOptions.position( new LatLong(47.6, -122.3) )
                .visible(Boolean.TRUE)
                .title("My Marker");

    Marker marker = new Marker( markerOptions );

    map.addMarker(marker);

    
    
    }     
        
      @FXML
    private void exit(MouseEvent event) {
          System.exit(0);
        
    }  
    }
    
    
    
    
    


