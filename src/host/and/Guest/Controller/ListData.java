/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package host.and.Guest.Controller;

import host.and.Guest.Services.ExperienceService;
import host.and.Guest.entities.experiences;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;



/**
 *
 * @author wiemhjiri
 */
public class ListData {
    
     /**
     * The data as an observable list of Persons.
     */
    
    private ObservableList<experiences> experiences=FXCollections.observableArrayList();

    public ListData() {
        
        ExperienceService ExpS=ExperienceService.getInstance();
        experiences= ExpS.displayAll();
        System.out.println(experiences);
    }
    
    public ObservableList<experiences> getExperiences(){
        return experiences;
    }
   
}
