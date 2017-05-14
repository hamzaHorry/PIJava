/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pi.service;

import edu.esprit.pi.iservice.IEvent;
import edu.esprit.pi.models.Event;
import edu.esprit.pi.models.Hotel;
import host.and.Guest.utils.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.List;
import host.and.Guest.entities.User;

/**
 *
 * @author bali
 */
public class EventService implements IEvent {

    private final Connection connection;
    private PreparedStatement ps;

    public EventService() {
        connection = DataSource.getMyInstance().getMyConnexion();
    }

    @Override
    public void Update(Event t) {
        InputStream fis = null;
        String req = "update event set user_id=?,hotel_id=?,nom=?,number_ticket=?,prix=?,date=? where id = " + t.getId();
        try {
            ps = connection.prepareStatement(req);
            ps.setInt(1, t.getIdUser().getId());
            ps.setInt(2, t.getIdHotel().getIdHotel());
            ps.setString(3, t.getNom());
            ps.setInt(4, t.getNbrTicket());
            ps.setFloat(5, t.getPrix());
            ps.setDate(6, t.getDateEvent());
            ps.executeUpdate();
            System.out.println(t.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Event t) {
        InputStream fis = null;
        String req = "insert into event (user_id,hotel_id,nom,number_ticket,prix,date,image,imageName) values (?,?,?,?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(req);
            ps.setInt(1, t.getIdUser().getId());
            ps.setInt(2, t.getIdHotel().getIdHotel());
            ps.setString(3, t.getNom());
            ps.setInt(4, t.getNbrTicket());
            ps.setFloat(5, t.getPrix());
            ps.setDate(6, t.getDateEvent());
            fis = new FileInputStream(t.getImage());
            int ilen = (int) t.getImage().length();
            System.out.println(ilen);
            System.out.println(fis);
            ps.setBinaryStream(7, fis, ilen);
            ps.setString(8, t.getImageName());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer idEvent) {
        String req = "delete from event where id =?";
        try {
            ps = connection.prepareStatement(req);
            ps.setInt(1, idEvent);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Event findById(Integer idEvent) {

        String req = "select * from event where id = ?";
        Event event = null;
        try {
            ps = connection.prepareStatement(req);
            ps.setInt(1, idEvent);
            ResultSet resultSet = ps.executeQuery();
            FileOutputStream fos = null;
            File image = null;
            if (resultSet.next()) {
                String str2 = resultSet.getString("imageName");
                if (!str2.equals("")) {
                    image = new File("D:\\events\\" + str2);
                    fos = new FileOutputStream(image);
                    byte[] buffer = new byte[1];
                    InputStream is = resultSet.getBinaryStream("image");
                    while (is.read(buffer) > 0) {
                        fos.write(buffer);
                    }
                    fos.close();
                }
                event = new Event(resultSet.getInt(1), new User(resultSet.getInt(1)), new Hotel(resultSet.getInt(2)), resultSet.getString(3), resultSet.getInt(4), resultSet.getFloat(5), resultSet.getDate(6), image);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }
    
    @Override
    public List<Event> findEventByName(String nom,int userId) {

        String req = "select * from event where nom LIKE ? and user_id ='" + userId + "'";
        List<Event> listevent = new ArrayList<>();
        try {
            ps = connection.prepareStatement(req);
            ps.setString(1, "%"+nom+"%");
            ResultSet resultSet = ps.executeQuery();
            FileOutputStream fos = null;
            File image = null;
            while (resultSet.next()) {
                String str2 = resultSet.getString("imageName");
                if (!str2.equals("")) {
                    image = new File("D:\\events\\" + str2);
                    fos = new FileOutputStream(image);
                    byte[] buffer = new byte[1];
                    InputStream is = resultSet.getBinaryStream("image");
                    while (is.read(buffer) > 0) {
                        fos.write(buffer);
                    }
                    fos.close();
                }
                Event event = new Event(resultSet.getInt(1), new UserService().findById(resultSet.getInt(2)), new HotelService().findById(resultSet.getInt(3)), resultSet.getString(4), resultSet.getInt(5), resultSet.getFloat(6), resultSet.getDate(7), image);
                listevent.add(event);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listevent;
    }
    
    
    public List<Event> getAll(int userId) {
        String req = "select * from event where user_id ='" + userId + "'";
        List<Event> listevent = new ArrayList<>();
        try {
            ps = connection.prepareStatement(req);
            ResultSet resultSet = ps.executeQuery();
            FileOutputStream fos = null;
            File image = null;
            while (resultSet.next()) {
                String str2 = resultSet.getString("imageName");
                if (!str2.equals("")) {
                    image = new File("D:\\events\\" + str2);
                    fos = new FileOutputStream(image);
                    byte[] buffer = new byte[1];
                    InputStream is = resultSet.getBinaryStream("image");
                    while (is.read(buffer) > 0) {
                        fos.write(buffer);
                    }
                    fos.close();
                }
                Event event = new Event(resultSet.getInt(1), new UserService().findById(resultSet.getInt(2)), new HotelService().findById(resultSet.getInt(3)), resultSet.getString(4), resultSet.getInt(5), resultSet.getFloat(6), resultSet.getDate(7), image);
                listevent.add(event);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return listevent;
    }

    @Override
    public List<Event> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
