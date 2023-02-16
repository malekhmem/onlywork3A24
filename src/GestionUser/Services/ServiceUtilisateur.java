
package GestionUser.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import GestionUser.Entities.Utilisateur;
import GestionUser.Utils.MyDB;

/**
 *
 * @author Mohamed
 */
public class ServiceUtilisateur implements IService<Utilisateur>{
    Connection cnx;
    @Override
    public void add(Utilisateur t) {
         try {
        String qry ="INSERT INTO `utilisateur`( `nomu`, `mailu`, `mdp`, `numerou`) VALUES ('"+t.getNomu()+"','"+t.getMailu()+"','"+t.getMdp()+"','"+t.getNumerou()+"')";
      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    
    }

    @Override
    public List<Utilisateur> afficher() {
        List<Utilisateur> personnes = new ArrayList<>();
        try {
            String qry ="SELECT * FROM `utilisateur` ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                Utilisateur p =new Utilisateur();
                p.setIdu(rs.getInt(1));
                p.setNomu(rs.getString("nomu"));
                p.setMailu(rs.getString(3));
                p.setMdp(rs.getString(4));
                p.setNumerou(rs.getInt(5));
                
                personnes.add(p);
            }
            return personnes;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return personnes;
        
    }

    @Override
    public void modifier(Utilisateur t) {
          try {
        String qry = "UPDATE `utilisateur` SET `nomu`='" + t.getNomu() + "', `mailu`='" + t.getMailu() + "', `mdp`='" + t.getMdp() + "', `numerou`='" + t.getNumerou() + "' WHERE idu='" + t.getIdu() + "'";

        cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
    }

    }    

    @Override
    public void supprimer(Utilisateur t) {
             try {
        String qry;
                 qry = "DELETE FROM `utilisateur` WHERE idu=''";
        cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }
   
}