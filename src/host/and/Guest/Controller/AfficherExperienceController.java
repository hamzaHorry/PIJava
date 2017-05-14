/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package host.and.Guest.Controller;
 import impl.org.controlsfx.skin.*;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import static com.jfoenix.svg.SVGGlyphLoader.clear;
import com.sun.deploy.util.ArrayUtil;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import host.and.Guest.entities.experiences;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import host.and.Guest.Services.ExperienceService;
import host.and.Guest.Services.hotelService;
import java.io.File;
import java.net.MalformedURLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import org.controlsfx.control.Rating;
import impl.org.controlsfx.behavior.RatingBehavior;
import javafx.geometry.Orientation;
import javafx.scene.Cursor;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;


/**
 * FXML Controller class
 *
 * @author home
 */
public class AfficherExperienceController implements Initializable {
    
    @FXML
    private TableView<experiences> experiencesTable;
    
      @FXML
    private TableColumn<experiences, Integer> idColumn;

    
    @FXML
    private TableColumn<experiences, String> titreColumn;

    @FXML
    private TableColumn<experiences, Date> dateDebColumn;

    @FXML
    private TableColumn<experiences, Date> dateFinColumn;

    @FXML
    private Label idLabel;
    
     @FXML
    private Label hotelLabel;
      @FXML
    private TextField test;
       @FXML
    private JFXTextField ratingtext;
       @FXML
    private HBox ratingBox;




    
    

    @FXML
    private JFXTextField titrreTextField;
    
    
    @FXML
    private JFXTextField NameSearch;


   
    @FXML
    private ImageView retourButton;
    @FXML
    private ImageView deleteButton;
    
     @FXML
    private ImageView updateButton;
      @FXML
    private ImageView validerButton;

    @FXML
    private ImageView ajouterButton;
     
    @FXML
    private JFXDatePicker dateDebField;

    @FXML
    private JFXDatePicker dateFinField;
    
    @FXML
    private JFXComboBox<String> combo;
    
    
    @FXML
    private ComboBox<String> combo2;
    
    
    @FXML
    private ImageView newimgButton;

    @FXML
    private ImageView img;
       @FXML
    private Label yourRating;

      
 




    
        private ListData listdata = new ListData();
                private Rating rating ;
                
                
                ObservableList<String> liste = FXCollections.observableArrayList("titre","dateDebut","dateFin");


        
        
        


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        experiencesTable.getStylesheets().add("/host/and/Guest/Css/moniteurgui.css");
                        combo2.setItems(liste);
                        

                                        

  //.................................initialisation des variables
          newimgButton.setVisible(false);
          
          combo.setVisible(false);
          //combo des hotels......
             hotelService hotS = new hotelService();

          List<String> namesList = (List<String>)hotS.displayAll()
                   .stream()
            .map(e->e.getName()).collect(Collectors.toList());
           ObservableList<String> liste=FXCollections.observableArrayList();
           liste.addAll(namesList);
           combo.setItems(liste);
           
        //initialisation du rating Box
            rating = new Rating();
            rating.getRating();
            rating.setRating(0);
                    
        rating.setOrientation(Orientation.HORIZONTAL);
        

    rating.setPartialRating(true);
    rating.setMax(5);
    
    rating.setUpdateOnHover(true);
    ratingBox.getChildren().add(rating);
    
    
    //ratingtext.setText(String.valueOf(rating.getRating()));
  
  
  
  
  
  
  
          
          
 /*............................ table view et afeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeefichage ............................................................*/
       experiencesTable.setItems(listdata.getExperiences());


        titreColumn.setCellValueFactory(new PropertyValueFactory<>("titre"));
        dateDebColumn.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
       dateFinColumn.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
      //idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        
        experiencesTable.setOnMouseClicked(event->{
         
        idLabel.setText(String.valueOf(listdata.getExperiences()
                .get(experiencesTable.getSelectionModel().getSelectedIndex())
                .getId()));
       titrreTextField.setText(listdata.getExperiences()
                .get(experiencesTable.getSelectionModel().getSelectedIndex())
                .getTitre());
       dateDebField.setValue(LocalDate.parse(listdata.getExperiences()
                .get(experiencesTable.getSelectionModel().getSelectedIndex())
                .getDateDebut().toString()));

        dateFinField.setValue(LocalDate.parse(listdata.getExperiences()
                .get(experiencesTable.getSelectionModel().getSelectedIndex())
                .getDateFin().toString()));
        rating.setRating(listdata.getExperiences()
                .get(experiencesTable.getSelectionModel().getSelectedIndex())
                .getRating());
        
        //set hotel value
        int n =listdata.getExperiences()
                .get(experiencesTable.getSelectionModel().getSelectedIndex())
                .getId_hotel();
            System.out.println("n estt"+n);
                   System.out.println(n);

        String ch=hotS.displayAll()
                .stream().filter(e->e.getId()==n
                ).map(e->e.getName()).findFirst().get();
         //if (n == 0) ch= "hotel non mentionné";//
            //System.out.println("valeur ch est"+ch);
            hotelLabel.setText(ch);
            //set image value
            String path=listdata.getExperiences()
                .get(experiencesTable.getSelectionModel().getSelectedIndex())
                .getImage_name();
            System.out.println("pathis"+path);
            
            if (path!=null){
            Image image = new Image(path);

                        img.setImage(image);
            }
            
        
        
        
     });

             
//search................................................................

        ExperienceService expS = new ExperienceService();
          
        NameSearch.textProperty().addListener(new ChangeListener<String>() {
    @Override
    public void changed(ObservableValue<? extends String> observable,
            String oldValue, String newValue) {
        experiencesTable.setItems(expS.ExperiencesLiked(newValue));
       // System.out.println(" Text Changed to  " + newValue + ")\n");
        }
        });
        rating.ratingProperty().addListener(new ChangeListener<Number>() {
    @Override
    public void changed(ObservableValue<? extends Number> observable,
                Number oldValue, Number newValue) {
        ratingtext.setText(newValue.toString()); 
    }
});
        
      retourButton.setOnMouseClicked(event->{

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/host/and/Guest/GUI/aceuil.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();

            } catch (IOException ex) {
                Logger.getLogger(AfficherExperienceController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
      
            deleteButton.setOnMouseClicked(event->{

              
          ExperienceService ExpSe =new ExperienceService();
                  if (experiencesTable.getSelectionModel().getSelectedItem() != null) {

          experiences e1=experiencesTable.getSelectionModel().getSelectedItem();
          ExpSe.remove(e1);
                  experiencesTable.refresh();

           //experiencesTable.getItems().clear();
      //  experiencesTable.setItems(listdata.getExperiences());

         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("experience is Deleted with success");
        alert.show();
       
              try {
                  refreshMytable(event);
              } catch (IOException ex) {
                  Logger.getLogger(AfficherExperienceController.class.getName()).log(Level.SEVERE, null, ex);
              }
}
                  else {
            Alerts("Choisir experience : Suppression Impossible");
        }
    });
       
      
        updateButton.setOnMouseClicked(event->{ 
if (experiencesTable.getSelectionModel().getSelectedItem() != null){        
    
    img.setVisible(false);

        newimgButton.setVisible(true);
        combo.setVisible(true);
        hotelLabel.setVisible(false);
        ratingBox.setVisible(false);
        ratingtext.setVisible(false);
        yourRating.setVisible(false);

    }else {
                Alerts("Choisir experience : modification Impossible");

    
}
    
});
        ajouterButton.setOnMouseClicked(event -> {

            try {
                System.out.println(System.getProperty("java.version"));
                Parent page1 = FXMLLoader.load(getClass().getResource("/host/and/Guest/GUI/ajouterExperience.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(aceuilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
        
      validerButton.setOnMouseClicked(event->{
          ExperienceService ExpS = new ExperienceService();
          if (experiencesTable.getSelectionModel().getSelectedItem() != null){
        int id= experiencesTable.getSelectionModel().getSelectedItem().getId();
        experiences e=new experiences();
        e=getInput();
        e.setId(id);
        ExpS.update(e);
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("experience is Updated with success");
        alert.show();
       
       
              try {
                  refreshMytable(event);
              } catch (IOException ex) {
                  Logger.getLogger(AfficherExperienceController.class.getName()).log(Level.SEVERE, null, ex);
              }
          }else{
               Alerts("Choisir experience : validation Impossible");
          }
      });
            
      test.setVisible(false);

        newimgButton.setOnMouseClicked(event->{
                FileChooser fc = new FileChooser();
                fc.setInitialDirectory(new File("C:\\Users\\home\\Desktop"));
                fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("image","*.bmp", "*.png", "*.jpg", "*.gif"));
                File file = fc.showOpenDialog(new Stage());
                if (file !=null)
                {
                    try {
                        String imagepath = file.toURI().toURL().toString();
                      //  System.out.println(imagepath);
                        //  l.setText(selectedFile.getAbsolutePath());
                        Image image = new Image(imagepath);
                    //    img = new ImageView(image);
                        img.setImage(image);
                        test.setText(imagepath);
                     
                    }         catch (MalformedURLException ex) {
                        Logger.getLogger(ajouterExperienceController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
            });    
        
        
        
        combo2.setOnAction(e ->{ switch (combo2.getValue()) {
                
                case "dateDebut":
                    experiencesTable.setItems(expS.displaybyCritere("dateDebut"));
                    break;
                case "titre":
                    experiencesTable.setItems(expS.displaybyCritere("titre"));
                    break;
                default:
                    experiencesTable.setItems(expS.displaybyCritere("dateFin"));
                    break;
            }

            });
                
   };
   
     private experiences getInput(){
         //getting id_hotel from combo
          hotelService hotS = new hotelService();

           String val =combo.getValue();
        int n=hotS.displayAll().stream().filter(e->e.getName().equals(val)).mapToInt(e->e.getId()).findFirst().getAsInt();



         java.sql.Date date1 = java.sql.Date.valueOf(dateDebField.getValue());         
                  
          java.sql.Date date2 = java.sql.Date.valueOf(dateFinField.getValue());
        /*if(dateDebField.getValue()!=null)
         if(dateFinField.getValue()!=null)*/
           experiences e = new experiences(titrreTextField.getText(),date1,date2,n,test.getText());
        
        return e;
    }
      
          private void clear(){
        idLabel.setText("");        
        titrreTextField.setText("");
        dateDebField.setValue(null);
        dateFinField.setValue(null);
        }
          
         //refresh my table view
          
         private void refreshMytable(MouseEvent event) throws IOException{
             
             
              Parent page2 = FXMLLoader.load(getClass().getResource("/host/and/Guest/GUI/afficherExperience.fxml"));
                // Give the controller access to the main app.
//                AfficherPersonneController controller =loader.getController();
//                controller.setListData(new ListData());
                Scene scene = new Scene(page2);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
         }
         
         
         
          public static void Alerts(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Alert");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
          
          
          
          
          
          
          
          
          
          
          

}
      
        
        
        
        
        
        
        
    

