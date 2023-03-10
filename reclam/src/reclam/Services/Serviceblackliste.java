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

public  class Serviceblackliste implements IService<blackliste>{
    Connection cnx;

    @Override
    public void add(blackliste b) {
         try {
        String qry ="INSERT INTO `blacklist`( `descb`, `nbrr`) VALUES ('"+b.getDescb()+"','"+b.getNbrr()+"')";
             System.out.println(qry);
      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }

    }

    public List<blackliste> afficher() {
        List<blackliste> blackliste = new ArrayList<>();
        try {
            String qry ="SELECT * FROM `blacklist` ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                blackliste B =new blackliste();
                B.setDescb(rs.getString("descb"));
                B.setNbrr(rs.getInt(3));
               
                blackliste.add(B);
            }
            return blackliste;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return blackliste;
        
    }

   
    
    
 public blackliste SelectOneblackliste(int nbrr){
        blackliste blacklist = new blackliste();
        String req = "SELECT * FROM `blacklist` where nbrr ="+nbrr;
        
        try {
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();

        ResultSet rs = stm.executeQuery(req);
            
            while(rs.next()){           
                 
                blacklist = new blackliste(rs.getString("descb"),rs.getInt("nbrr"));

            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ex.getMessage());
        }
        return blacklist;
    }

    /**
     *
     * @param b
     */
    @Override
    public void modifier(blackliste b) {

       try {
           String qry ="UPDATE blacklist SET `nbrr`='"+b.getNbrr()+"' WHERE descb = '"+b.getDescb()+"';";
            cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        }

    //@Override
    

    
    public void supprimer(String descb ) {
    
              try {
             
             String qry ="DELETE from `blacklist` where descb = '"+descb+"';";
      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }    
    }

    @Override

    public void supprimer(blackliste b) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ObservableList<blackliste> getblackliste() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    


    
   
  public ObservableList<blackliste> getDatablackliste() {
            ObservableList<blackliste> list = FXCollections.observableArrayList();
        try {
            String qry = "SELECT * FROM `blacklist` ";
           cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
             System.out.println(qry);
           
             ResultSet rs = stm.executeQuery(qry);
            while(rs.next()) {
                list.add(new blackliste( rs.getString("descb"),rs.getInt("nbrr")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
                   

        return list;
  

 }
public ObservableList<blackliste> getAllTrinbr() {
        ObservableList<blackliste> list = FXCollections.observableArrayList();
        try {
         //   String req = "Select * from espacetalent where roles like '%[]%' order by nom";
                String qry = "Select * from `blacklist`  order by nbrr";
                  System.out.println(qry);
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
            //    EspaceTalent u = new EspaceTalent(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("username"), rs.getString("email"), rs.getString("file"), rs.getInt("etat"), rs.getDate("created_at"));
             blackliste b = new blackliste(rs.getString(2), rs.getInt(3)); 
      
   
        list.add(b) ;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
}
    
    
    