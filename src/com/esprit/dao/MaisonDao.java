/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.dao;


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
public class MaisonDao implements Idao<Maison>{
    
    private static MaisonDao instance;
    private Statement st;
    private ResultSet rs;
    
    public MaisonDao() {
        DataSource cs=DataSource.getMyInstance();
        try {
            st=cs.getMyConnexion().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(MaisonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static MaisonDao getInstance(){
        if(instance==null) 
            instance=new MaisonDao();
        return instance;
    }

    @Override
    public void insert (Maison o) {
       
        String req="insert into maison (nom,adresse,prix,jourprix,numberchambre,path) values ('"+o.getNom()+"','"+o.getAdresse()+"','"+o.getPrix()+"','"+o.getJourprix()+"','"+o.getNumberchambre()+"','"+o.getPath()+"')";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(MaisonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   

    @Override
    public void delete(Maison o) {
        String req="delete from maison where id="+o.getId();
        Maison p=displayById(o.getId());
        
          if(p!=null)
              try {
           
            st.executeUpdate(req);
             
        } catch (SQLException ex) {
            Logger.getLogger(MaisonDao.class.getName()).log(Level.SEVERE, null, ex);
        }else System.out.println("n'existe pas");
    }

    @Override
    public ObservableList<Maison> displayAll() {
        String req="select * from maison ORDER BY prix ASC";
        ObservableList<Maison> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Maison p=new Maison(rs.getInt("id"),rs.getString("nom"),rs.getString("adresse"),rs.getInt("prix"),rs.getInt("jourprix"),rs.getInt("numberchambre"),rs.getString("path"));
              
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MaisonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Maison> displayAllList() {
        String req="select * from maison";
        List<Maison> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                 Maison p=new Maison(rs.getInt("id"),rs.getString("nom"),rs.getString("adresse"),rs.getInt("prix"),rs.getInt("jourprix"),rs.getInt("numberchambre"),rs.getString("path"));
              
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MaisonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    @Override
    public Maison displayById(int id) {
           String req="select * from maison where id ="+id;
           Maison p=new Maison();
        try {
            rs=st.executeQuery(req);
           // while(rs.next()){
            rs.next();
                p.setId(rs.getInt("id"));
                p.setNom(rs.getString("nom"));
                p.setAdresse(rs.getString("adresse"));
                p.setPrix(rs.getInt("prix"));
                p.setJourprix(rs.getInt("jourprix"));
                p.setNumberchambre(rs.getInt("numberchambre"));
            //}  
        } catch (SQLException ex) {
            Logger.getLogger(MaisonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p;
    }


    
    
    
    
    
    
    
    
    
    
    @Override
    public boolean update(Maison p,int id) {
        String qry = "UPDATE maison SET nom = '"+p.getNom()+"', adresse = '"+p.getAdresse()+"', prix = '"+p.getPrix()+"', jourprix = '"+p.getJourprix()+"', numberchambre = '"+p.getNumberchambre()+"', path = '"+p.getPath()+"' WHERE id = "+p.getId();
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MaisonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    
     
    
    
    
    }
  
       
      
            
            
       
        
         public ObservableList<Maison> MaisonLiked(String id) {
             String req;
             if (id.equals("")){
               req="select * from maison" ;
             }
             else{
         req="select * from maison  where numberchambre="+id;
             }
       
        ObservableList<Maison> list=FXCollections.observableArrayList();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                Maison p=new Maison(rs.getInt("id"),rs.getString("nom"),rs.getString("adresse"),rs.getInt("prix"),rs.getInt("jourprix"),rs.getInt("numberchambre"),rs.getString("path"));
              list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MaisonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
         
         
       
}
    
         
         
           
      
         
         
         
                 
   
    
    
    

    

    
    

