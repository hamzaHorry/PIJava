/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package host.and.Guest.Services;

import host.and.Guest.IServices.IexperiencesServices;
import host.and.Guest.entities.experiences;
import host.and.Guest.entities.hotel;
import host.and.Guest.utils.DataSource;
import java.sql.Connection;
import java.sql.Date;
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
 * @author esprit
 */
public class ExperienceService implements IexperiencesServices{
private final Connection cnx;   
    private static ExperienceService instance;




public ExperienceService()
{
cnx=DataSource.getMyInstance().getMyConnexion();
}
public static ExperienceService getInstance(){
        if(instance==null) 
            instance=new ExperienceService();
        return instance;
    }

    @Override
    public void add(experiences d) {
         String resq="insert into experiences (titre,dateDebut,dateFin,hotel_id,image_name) values (?,?,?,?,?)";
        
    try {
       
        PreparedStatement ps=cnx.prepareStatement(resq);
        ps.setString(1, d.getTitre());
        ps.setDate(2, d.getDateDebut());
        ps.setDate(3, d.getDateFin());
       ps.setInt(4, d.getId_hotel());
       ps.setString(5, d.getImage_name());


        ps.executeUpdate();
        
    } catch (SQLException ex) {
        Logger.getLogger(ExperienceService.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    
    }

    @Override
    public void remove(experiences p) {
     String query = "DELETE FROM `hotel`.`experiences` WHERE `experiences`.`id` =?;";
  
 try {
             PreparedStatement ps=cnx.prepareStatement(query);

              
               ps.setInt(1,p.getId());
               ps.executeUpdate();
               //System.out.println("Removed");
        } catch (SQLException ex) {
            Logger.getLogger(ExperienceService.class.getName()).log(Level.SEVERE, null, ex);
        }     }

    @Override
    public void update(experiences p) {
     String query = "UPDATE experiences set titre=? , dateDebut=?, dateFin=?,hotel_id=?,image_name=? WHERE id=?;";
      try {
          PreparedStatement ps=cnx.prepareStatement(query);

               ps.setString(1, p.getTitre());
               ps.setDate(2, p.getDateDebut());
               ps.setDate(3, p.getDateFin());
               ps.setInt(4, p.getId_hotel());
               ps.setString(5, p.getImage_name());
               ps.setInt(6, p.getId());
               ps.executeUpdate();
               System.out.println("UPDATED");
        } catch (SQLException ex) {
            Logger.getLogger(ExperienceService.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public List<experiences> getAll() {
List<experiences> lst = new ArrayList<>();
      try {
          Statement ste=cnx.createStatement();
String req="Select * from experiences;";
ResultSet rs=ste.executeQuery(req);
          
          while(rs.next()){
    experiences e = new experiences(rs.getInt("id"),rs.getString("titre"),rs.getDate("dateDebut"),rs.getDate("dateFin"),rs.getInt("id_hotel"),rs.getDouble("rating"));
    lst.add(e);
}
       
      } catch (SQLException ex) {
          Logger.getLogger(ExperienceService.class.getName()).log(Level.SEVERE, null, ex);
      }
                System.out.println(lst);

   return lst;

    }
     
    @Override
    public ObservableList<experiences>displayAll() {
         String req="select * from experiences";

        ObservableList<experiences> list=FXCollections.observableArrayList();       
        
        try {
          Statement ste=cnx.createStatement();
          ResultSet rs=ste.executeQuery(req);

            while(rs.next()){
                experiences p = new experiences(rs.getInt("id"),rs.getString("titre"),rs.getDate("dateDebut"),
                        rs.getDate("dateFin"),rs.getInt("hotel_id"),rs.getString("image_name"),rs.getDouble("rating"));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ExperienceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
       
    }

    @Override
    public ObservableList<experiences> ExperiencesLiked(String titre) {
        ObservableList<experiences> listData = FXCollections.observableArrayList();
        try {
            String sql = "select * from experiences where titre like '"+titre+"%'";
            Statement ste=cnx.createStatement();
            ResultSet rs=ste.executeQuery(sql);
            
           while (rs.next()) { 
       experiences e = 
      new experiences(rs.getInt("id"),rs.getString("titre"),rs.getDate("dateDebut"),
                        rs.getDate("dateFin"),rs.getInt("hotel_id"),rs.getDouble("rating"));

                
                listData.add(e);
            }
        } catch (Exception ex) {
            Logger.getLogger(ExperienceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listData;
    }
    public ObservableList<experiences>displaybyCritere(String Critere) {
         String req="select * from experiences ORDER BY "+Critere+" "+"ASC";

        ObservableList<experiences> list=FXCollections.observableArrayList();       
        
        try {
          Statement ste=cnx.createStatement();
          ResultSet rs=ste.executeQuery(req);

            while(rs.next()){
                experiences p = new experiences(rs.getInt("id"),rs.getString("titre"),rs.getDate("dateDebut"),
                        rs.getDate("dateFin"),rs.getInt("hotel_id"),rs.getString("image_name"),rs.getDouble("rating"));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ExperienceService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
       
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    


    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    

