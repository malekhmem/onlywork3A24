
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
import workshop3a24.Entities.reclamation;
import workshop3a24.Utils.MyDB;

/**
 *
 * @author Mohamed
 */
public  class Servicereclamation implements IService<reclamation>{
    Connection cnx;

    @Override
    public void add(reclamation r) {
         try {
        String qry ="INSERT INTO `reclamation`( `descr`,`nomr`, `emailr`,`type`) VALUES ('"+r.getdescr()+"','"+r.getNomr()+"','"+r.getemailr()+"','"+r.gettype()+"')";
      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }

    }

    public List<reclamation> afficher() {
        List<reclamation> reclamation = new ArrayList<>();
        try {
            String qry ="SELECT * FROM `reclamation` ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                reclamation R =new reclamation();
                R.setIdr(rs.getInt(1));
                R.setNomr(rs.getString("nomr"));
                R.setemailr(rs.getString(3));
                R.settype(rs.getString("type"));
                R.setdescr(rs.getString("descr"));

                reclamation.add(R);
            }
            return reclamation;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return reclamation;
        
    }

    public void modifier(reclamation r) {
       try {
           String qry ="UPDATE reclamation SET  `nom`='"+r.getNomr()+ "', `descr` ='" +r.getdescr()+ "', `type` ='"+r.gettype()+"', `emailr` = "+r.getemailr()+" WHERE idr = "+r.getIdr()+";";
            cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        }

    //@Override
    

    
    public void supprimer(int idr ) {
    
              try {
             
             String qry ="DELETE from reclamation where idr = "+idr+";";
      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }    }

    @Override
    public void supprimer(reclamation r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   

}

    
   
 
