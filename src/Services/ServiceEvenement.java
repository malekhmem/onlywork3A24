/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Annonces;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Entities.Evenement;

import Utiles.MyDB;
import java.sql.PreparedStatement;

/**
 *
 * @author chino
 */
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author chino
 */
public class ServiceEvenement implements IService<Evenement>{
    Connection cnx;
    @Override
    
    public void add(Evenement t) {
        ServiceAnnonces an = new ServiceAnnonces();
        Annonces annonce = new Annonces();
        try { 
        String qry ="INSERT INTO `evenement`( `titre`, `description`,`nomss` ,`ids`) VALUES ('"+t.getTitre()+"','"+t.getDescription()+"','"+t.getNomss()+"','"+1+"')";
      cnx = MyDB.getInstance().getCnx();
            
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
           
             System.out.println(ex.getMessage());
        }
    
    }
   /* public void add(Evenement t, int c) {
    try {
        cnx = MyDB.getInstance().getCnx();
        String selectQuery = "SELECT ids, noms FROM annonces WHERE codes = ?";
        PreparedStatement selectStmt = cnx.prepareStatement(selectQuery);
        selectStmt.setInt(1, c);
        ResultSet rs = selectStmt.executeQuery();
        if (rs.next()) {
            int ids = rs.getInt("ids");
            String noms = rs.getString("noms");
            String insertQuery = "INSERT INTO evenement (titre, description, nomss, ids ) VALUES ( ?, ?, ?,?)";
            PreparedStatement insertStmt = cnx.prepareStatement(insertQuery);
            insertStmt.setString(1, t.getTitre());
            insertStmt.setString(2, t.getDescription());
            insertStmt.setString(3, noms);
            insertStmt.setInt(4, ids);
            insertStmt.executeUpdate();
            insertStmt.close();
        }
        else{
         System.out.println("Le code de l'annonce est invalide.");
        rs.close();
        selectStmt.close();
    }} catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
}*/


  
    
    @Override
    public List<Evenement> afficher() {
        List<Evenement> evenements = new ArrayList<>();
        ServiceAnnonces an= new  ServiceAnnonces();
        Annonces annonce = new Annonces();
      try {
            String qry ="SELECT * FROM `evenement` ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                Evenement p =new Evenement();
                p.setIde(rs.getInt("ide"));
                p.setTitre(rs.getString("titre"));
                p.setDescription(rs.getString("description"));
                p.setNomss(rs.getString("nomss"));

               Annonces tempAnnonces= an.SelectOneAnnonces(rs.getInt("ids"));
               p.setIds(rs.getInt("ids"));
                evenements.add(p);
                
            }
            return evenements;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return evenements;
        
    }


   // @Override
    public void modifier(Evenement t) {
 try {
            String qry ="UPDATE evenement SET `titre`='"+t.getTitre()+"',`description`='"+t.getDescription()+"',nomss='"+t.getNomss()+"' WHERE ide="+t.getIde()+";";    

            cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        }

    //@Override
    public void supprimer(int ide) {
try {
            String qry ="DELETE from evenement where ide = "+ide+";";
      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }    }
   
}


