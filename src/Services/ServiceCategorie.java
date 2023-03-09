/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import entities.Categorie;

import utils.MyD;
import utils.MyDB;


/**
 *
 * @author zeine
 */
public class ServiceCategorie implements IService<Categorie>{
    Connection cnx;

    @Override
    public void add(Categorie t) {
        try {
        String qry ="INSERT INTO `categorie`( `nomc` ) VALUES ('"+t.getNomc()+"')";
      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Categorie> afficher() {
        List<Categorie> categories = new ArrayList<>();
        try {
            String qry ="SELECT * FROM `categorie` ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                Categorie c =new Categorie();
                c.setIdc(rs.getInt("idc"));
                c.setNomc(rs.getString("nomc"));
            
               
                categories.add(c);
            }
            return categories;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return categories;

    }
    
    
    public List<String> afficherNom() {
        List<String> categories = new ArrayList<>();
        try {
            String qry ="SELECT nomc FROM `categorie` ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                Categorie c =new Categorie();
                c.setNomc(rs.getString("nomc"));
            
               
                categories.add(c.getNomc());
            }
            return categories;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return categories;

    }
     public void modifier(Categorie t) {
       
        try {
           
        String qry ="UPDATE categorie SET `nomc`='" +t.getNomc()+"' where idc = " +t.getIdc()+ ";" ;
      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }
      public void supprimer(int idc) {
    try {
        System.out.println(idc);
        String qry ="DELETE from categorie where idc = "+idc+";";
       cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
      public Categorie SelectOneCategorie(int idcc){
        Categorie cat = new Categorie();
        String req = "SELECT * FROM categorie where idc ="+idcc;
        
        try {
            //PreparedStatement ps = cnx.prepareStatement(req);

        //ResultSet rs = ps.executeQuery(req);
         
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);
            
            while(rs.next()){           
                 
                cat = new Categorie(rs.getInt("idc"), rs.getString("nomc"));

            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCategorie .class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
      
      public Categorie SelectOneCategorieByNom(String nom){
        Categorie cat = new Categorie();
        String req = "SELECT * FROM categorie where nomc='"+nom+"'";
          System.out.println(req);
        try {
            //PreparedStatement ps = cnx.prepareStatement(req);

        //ResultSet rs = ps.executeQuery(req);
         
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);
            
            while(rs.next()){           
                 
                cat = new Categorie(rs.getInt("idc"), rs.getString("nomc"));

            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCategorie .class.getName()).log(Level.SEVERE, null, ex);
        }
        return cat;
    }
}

