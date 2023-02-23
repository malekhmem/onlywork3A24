/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Entities.Annonces;
import Utiles.MyDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**s
 *
 * @author chino
 */
  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




public class ServiceAnnonces implements IService<Annonces> {


/**
 *
 * @author chino
 */
  Connection cnx;
    @Override
    
    public void add(Annonces t) {
        try {
        String qry ="INSERT INTO `annonces`( `noms`, `emails` ,`numeros`,`adresses`) VALUES ('"+t.getNoms()+"','"+t.getEmails()+"','"+t.getNumeros()+"','"+t.getAdresses()+"')";
     cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    
    }


    @Override
    public List<Annonces> afficher() {
        List<Annonces> Annoncess = new ArrayList<>();
      try {
            String qry ="SELECT * FROM `annonces` ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                Annonces p =new Annonces();
                p.setIds(rs.getInt(1));
                p.setNoms(rs.getString("noms"));
                p.setEmails(rs.getString(3));
                p.setNumeros(rs.getInt(4));
                p.setAdresses(rs.getString(5));

                Annoncess.add(p);

            }
            return Annoncess;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Annoncess;
        
    }
    
    
    public List<Annonces> afficherByID(int i) {
        List<Annonces> Annoncess = new ArrayList<>();
      try {
            String qry ="SELECT * FROM `annonces` where idu=" + i + "";

            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                Annonces p =new Annonces();
                p.setIds(rs.getInt(1));
                p.setNoms(rs.getString("noms"));
                p.setEmails(rs.getString(3));
                p.setNumeros(rs.getInt(4));
                p.setAdresses(rs.getString(5));
                p.setIdu(rs.getInt("idu"));
                Annoncess.add(p);

            }
            return Annoncess;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Annoncess;
        
    }
    
    
    
 public Annonces SelectOneAnnonces(int ids){
        Annonces annonce = new Annonces();
        String req = "SELECT * FROM `annonces` where ids ="+ids;
        
        try {
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();

        ResultSet rs = stm.executeQuery(req);
            
            while(rs.next()){           
                 
                annonce = new Annonces(rs.getInt("ids"), rs.getString("noms"), rs.getString("emails"),rs.getInt("numeros"), rs.getString("adresses"));

            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAnnonces .class.getName()).log(Level.SEVERE, null, ex);
        }
        return annonce;
    }

   // @Override
    public void modifier(Annonces t) {
 try {
            String qry ="UPDATE annonces SET `noms`='"+t.getNoms()+"',`emails`='"+t.getEmails()+"',`numeros`='"+t.getNumeros()+"',`adresses`='"+t.getAdresses()+"' WHERE ids="+t.getIds()+";";    
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
            String qry ="DELETE from annonces where ids = "+ids+";";
      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }    }
     
}
  

