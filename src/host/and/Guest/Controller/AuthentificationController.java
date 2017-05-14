/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package host.and.Guest.Controller;

import static test.Test.Alerts;
import host.and.Guest.Services.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mehdi
 */
public class AuthentificationController {

    @FXML
    private TextField identifiant;
    @FXML
    private TextField password;
    @FXML
    private Button btnConnexion;
    //@FXML
    //private ImageView image;
    

    @FXML
    public void initialize() {
    }

    @FXML
    private void btnConnexionAction(ActionEvent event) {

        Stage stagex = (Stage) identifiant.getScene().getWindow();
        if (UserService.seConnecter(identifiant.getText(), password.getText()) == 1) {
          
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/host/and/Guest/GUI/principal.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stagex.close();
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
             
             
             
             
             
             
             
             
             
             
             

            
        } else {
            Alerts("utilisateur ou mots de passe faux ");

        }

    }

}
