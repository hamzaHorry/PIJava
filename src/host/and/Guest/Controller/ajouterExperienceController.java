
package host.and.Guest.Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXDatePicker;
import javafx.scene.control.ChoiceBox;
import host.and.Guest.entities.experiences;
import host.and.Guest.Services.ExperienceService;
import host.and.Guest.Services.hotelService;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Date;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static javafx.scene.input.KeyCode.T;
import javafx.stage.FileChooser;
import javafx.stage.Stage;






/**
 *
 * @author home
 */
public class ajouterExperienceController implements Initializable {
    
     @FXML
    private ImageView AjoutButton;

    @FXML
    private JFXTextField nomExperienceField;
     @FXML
    private ImageView retourButton;
      @FXML
    private JFXDatePicker dateDebPicker;

    @FXML
    private JFXDatePicker dateFinPicker;
     @FXML
    private Button btn_photo;

    @FXML
    private ImageView img;
     @FXML
    private TextField test;
         @FXML
    private JFXButton hotelButton;

    @FXML
    private Label hotelLabel;
Echangevaleur ec = new Echangevaleur();
    @FXML
    private ImageView imgupload;
     @FXML
    private ImageView menuButton;
    



   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        /*liste de noms des hotels*/
        
         hotelService hotS = new hotelService();
       
               hotelLabel.setText(ec.getName());
              

        
        
        /*   List<String> namesList = (List<String>)hotS.displayAll()
                   .stream()
            .map(e->e.getName()).collect(Collectors.toList());
           ObservableList<String> liste=FXCollections.observableArrayList();
           liste.addAll(namesList);
           combo.setItems(liste);*/
        
        
        hotelButton.setOnAction(event -> {
         //   try {
                /*     Parent page2 = FXMLLoader.load(getClass().getResource("/host/and/Guest/GUI/listeHotels.fxml"));
           
                Scene scene = new Scene(page2);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();*/
                
                
                   Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/host/and/Guest/GUI/listeHotels.fxml"));
            Stage stage = new Stage();
            stage.setTitle("liste des hotels");
            stage.setScene(new Scene(root, 740, 538));
            stage.show();
            stage.setOnHidden(eventa -> {
                
                hotelLabel.setText(ec.getName());
                
            });
            // Hide this current window (if this is what you want)
            //((Node)(event.getSource())).getScene().getWindow().hide();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        /*        Parent root = FXMLLoader.load(getClass().getResource("/host/and/Guest/GUI/listeHotels.fxml"));
        
        Scene scene1 = new Scene(root);
       Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();

        
        stage1.setScene(scene1);
       //stage.setResizable(false);

        stage1.show();
        
        
            } catch (IOException ex) {
                Logger.getLogger(aceuilController.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        });
            
            
       
        
        
        
        
        
      AjoutButton.setOnMouseClicked(event->{
           
          Date date1 = java.sql.Date.valueOf(dateDebPicker.getValue());         
                  
          Date date2 = java.sql.Date.valueOf(dateFinPicker.getValue());
           experiences e = new experiences(nomExperienceField.getText(),date1,date2,ec.getId(),test.getText());
            //PersonneDao pdao = PersonneDao.getInstance();
            ExperienceService expS = ExperienceService.getInstance();
            expS.add(e);
            
        
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("experience insérée avec succés!");
        alert.show();
        nomExperienceField.setText("");
        dateDebPicker.setValue(null);
        dateFinPicker.setValue(null);
        hotelLabel.setText(null);
        img.setVisible(false);
        //prenom.setText("");*/
      
        });
      menuButton.setOnMouseClicked(event -> {
            try {//FXMLLoader loader = new FXMLLoader();
                //loader.setLocation(getClass().getResource("/com/esprit/view/Accueil.fxml"));
                Parent page2 = FXMLLoader.load(getClass().getResource("/host/and/Guest/GUI/afficherExperience.fxml"));
                // Give the controller access to the main app.
//                AfficherPersonneController controller =loader.getController();
//                controller.setListData(new ListData());
                Scene scene = new Scene(page2);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(aceuilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });;
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      retourButton.setOnMouseClicked(event->{

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/host/and/Guest/GUI/aceuil.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(aceuilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); 
      
      test.setVisible(false);
        imgupload.setOnMouseClicked(event->{
                FileChooser fc = new FileChooser();
                fc.setInitialDirectory(new File("C:\\Users\\home\\Desktop"));
                fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("image","*.bmp", "*.png", "*.jpg", "*.gif"));
                File file = fc.showOpenDialog(new Stage());
                if (file !=null)
                {
                    try {
                        String imagepath = file.toURI().toURL().toString();
                        System.out.println(imagepath);
                      //  System.out.println(imagepath);
                        //  l.setText(selectedFile.getAbsolutePath());
                        Image image = new Image(imagepath);
                    //    img = new ImageView(image);
                        img.setImage(image);
                        test.setText(imagepath);
                        
                        //     img.setFitHeight(150);
                        //   img.setFitWidth(100);
                        // img.setPreserveRatio(true);
                    }
                    /*
                    FileChooser tnchooser = new FileChooser();
                    chooser.setTitle("Open File");
                    File file = chooser.showOpenDialog(new Stage());
                    if(file != null) {
                    String imagepath = file.getPath();
                     */
                    // simple displays ImageViee the image as is
                    // img.setImage(image);
                    catch (MalformedURLException ex) {
                        Logger.getLogger(ajouterExperienceController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                
                
                
                
                
                
            });
      
      
      
      
         
        // TODO
    }
 

   
    
}
