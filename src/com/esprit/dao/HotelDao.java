/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.dao;


import com.esprit.entity.Hotel;
import com.esprit.entity.Maison;
import host.and.Guest.utils.DataSource;
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
 * @author wiemhjiri
 */
public class HotelDao implements Idao<Hotel>{
    
    private static HotelDao instance;
    private Statement st;
    private ResultSet rs;
    
    public HotelDao() {
        DataSource cs=DataSource.getMyInstance();
        try {
            st=cs.getMyConnexion().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(HotelDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static HotelDao getInstance(){
        if(instance==null) 
            instance=new HotelDao();
        return instance;
    }

    @Override
    public void insert (Hotel o) {
       
        String req="insert into hotel (nom,adresse,numberetoil,numberchambre,path) values ('"+o.getNom()+"','"+o.getAdresse()+"','"+o.getNumberetoil()+"','"+o.getNumberchambre()+"','"+o.getPath()+"')";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(HotelDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   

    @Override
    public void delete(Hotel o) {
        String req="delete from hotel where id="+o.getId();
        Hotel p=displayById(o.getId());
        
          if(p!=null)
              try {
           
            st.executeUpdate(req);
             
        } catch (SQLException ex) {
            Logger.getLogger(HotelDao.class.getName()).log(Level.SEVERE, null, ex);
        }else System.out.println("n'existe pas");
    }

    @Override
    public ObservableList<Hotel> displayAll() {
        String req="select * from hotel ORDER BY numberetoil ASC";
        ObservableList<Hotel> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Hotel p=new Hotel(rs.getInt("id"),rs.getString("nom"),rs.getString("adresse"),rs.getInt("numberetoil"),rs.getInt("numberchambre"),rs.getString("path"));
              
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(HotelDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Hotel> displayAllList() {
        String req="select * from hotel";
        List<Hotel> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                 Hotel p=new Hotel(rs.getInt("id"),rs.getString("nom"),rs.getString("adresse"),rs.getInt("numberetoil"),rs.getInt("numberchambre"),rs.getString("path"));
              
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(HotelDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    @Override
    public Hotel displayById(int id) {
           String req="select * from hotel where id ="+id;
           Hotel p=new Hotel();
        try {
            rs=st.executeQuery(req);
           // while(rs.next()){
            rs.next();
                p.setId(rs.getInt("id"));
                p.setNom(rs.getString("nom"));
                p.setAdresse(rs.getString("adresse"));
                p.setNumberetoil(rs.getInt("numberetoil"));
                
                p.setNumberchambre(rs.getInt("numberchambre"));
            //}  
        } catch (SQLException ex) {
            Logger.getLogger(HotelDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p;
    }


    
    
    
    
    
    
    
    
    
    
    @Override
    public boolean update(Hotel p,int id) {
        String qry = "UPDATE hotel SET nom = '"+p.getNom()+"', adresse = '"+p.getAdresse()+"', Numberetoil = '"+p.getNumberetoil()+"', numberchambre = '"+p.getNumberchambre()+"', path = '"+p.getPath()+"' WHERE id = "+p.getId();
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MaisonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    
     
    
    
    
    }
  
       
      
            
            
       
        
         public ObservableList<Hotel> hotelLiked(String id) {
             String req;
             if (id.equals("")){
               req="select * from hotel" ;
             }
             else{
         req="select * from hotel  where Numberetoil="+id;
             }
       
        ObservableList<Hotel> list=FXCollections.observableArrayList();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Hotel p=new Hotel(rs.getInt("id"),rs.getString("nom"),rs.getString("adresse"),rs.getInt("numberetoil"),rs.getInt("numberchambre"),rs.getString("path"));
              list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MaisonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
       


    /*
           
            @Override
    public String displayAllV() {
       String var;
           String req="select count(*) from hotel";
           var=req;
           
        try {
            rs=st.executeQuery(req);
           // while(rs.next()){
            
        } catch (SQLException ex) {
            Logger.getLogger(MaisonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
   return var;
    } 
        */
}
                
   
    
    
    

    

    
    

