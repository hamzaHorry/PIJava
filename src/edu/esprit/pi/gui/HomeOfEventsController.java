/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pi.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import static edu.esprit.pi.gui.EventMain.Alerts;
import edu.esprit.pi.models.Event;
import edu.esprit.pi.models.User;
import edu.esprit.pi.service.EventService;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author bali
 */
public class HomeOfEventsController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Event> tab;

    @FXML
    private TableColumn<?, ?> tabHotel;

    @FXML
    private TableColumn<?, ?> tabTicket;

    @FXML
    private TableColumn<?, ?> tabNomEvent;

    @FXML
    private TableColumn<?, SimpleStringProperty> tabDate;

    @FXML
    private TableColumn<?, ?> TabPrix;

    @FXML
    private TableColumn<?, ?> tabIdEvent;

    @FXML
    private JFXTextField idUser;
    
    @FXML
    private JFXTextField txt_recherche;
    
    /*@FXML 
    private JFXButton btn_afficher;
    */
    private ObservableList<Event> data;
    private ObservableList<Event> data2;

    public User U = new User(1);
    List<Event> listEvent;
    Event event = new Event();
    EventService es = new EventService();
    @FXML
    private JFXTextField idEvent;
    private Stage primaryStage;

    @FXML
    private void afficherEvents()
    {
        ShowHome();
    }
    
    @FXML
    void ajouterEvenementButton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(EventMain.class.getResource("AjoutEvent.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage dialogStage = new Stage();
            dialogStage.setScene(scene);
            AjoutEventController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            dialogStage.showAndWait();
            ShowHome();
        } catch (Exception e) {

        }
    }

    @FXML
    void uploadImageButton(ActionEvent event) {

    }
    
    @FXML
    private void SearchEvent() {
        showSearch();
    }

    
    
    
    
    @FXML
    void ModifierEvenementButton(ActionEvent event) {
        if (tab.getSelectionModel().getSelectedItem() != null) {
            ModifyEventController.setevent(tab.getSelectionModel().getSelectedItem());
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(EventMain.class.getResource("ModifyEvent.fxml"));
                Parent root = loader.load();
                Scene scene = new Scene(root);
                Stage dialogStage = new Stage();
                dialogStage.setScene(scene);
                ModifyEventController controller = loader.getController();
                controller.setDialogStage(dialogStage);
                dialogStage.showAndWait();
                ShowHome();
            } catch (IOException ex) {
                Logger.getLogger(HomeOfEventsController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            Alerts("Choisir evenement : Modification Impossible");
        }
    }

    @FXML
    void supprimerEvenementButton(ActionEvent event) {
        if (tab.getSelectionModel().getSelectedItem() != null) {
            Event selectedEvent = tab.getSelectionModel().getSelectedItem();
            EventService es = new EventService();
            es.delete(selectedEvent.getId());
            ShowHome();

        } else {
            Alerts("Choisir evenement : Suppression Impossible");
        }
    }
    
 
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ShowHome();
    }

    public void ShowHome() {
        data = FXCollections.observableArrayList();
        listEvent = es.getAll(EventMain.connectedUser.getId());
        listEvent.stream().forEach((j) -> {
            data.add(j);
        });
        tab.setItems(data);
        tabHotel.setCellValueFactory(new PropertyValueFactory<>("idHotel"));
        tabIdEvent.setCellValueFactory(new PropertyValueFactory<>("id"));
        tabTicket.setCellValueFactory(new PropertyValueFactory<>("nbrTicket"));
        tabNomEvent.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tabDate.setCellValueFactory(new PropertyValueFactory<>("dateEvent"));
        TabPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
    }
    
    
    public void showSearch() {
        data2 = FXCollections.observableArrayList();
        
        String nom = txt_recherche.getText();
        listEvent = (List<Event>) es.findEventByName(nom,EventMain.connectedUser.getId());
        listEvent.stream().forEach((j) -> {
            data2.add(j);
            });
        
        
        tab.setItems(data2);
        tabHotel.setCellValueFactory(new PropertyValueFactory<>("idHotel"));
        tabIdEvent.setCellValueFactory(new PropertyValueFactory<>("id"));
        tabTicket.setCellValueFactory(new PropertyValueFactory<>("nbrTicket"));
        tabNomEvent.setCellValueFactory(new PropertyValueFactory<>("nom"));
        tabDate.setCellValueFactory(new PropertyValueFactory<>("dateEvent"));
        TabPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
    }

    void setDialogStage(Stage dialogStage) {
        primaryStage = dialogStage;
    }
    
    
    

}
