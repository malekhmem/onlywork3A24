
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
import java.sql.PreparedStatement;
import onlywork.GUI.loginController;
import GestionUser.Entities.Role;

/**
 *
 * @author Mohamed
 */
public class ServiceUtilisateur implements IService<Utilisateur>{
    PreparedStatement ste;
    
    ResultSet rs ; 
    
  Connection mc = MyDB.getInstance().getCnx();
      
    Connection cnx;
    @Override
    public void add(Utilisateur t) {
         try {
        String qry ="INSERT INTO `utilisateur`( `nomu`, `mailu`, `mdp`, `numerou`, `role`) VALUES ('"+t.getNomu()+"','"+t.getMailu()+"','"+t.getMdp()+"','"+t.getNumerou()+"','"+t.getRole()+"')";
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
                p.setRole(rs.getString(6));
                
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
        String qry = "UPDATE `utilisateur` SET `nomu`='" + t.getNomu() + "', `mailu`='" + t.getMailu() + "', `mdp`='" + t.getMdp() + "', `numerou`='" + t.getNumerou() + ", `role`='" + t.getRole() + "' WHERE idu='" + t.getIdu() + "'";

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
   

    
        public List<Utilisateur> FindUserByNameOrLastname(String name) throws SQLException{
        String requete="SELECT * FROM utilisateur where (nomu LIKE '%"+name+"%')" ;
        ste=(PreparedStatement) cnx.createStatement() ;
        rs=ste.executeQuery(requete);
        List<Utilisateur> list = new ArrayList<>() ; 
        while(rs.next()){
        
        Utilisateur m = new Utilisateur(rs.getString("nom"),rs.getString("mailu"),rs.getString("mdp"),rs.getInt("num"),rs.getString("role"));
        
        list.add(m) ;
        }
        return list ;
    }
        public  Utilisateur Authentification(String email , String password) throws SQLException{
                   

        String requete="SELECT * FROM utilisateur where mailu= ? AND mdp=?";
        
         ste= mc.prepareStatement(requete);
         ste.setNString(1, email);
         ste.setNString(2,password);
        ResultSet rs = ste.executeQuery();
        
        System.out.print(rs.toString());
      
        while(rs.next()){
        
        Utilisateur m = new Utilisateur(rs.getString("nomu"),rs.getString("mailu"),rs.getString("mdp"),rs.getInt("numerou"),rs.getString("role"));
        
        return m ;
        }
        return null ;
    
    }
     
     public Utilisateur FindByEmail(String email) throws SQLException{
        String requete="SELECT * FROM utilisateur where mailu='"+email+"'" ;
        ste=(PreparedStatement) cnx.createStatement() ;
        rs=ste.executeQuery(requete);
        
        while(rs.next()){
        
        Utilisateur m = new Utilisateur(rs.getString("nom"),rs.getString("mailu"),rs.getString("mdp"),rs.getInt("num"),rs.getString("role"));
        return m ;
        }
        return null ;
       
    }
}