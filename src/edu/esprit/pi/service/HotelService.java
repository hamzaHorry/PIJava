/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pi.service;

import edu.esprit.pi.iservice.IHotel;
import edu.esprit.pi.models.Hotel;
import host.and.Guest.entities.User;
import host.and.Guest.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author bali
 */
public class HotelService implements IHotel {

    private final Connection connection;
    private PreparedStatement ps;

    public HotelService() {
        connection = DataSource.getMyInstance().getMyConnexion();
    }

    @Override
    public void add(Hotel t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Hotel findById(Integer idHotel) {
        String req = "select * from hotel where id = ?";
        Hotel hotel = null;
        try {
            ps = connection.prepareStatement(req);
            ps.setInt(1, idHotel);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                hotel = new Hotel(resultSet.getInt(1), new User(resultSet.getInt(1)), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getInt(6), resultSet.getInt(6), resultSet.getInt(6));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hotel;
    }

    @Override
    public ObservableList<Hotel> getAll() {
        String req = "select * from hotel ";
        List<Hotel> hotels = new ArrayList<>();
        ObservableList<Hotel> observableList = null;
        try {
            ps = connection.prepareStatement(req);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Hotel hotel;
                hotel = new Hotel(resultSet.getInt(1), new User(resultSet.getInt(1)), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5), resultSet.getInt(6), resultSet.getInt(6), resultSet.getInt(6));
                hotels.add(hotel);
            }
            observableList = FXCollections.observableList(hotels);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return observableList;
    }

}
