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
import entities.fournisseur;
import Utils.MyDB;

/**
 *
 * @author imtinen
 */
public class Servicefournisseur implements IService<fournisseur>{
    Connection cnx;

    @Override
    public void add(fournisseur t) {
       try {
        String qry ="INSERT INTO `fournisseur`( `nomf`, `adresse`, `emailf`,`nomma` ) VALUES ('"+t.getNomf()+"','"+t.getAdresse()+"','"+t.getEmailf()+"','"+t.getNomma()+"')";
      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<fournisseur> afficher() {
        List<fournisseur> fournisseur = new ArrayList<>();
        try {
            String qry ="SELECT * FROM `fournisseur` ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                fournisseur f =new fournisseur();
                f.setIdf(rs.getInt(1));
                f.setNomf(rs.getString(2));
                f.setAdresse(rs.getString(3));
                f.setEmailf(rs.getString(4));
                f.setNomma(rs.getString(5));
                fournisseur.add(f);
            }
            return fournisseur;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return fournisseur;
        
    }

 

    @Override
    public void modifier(fournisseur t) {
            try {
        String qry ="UPDATE `fournisseur` SET `nomf`='"+t.getNomf()+"',`adresse`='"+t.getAdresse()+"',`emailf`='"+t.getEmailf()+"',`nomma`='"+t.getNomma()+"'' WHERE idf=''";
        cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(fournisseur t) {
             try {
        String qry ="DELETE FROM `fournisseur` WHERE idf=''";
        cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }
   
}