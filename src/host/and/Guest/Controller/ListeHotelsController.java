/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package host.and.Guest.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import host.and.Guest.Services.ExperienceService;
import host.and.Guest.Services.hotelService;
import host.and.Guest.entities.experiences;
import host.and.Guest.entities.hotel;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.beans.binding.StringExpression;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableObjectValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author home
 */
public class ListeHotelsController implements Initializable {
    
    
    
    
    
    
    
    
    
    
    
    
        
    @FXML
    private JFXListView<String> listview;

    @FXML
    private TextField lookHotel;

    @FXML
    private ImageView imageView;

    @FXML
    private Label nomHotel;

    @FXML
    private Label numeroEtoiles;
    @FXML
    private Label adresse;
    @FXML
    private ImageView ok;
    @FXML
    private Label number;


    
    
            private ListData listdata = new ListData();
          private  ObservableList<hotel> hotels=FXCollections.observableArrayList();

        hotelService hotS = new hotelService();


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
   // ObservableList<String> liste=FXCollections.observableArrayList();
        
        
        
        hotels= hotS.displayAll();
        System.out.println(hotels);
        
          List<String> namesList = (List<String>)hotS.displayAll()
                   .stream()
            .map(e->e.getName()).collect(Collectors.toList());
           ObservableList<String> liste=FXCollections.observableArrayList();
           liste.addAll(namesList);
        
        
        //listview.setItems(hotels);
        listview.setItems(liste);
        hotel h = new hotel();
        //listview.addEventFilter(String,h.getName() );
       listview.setOnMouseClicked(event->{
         
        nomHotel.setText(String.valueOf(hotels
                .get(listview.getSelectionModel().getSelectedIndex())
                .getName()));
      numeroEtoiles.setText(String.valueOf(hotels
                .get(listview.getSelectionModel().getSelectedIndex())
                .getNumberetoil()));
      adresse.setText(String.valueOf(hotels
                .get(listview.getSelectionModel().getSelectedIndex())
                .getAdresse()));
      number.setText(String.valueOf(hotels
                .get(listview.getSelectionModel().getSelectedIndex())
                .getNumberchambre()));
      String path=hotels
                .get(listview.getSelectionModel().getSelectedIndex())
                .getPath();
                
            System.out.println("pathis"+path);
            
            if (path!=null){
            Image image = new Image(path);
               imageView.setImage(image);
            }
            
    });  
       
       ok.setOnMouseClicked(event->{
           Echangevaleur ec = new Echangevaleur();
           
          ec.setId(hotels
                .get(listview.getSelectionModel().getSelectedIndex())
                .getId());
                      System.out.println(ec.getId());

           ec.setName(hotels
                .get(listview.getSelectionModel().getSelectedIndex())
                .getName());
                      System.out.println(ec.getName());

           
           Stage stage = (Stage) ok.getScene().getWindow();
    // do what you have to do
    stage.close();
           /* try {
                refreshMytable(event);
            } catch (IOException ex) {
                Logger.getLogger(ListeHotelsController.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        
       });
               lookHotel.textProperty().addListener(new ChangeListener<String>() {
    @Override
    public void changed(ObservableValue<? extends String> observable,
            String oldValue, String newValue) {
        
          List<String> namesList = (List<String>)hotS.hotelLiked(newValue)
                   .stream()
            .map(e->e.getName()).collect(Collectors.toList());
           ObservableList<String> liste=FXCollections.observableArrayList();
           liste.addAll(namesList);
        
        listview.setItems(liste);
       // System.out.println(" Text Changed to  " + newValue + ")\n");
        }
        });
    




}
    
    
    
  /* private void refreshMytable(ActionEvent event) throws IOException{
             
             
             /* Parent page2 = FXMLLoader.load(getClass().getResource("/host/and/Guest/GUI/ajouterExperience.fxml"));
                // Give the controller access to the main app.
//                AfficherPersonneController controller =loader.getController();
//                controller.setListData(new ListData());
                Scene scene = new Scene(page2);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();*/
             
       /* FXMLLoader loader = new FXMLLoader(
            getClass().getResource("/host/and/Guest/GUI/ajouterExperience.fxml")
        );
        loader.setController(this); // non-static method setController(Object) 
                                        // can not be referenced from static context ERROR****
        Parent root = (Parent) loader.load();
         }   */
}
