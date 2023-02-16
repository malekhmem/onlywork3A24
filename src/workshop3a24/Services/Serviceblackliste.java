
package workshop3a24.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import workshop3a24.Entities.blackliste;
import workshop3a24.Utils.MyDB;

/**
 *
 * @author Mohamed
 */
public  class Serviceblackliste implements IService<blackliste>{
    Connection cnx;

    @Override
    public void add(blackliste b) {
         try {
        String qry ="INSERT INTO `blackliste`( `idb`, `descrb`, `nbrr`) VALUES ('"+b.getIdb()+"','"+b.getdescb()+"','"+b.getnbrr()+")";
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
            String qry ="SELECT * FROM `blackliste` ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                blackliste B =new blackliste();
                B.setidb(rs.getInt(1));
                B.setdescb(rs.getString("descb"));
                B.setnbrr(rs.getInt("nbrr"));
               

                blackliste.add(B);
            }
            return blackliste;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return blackliste;
        
    }

    public void modifier(blackliste b) {
       try {
           String qry ="UPDATE blackliste SET  `nbrr`='"+b.getnbrr()+ "', `descb` ='" +b.getdescb()+ " WHERE idb = "+b.getIdb()+";";
            cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        }

    //@Override
    

    
    public void supprimer(int idb ) {
    
              try {
             
             String qry ="DELETE from blackliste where idb = "+idb+";";
      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }    
    }

    @Override

    public void supprimer(blackliste b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }


    
   
 
