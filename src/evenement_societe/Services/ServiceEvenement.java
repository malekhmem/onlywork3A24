/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evenement_societe.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import evenement_societe.Entities.evenement;
import evenement_societe.Utiles.MyDB;

/**
 *
 * @author chino
 */
public class ServiceEvenement implements IService<evenement>{
    Connection cnx;
    @Override
    
    public void add(evenement t) {
        try {
        String qry ="INSERT INTO `evenement`( `titre`, `description`) VALUES ('"+t.getTitre()+"','"+t.getDescription()+"')";
      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    
    }


    @Override
    public List<evenement> afficher() {
        List<evenement> evenements = new ArrayList<>();
      try {
            String qry ="SELECT * FROM `evenement` ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                evenement p =new evenement();
                p.setIde(rs.getInt(1));
                p.setTitre(rs.getString("titre"));
                p.setDescription(rs.getString(3));
                evenements.add(p);
            }
            return evenements;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return evenements;
        
    }


   // @Override
    public void modifier(evenement t) {
 try {
            String qry ="UPDATE evenement SET `titre`='"+t.getTitre()+"',`description`='"+t.getDescription()+"' WHERE ide="+t.getIde()+";";    
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
