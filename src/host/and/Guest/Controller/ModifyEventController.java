/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package host.and.Guest.Controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import host.and.Guest.entities.Event;
import host.and.Guest.entities.Hotel1;
import host.and.Guest.Services.EventService;
import host.and.Guest.Services.HotelService1;
import test.Test;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author bali
 */
public class ModifyEventController implements Initializable {

    @FXML
    private JFXTextField prix;

    @FXML
    private JFXTextField nomEvent;

    @FXML
    private JFXTextField nbrTicket;

    @FXML
    private JFXDatePicker date;

    @FXML
    private JFXComboBox<Hotel1> hotel;

    @FXML
    private ImageView image;

    @FXML
    private JFXButton upload;

    @FXML
    private JFXButton modifier;

    private File file;
    Stage dialogStage;
    public static Event ev;

    public void ModiferEvenementButton(ActionEvent event) {
        try {
            Event e = new Event();
            e.setId(ev.getId());
            e.setDateEvent(Date.valueOf(date.getValue()));
            e.setIdUser(Test.connectedUser);
            e.setNbrTicket(Integer.parseInt(nbrTicket.getText()));
            e.setNom(nomEvent.getText());
            e.setPrix(Float.parseFloat(prix.getText()));
            if (hotel.getSelectionModel().getSelectedItem() != null) {
                e.setIdHotel(hotel.getSelectionModel().getSelectedItem());
            } else {
                e.setIdHotel(ev.getIdHotel());
            }
            EventService es = new EventService();
            es.Update(e);
            dialogStage.close();
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    void uploadImageButton(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        Stage stage = new Stage();
        configureFileChooser(fileChooser);
        file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            try {
                BufferedImage bufferedImage = ImageIO.read(file);
                Image img = SwingFXUtils.toFXImage(bufferedImage, null);
                image.setImage(img);
            } catch (IOException ex) {

            }
        }
    }

    private static void configureFileChooser(
            final FileChooser fileChooser) {
        fileChooser.setTitle("Inserrer Image");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home"))
        );
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images", "*.*"),
                new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                new FileChooser.ExtensionFilter("PNG", "*.png")
        );
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            HotelService1 h = new HotelService1();
            hotel.setItems(h.getAll());
            hotel.setPromptText(ev.getIdHotel().getNom());
            nomEvent.setText(ev.getNom());
            prix.setText(String.valueOf(ev.getPrix()));
            BufferedImage bufferedImage = ImageIO.read(ev.getImage());
            Image img = SwingFXUtils.toFXImage(bufferedImage, null);
            image.setImage(img);
            nbrTicket.setText(String.valueOf(ev.getNbrTicket()));
            date.setValue(ev.getDateEvent().toLocalDate());

        } catch (IOException ex) {
            Logger.getLogger(ModifyEventController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void setevent(Event selectedItem) {
        ev = selectedItem;
    }

}
