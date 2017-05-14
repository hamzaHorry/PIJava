/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.controller;


import static com.esprit.controller.AfficherMaisonController.Alerts;
import com.esprit.dao.UserService;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sindamtar
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
    

    public void initialize() {
    }

    @FXML
    private void btnConnexionAction(ActionEvent event) throws SQLException {

        Stage stagex = (Stage) identifiant.getScene().getWindow();
     
        int a= UserService.getInstance().seConnecter(identifiant.getText(), password.getText());
        System.out.println(a);
        if (UserService.instance.seConnecter(identifiant.getText(), password.getText()) == 1) {
            if(identifiant.getText().equals("hamzahorry"))
                try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/esprit/view/HostGuest.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stagex.close();
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
                        if(identifiant.getText().equals("onsBali"))

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/esprit/view/HostGuest.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stagex.close();
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
                                 if(identifiant.getText().equals("sindaMtar"))
              try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/esprit/view/HostGuest.fxml"));
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
 @FXML
    private void exit(MouseEvent event) {
          System.exit(0);
        
    }
}
