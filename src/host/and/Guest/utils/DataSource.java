/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package host.and.Guest.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author esprit
 */
public class DataSource {
    
    private static DataSource instance;
    private Connection cnx;
    private String url;//="jdbc:mysql://localhost:3306/hotel";
    private String user;//="root";
    private String password;//="";
    private Properties properties;
    
    private DataSource(){
        
        properties=new Properties();
    
        try {
            properties.load(new FileInputStream(new File("configuration.properties")));
            url=properties.getProperty("url");
            user=properties.getProperty("user");
            password=properties.getProperty("password");
            cnx=DriverManager.getConnection(url, user, password);
            System.out.println("connexion avec succés");
        } catch (SQLException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("échec");
        } catch (IOException ex) {
            Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
    public static DataSource getMyInstance()
    {if(instance==null)
    instance=new DataSource();
    return instance;
    
    }
           
    public Connection getMyConnexion()
    {return cnx;}
    
    
    
    
}
