/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package host.and.Guest.Services;

import host.and.Guest.IServices.IhotelServices;
import host.and.Guest.entities.experiences;
import host.and.Guest.entities.hotel;
import host.and.Guest.utils.DataSource;
import java.sql.Connection;
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
 * @author home
 */
public class hotelService implements IhotelServices{
    private final Connection cnx;  
 
    
    public hotelService()
{
cnx=DataSource.getMyInstance().getMyConnexion();
}
   
    
    
    
    
    
    
    
    

    @Override
    public ObservableList<hotel> displayAll() {
 String req="SELECT * FROM `hotel`";

        ObservableList<hotel> list=FXCollections.observableArrayList();       
        
        try {
          Statement ste=cnx.createStatement();
          ResultSet rs=ste.executeQuery(req);

            while(rs.next()){
hotel h = new hotel(rs.getInt("id"),rs.getString("nom"),rs.getString("adresse"),rs.getInt("numberetoil"),
        rs.getInt("numberchambre"),rs.getString("path"));
                list.add(h);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(hotelService.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(list);
        return list;    }
    
    
     public ObservableList<hotel> hotelLiked(String titre) {
        ObservableList<hotel> listData = FXCollections.observableArrayList();
        try {
            String sql = "select * from hotel where nom like '"+titre+"%'";
            Statement ste=cnx.createStatement();
            ResultSet rs=ste.executeQuery(sql);
            
           while (rs.next()) { 
       hotel h = new hotel(rs.getInt("id"),rs.getString("nom"),rs.getString("adresse"),rs.getInt("numberetoil"),
        rs.getInt("numberchambre"),rs.getString("path"));
                
                listData.add(h);
            }
        } catch (Exception ex) {
            Logger.getLogger(ExperienceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listData;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


    
    
}
