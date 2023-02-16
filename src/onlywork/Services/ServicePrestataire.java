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
import onlywork.Entities.prestataire;
import onlywork.Utils.MyDB;

/**
 *
 * @author Mohamed
 */
public class ServicePrestataire implements IService<prestataire>{
    Connection cnx;

    @Override
    public void add(prestataire t) {
       try {
        String qry ="INSERT INTO `prestataire`( `nomp`, `domaine`, `descp`,`emailp` ) VALUES ('"+t.getNomp()+"','"+t.getDomaine()+"','"+t.getDescp()+"','"+t.getEmailp()+"')";
      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<prestataire> afficher() {
        List<prestataire> prestataires = new ArrayList<>();
        try {
            String qry ="SELECT * FROM `prestataire` ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                prestataire p =new prestataire();
                p.setIdp(rs.getInt(1));
                p.setNomp(rs.getString("nomp"));
                p.setDomaine(rs.getString(3));
                p.setDescp(rs.getString("descp"));
                p.setEmailp(rs.getString("emailp"));
                prestataires.add(p);
            }
            return prestataires;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return prestataires;
        
    }

   // @Override
    public void modifier(prestataire t) {
       
        try {
        String qry ="UPDATE prestataire SET `nomp`='" +t.getNomp()+"',`domaine`='"+t.getDomaine()+"',`descp`='"+ t.getDescp() +"',`emailp`='"+t.getEmailp()+"' where idp = " +t.getIdp()+ ";" ;
      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }

 
    public void supprimer(int idp) {
    try {
        String qry ="DELETE from prestataire where idp = "+idp+";";
       cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
   
}


