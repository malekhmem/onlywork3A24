/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import entities.Annoncef;
import entities.Materiel;
import Services.Servicemateriel;
import Utils.MyDB;

/**
 *
 * @author imtinen
 */
public class Serviceannoncef implements IService<Annoncef>{
    Connection cnx;

    @Override
    public void add(Annoncef t) {
       try {
        String qry ="INSERT INTO `annoncef`( `nomf`, `adresse`, `emailf`,`descf`,`idu` ) VALUES ('"+t.getNomf()+"','"+t.getAdresse()+"','"+t.getEmailf()+"','"+t.getDescf()+"','"+t.getIdu()+"')";
      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }
    public Annoncef SelectOneAnnoncef(int idff){
        Annoncef f = new Annoncef();
        String qry = "SELECT * FROM annoncef where idf ="+idff+";";
        
        try {
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();

        ResultSet rs = stm.executeQuery(qry);
            
            while(rs.next()){           
                 
                f = new Annoncef(rs.getInt("idf"), rs.getString("nomf"), rs.getString("adresse"),rs.getString("emailf"),rs.getString("descf"));

            } 
            
        } catch (SQLException ex) {
            Logger.getLogger(Serviceannoncef .class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
    }
        public List<Annoncef> afficherByID(int i) {
        List<Annoncef> Annoncef = new ArrayList<>();
        try {
            String qry ="SELECT * FROM `annoncef` where idu="+i+";";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                Annoncef f =new Annoncef();
               f.setIdf(rs.getInt(1));
                f.setNomf(rs.getString(2));
                f.setAdresse(rs.getString(3));
                f.setEmailf(rs.getString(4));
                f.setDescf(rs.getString(5));
              

               Annoncef.add(f);
            }
            return Annoncef;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Annoncef;
        
    }
       public List<String> afficherNom(int i) {
        List<String> Annoncef = new ArrayList<>();
        try {
            String qry ="SELECT nomf FROM `annoncef` where idu="+i+";";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                Annoncef c =new Annoncef();
                c.setNomf(rs.getString("nomf"));
            
               
                Annoncef.add(c.getNomf());
            }
            return Annoncef;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Annoncef;

    }
        public Annoncef SelectOneAnnoncefByNom(String nom){
    Annoncef f = new Annoncef();
        try {
           String req = "SELECT * FROM annoncef where nomf='"+nom+"'";
          System.out.println(req);
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);
            
            while(rs.next()){           
                 
                f = new Annoncef(rs.getInt("idf"), rs.getString("nomf"));

            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Serviceannoncef .class.getName()).log(Level.SEVERE, null, ex);
        }
        return f;
    }
    @Override
    public List<Annoncef> afficher() {
        List<Annoncef> Annoncef = new ArrayList<>();
        try {
            String qry ="SELECT * FROM `annoncef` ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                Annoncef f =new Annoncef();
                f.setIdf(rs.getInt(1));
                f.setNomf(rs.getString(2));
                f.setAdresse(rs.getString(3));
                f.setEmailf(rs.getString(4));
                f.setDescf(rs.getString(5));
             
                Annoncef.add(f);
            }
            return Annoncef;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Annoncef;
        
    }

 

   
    @Override
    public void modifier(Annoncef t) {
            try {
        String qry ="UPDATE `annoncef` SET `nomf`='"+t.getNomf()+"',`adresse`='"+t.getAdresse()+"',`emailf`='"+t.getEmailf()+"',`descf`='"+t.getDescf()+"' WHERE idf="+t.getIdf()+";";

       cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }

    
    public void supprimer(int idf) {
             try {
        String qry ="DELETE FROM `annoncef` WHERE idf="+idf+";";
        cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }
   
}