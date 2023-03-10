/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reclam.Services;

/**
 *
 * @author houssem
 */

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
import reclam.Entities.blackliste;
import reclam.Entities.reclamation;
import reclam.utils.MyDB;
import java.sql.DriverManager;

/**
 *
 * @author Mohamed
 */
public  class Servicereclamation implements IService<reclamation>{
    Connection cnx;

    @Override
    public void add(reclamation r) {
         try {
        String qry ="INSERT INTO `reclamation`( `descr`,`nomr`,`emailr`,`type`,`traiter`) VALUES ('"+r.getDescr()+"','"+r.getNomr()+"','"+r.getEmailr()+"','"+r.getType()+"','"+r.getTraiter()+"')";
                     System.out.println(qry);

      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }

    }

    public ObservableList<reclamation> afficher() {
        ObservableList<reclamation> list = FXCollections.observableArrayList();
        
        try {
            String qry = "SELECT * FROM `reclamation`";
           cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
           
             ResultSet rs = stm.executeQuery(qry);
            while(rs.next()) {
                list.add(new reclamation(rs.getString("descr"), rs.getString("nomr"),rs.getString("type"),rs.getString("emailr"),rs.getString("traiter")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
                   

        return list;
    }
  
    
    
    
 


    public void modifier(reclamation r) {
       try {
           String qry ="UPDATE reclamation SET  `descr` ='" +r.getDescr()+ "', `type` ='"+r.getType()+"', `emailr` = '"+r.getEmailr()+"', `emailr` = '"+r.getEmailr()+"' where nomr = '"+r.getNomr()+"';";

           cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        }

    //@Override
    
public void update(reclamation r) {
       try {
           String qry ="UPDATE reclamation SET  `traiter` ='" +r.getTraiter()+ "' where nomr = '"+r.getNomr()+"';";

           cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        }
    
    public void supprimer(String nomr ) {
    
              try {
             
             String qry ="DELETE from reclamation where nomr = '"+nomr+"';";
      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }    }

    
   
public ObservableList<reclamation> getAllTrinom() {
        ObservableList<reclamation> list = FXCollections.observableArrayList();
        try {
         //   String req = "Select * from espacetalent where roles like '%[]%' order by nom";
                String qry = "Select * from `reclamation`  order by nomr";
                  System.out.println(qry);
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
            //    EspaceTalent u = new EspaceTalent(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("username"), rs.getString("email"), rs.getString("file"), rs.getInt("etat"), rs.getDate("created_at"));
        reclamation r  = new reclamation(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6) ); 
      
   
        list.add(r) ;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }


    
    public void onSaveRating(int value) {
        
            try {
                String qry = "INSERT INTO `rating` (`value`) VALUES ('"+value+"')";
                    System.out.println(qry);

      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
 public ObservableList<reclamation> getDatareclamation() {
            ObservableList<reclamation> list = FXCollections.observableArrayList();
        try {
            String qry = "SELECT * FROM `reclamation`";
           cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
           
             ResultSet rs = stm.executeQuery(qry);
            while(rs.next()) {
                list.add(new reclamation(rs.getString("descr"), rs.getString("nomr"),rs.getString("type"),rs.getString("emailr"),rs.getString("traiter")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
                   

        return list;
  

 }
 
    public void supprimer(reclamation r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    


}


    
   
 
