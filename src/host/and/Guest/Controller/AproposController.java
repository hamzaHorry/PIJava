/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package host.and.Guest.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author home
 */
public class AproposController implements Initializable {
    
    @FXML
    private MediaView media;
      @FXML
    private TextFlow flow;
        @FXML
    private ImageView retourButton;


    
  private MediaPlayer mediaPlayer;

    private static final String MEDIA_URL = "/host/and/Guest/photo/aaa.mp4";
   

    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         mediaPlayer = new MediaPlayer(new Media(this.getClass().getResource(MEDIA_URL).toExternalForm()));
        mediaPlayer.setAutoPlay(true);
        media.setMediaPlayer(mediaPlayer);
        
        
        
        retourButton.setOnMouseClicked(event -> {

            try {
                Parent page1 = FXMLLoader.load(getClass().getResource("/host/and/Guest/GUI/principal.fxml"));
                Scene scene = new Scene(page1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(aceuilController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); 
        

        
        
        
        // TODO
    }    
    
}
