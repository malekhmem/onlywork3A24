/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evenement_societe.Services;

import evenement_societe.Entities.societe;
import evenement_societe.Utiles.MyDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




/**
 *
 * @author chino
 */
public class ServiceSociete implements IService<societe>{  
  Connection cnx;
    @Override
    
    public void add(societe t) {
        try {
        String qry ="INSERT INTO `societe`( `noms`, `emails` ,`numeros`,`adresses`) VALUES ('"+t.getNoms()+"','"+t.getEmails()+"','"+t.getNumeros()+"','"+t.getAdresses()+"')";
      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    
    }


    @Override
    public List<societe> afficher() {
        List<societe> societes = new ArrayList<>();
      try {
            String qry ="SELECT * FROM `societe` ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                societe p =new societe();
                p.setIds(rs.getInt(1));
                p.setNoms(rs.getString("noms"));
                p.setEmails(rs.getString(3));
                p.setNumeros(rs.getInt(4));
                p.setAdresses(rs.getString(5));

                societes.add(p);

            }
            return societes;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return societes;
        
    }


   // @Override
    public void modifier(societe t) {
 try {
            String qry ="UPDATE societe SET `noms`='"+t.getNoms()+"',`emails`='"+t.getEmails()+"',`numeros`='"+t.getNumeros()+"',`adresses`='"+t.getAdresses()+"' WHERE ids="+t.getIds()+";";    
            cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        }

    //@Override
    public void supprimer(int ids) {
try {
            String qry ="DELETE from societe where ids = "+ids+";";
      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }    }
     
}
