/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package host.and.Guest.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import host.and.Guest.Services.EmailSender;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author home
 */
public class ContactExperienceController implements Initializable {
     @FXML
    private ImageView send;
      @FXML
    private ImageView retour;
    @FXML
    private JFXPasswordField Mypass;
    @FXML
    private JFXTextArea messageInput;
    @FXML
    private JFXTextField MyMail;
    @FXML
    private JFXTextArea subjectInput;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        send.setOnMouseClicked(event -> {
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
              Alert alert2 = new Alert(Alert.AlertType.ERROR);


          EmailSender emailS = new EmailSender();
        String[] to={"hamza.horry@gmail.com"};
       if  ( emailS.sendMail(MyMail.getText().trim(),Mypass.getText(),messageInput.getText(),subjectInput.getText(), to ))
       
       
       {
           System.out.println("yeeeeeeees");
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Email was sent with succes");
        alert.show();
       clear();
       }
      
      
       
       else  {
         alert2.setTitle("Error");
        alert2.setHeaderText(null);
        alert2.setContentText("Email was not sent check your informations");
        alert2.show(); }
        //clear();
        /*System.out.println(Login.getLogger().getId_gerant()+" from send mail");
        System.out.println( Login.getAdminMail(Login.getLogger().getId_gerant()));*/
    }); 
        retour.setOnMouseClicked(event -> { try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/host/and/Guest/GUI/principal.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(aceuilController.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    
    
    
    
    
    
    });
        
    }
    
    
    private void clear(){
        MyMail.clear();
        Mypass.clear();
    messageInput.clear();
     MyMail.clear();
     subjectInput.clear();

        
        
        
        
    }  
}
    

