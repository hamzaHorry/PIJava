/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.esprit.pi.service;

import edu.esprit.pi.gui.EventMain;
import edu.esprit.pi.iservice.IUser;
import host.and.Guest.entities.User;
import host.and.Guest.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import test.Test;

/**
 *
 * @author bali
 */
public class UserService implements IUser {

    private static Connection connection = DataSource.getMyInstance().getMyConnexion();
    private PreparedStatement ps;

    public UserService() {
        connection = DataSource.getMyInstance().getMyConnexion();
    }

    @Override
    public void add(User t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User findById(Integer idUser) {
        String req = "select * from fos_user where id = ?";
        User user = null;
        try {
            ps = connection.prepareStatement(req);
            ps.setInt(1, idUser);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(4), resultSet.getInt(6), resultSet.getString(8));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        String req = "select * from fos_user ";
        List<User> users = new ArrayList<>();
        ObservableList<User> observableList = null;
        try {
            ps = connection.prepareStatement(req);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                User User;
                User = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(4), resultSet.getInt(6), resultSet.getString(8));
                users.add(User);
            }
            observableList = FXCollections.observableList(users);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return observableList;
    }

    public static int seConnecter(String Identifiant, String MDP) {
        ResultSet resultSet;

        String req = "SELECT  *  FROM fos_user WHERE username='" + Identifiant + "'and password='" + MDP + "'";
        System.out.println(req);
        try {
            PreparedStatement st;
            st = connection.prepareStatement(req);
            resultSet = st.executeQuery(req);
            resultSet.last();
            int nbrRow = resultSet.getRow();
            if (nbrRow == 1) {
                Test.connectedUser = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(4), resultSet.getInt(6), resultSet.getString(8));
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;

    }

}
