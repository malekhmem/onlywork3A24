/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlywork.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import onlywork.Entities.categorie;

import onlywork.Utils.MyDB;


/**
 *
 * @author zeine
 */
public class ServiceCategorie implements IService<categorie>{
    Connection cnx;

    @Override
    public void add(categorie t) {
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
    public List<categorie> afficher() {
        List<categorie> categories = new ArrayList<>();
        try {
            String qry ="SELECT * FROM `categorie` ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                categorie c =new categorie();
                c.setIdc(rs.getInt(1));
                c.setNomc(rs.getString("nomc"));
            
               
                categories.add(c);
            }
            return categories;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return categories;

    }
     public void modifier(categorie t) {
       
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
        String qry ="DELETE from categorie where idc = "+idc+";";
       cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

