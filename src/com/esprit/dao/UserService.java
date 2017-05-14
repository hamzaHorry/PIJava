/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */package com.esprit.dao;

import com.esprit.dao.Idao;
import com.esprit.entity.Maison;
import host.and.Guest.utils.DataSource;

import edu.esprit.pi.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author sindamtar
 */
public class UserService implements Idao {

       public static UserService instance;
    private Statement st;
    private ResultSet rs;
    
    public UserService() {
        DataSource cs=DataSource.getMyInstance();
        try {
            st=cs.getMyConnexion().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(MaisonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static UserService getInstance(){
        if(instance==null) 
            instance=new UserService();
        return instance;
    }
    public void add(User t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void delete(Integer r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public User findById(Integer idUser) throws SQLException {
        String req = "select * from fos_user where id = ?";
        User user = null;
        //st.setInt(1, idUser);
            rs=st.executeQuery(req);
            while(rs.next()){
                 user =new User(rs.getInt("id"));
            }
        return user;
    }
/*
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
*/
    public  int seConnecter(String Identifiant, String MDP) throws SQLException {
      

        String req = "SELECT  *  FROM fos_user WHERE username='" + Identifiant + "'and password='" + MDP + "'";
        System.out.println(req);
        
        
        
        
       rs=st.executeQuery(req);      
        try {
            rs.last();
          
            int nbrRow = rs.getRow();
            System.out.println(nbrRow);
            if (nbrRow == 1) {
                User user = new User(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getInt(6), rs.getString(8));
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void insert(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List displayAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object displayById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Object os, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
