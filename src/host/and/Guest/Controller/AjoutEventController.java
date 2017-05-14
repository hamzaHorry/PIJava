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

import host.and.Guest.entities.User;
import host.and.Guest.Services.EventService;
import host.and.Guest.Services.HotelService1;
import host.and.Guest.Services.UserService;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import test.Test;

/**
 * FXML Controller class
 *
 * @author bali
 */
public class AjoutEventController implements Initializable {

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
    private JFXButton ajouter;
    private File file;
    Stage dialogStage;

    @FXML
    void ajouterEvenementButton(ActionEvent event) {
        try {
            Event e = new Event();
            e.setDateEvent(Date.valueOf(date.getValue()));
            e.setIdUser(Test.connectedUser);
            e.setNbrTicket(Integer.parseInt(nbrTicket.getText()));
            e.setNom(nomEvent.getText());
            e.setPrix(Float.parseFloat(prix.getText()));
            e.setIdHotel(hotel.getSelectionModel().getSelectedItem());
            String fileName = file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1);
            e.setImage(file);
            e.setImageName(fileName);
            EventService es = new EventService();
            es.add(e);
            handleEnvoiDetails(e);
            dialogStage.close();
        } catch (NumberFormatException | MessagingException ex) {
            Logger.getLogger(AjoutEventController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void handleEnvoiDetails(Event e) throws MessagingException {
        UserService sa = new UserService();
        String contenu;
        contenu = "Event Notification \n" + e + "\n";
        List<User> all = sa.getAll();
        for (User all1 : all) {
            sendMail(all1.getEmail(), "New Event ", contenu);
        }

    }

    public void sendMail(String userMail, String sujet, String contenu) throws MessagingException {

        String to = userMail;
        String host = "smtp.gmail.com";
        Properties prop = System.getProperties();
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.user", Test.connectedUser.getEmail());
        prop.put("mail.smtp.password", "21420549");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getDefaultInstance(prop);
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(userMail));

        InternetAddress toAdresse = new InternetAddress(to);

        msg.setRecipient(Message.RecipientType.TO, toAdresse);
        msg.setSubject(sujet);
        msg.setContent(contenu, "text/html; charset=utf-8");
        Transport transport = session.getTransport("smtp");
        transport.connect(host, Test.connectedUser.getEmail(), "21420549");
        transport.sendMessage(msg, msg.getAllRecipients());
        transport.close();

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
        HotelService1 h = new HotelService1();
        hotel.setItems(h.getAll());

    }

}
