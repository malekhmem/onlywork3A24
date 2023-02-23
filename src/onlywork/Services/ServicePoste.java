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
import onlywork.Entities.Categorie;
import onlywork.Entities.Poste;
import onlywork.Utils.MyDB;

/**
 *
 * @author Mohamed
 */
public class ServicePoste implements IService<Poste>{
    Connection cnx;

    @Override
    public void add(Poste t) {
        ServiceCategorie sc= new  ServiceCategorie();
        Categorie cat = new Categorie();
       try {
        String qry ="INSERT INTO `poste`( `nomp`, `domaine`, `descp`,`emailp`,`idcc`,`idu`) VALUES ('"+t.getNomp()+"','"+t.getDomaine()+"','"+t.getDescp()+"','"+t.getEmailp()+"','"+t.getCategorie().getIdc()+"','"+t.getIdu()+"')";
      cnx = MyDB.getInstance().getCnx();
      /*Categorie tempCategorie = sc.SelectOneCategorie(t.getIdcc());
            System.out.println("before"+tempCategorie);
            sc.modifier(tempCategorie);
            int new_id=tempCategorie.getIdc();
            t.setCategorie(tempCategorie);
            System.out.println("after"+tempCategorie);*/
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Poste> afficher() {
        List<Poste> postes = new ArrayList<>();
         ServiceCategorie sc= new  ServiceCategorie();
        Categorie cat = new Categorie();
        try {
            String qry ="SELECT * FROM `poste` ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                Poste p =new Poste();
               p.setIdp(rs.getInt(1));
                p.setNomp(rs.getString("nomp"));
                p.setDomaine(rs.getString(3));
                p.setDescp(rs.getString("descp"));
                p.setEmailp(rs.getString("emailp"));
                Categorie tempCategorie= sc.SelectOneCategorie(rs.getInt("idcc"));
                p.setIdcc(rs.getInt("idcc"));

                postes.add(p);
            }
            return postes;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return postes;
        
    }
    
    public List<Poste> afficherByID(int i) {
        List<Poste> postes = new ArrayList<>();
         ServiceCategorie sc= new  ServiceCategorie();
        Categorie cat = new Categorie();
        try {
            String qry ="SELECT * FROM `poste` where idu="+i+"";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                Poste p =new Poste();
               p.setIdp(rs.getInt(1));
                p.setNomp(rs.getString("nomp"));
                p.setDomaine(rs.getString(3));
                p.setDescp(rs.getString("descp"));
                p.setEmailp(rs.getString("emailp"));
                Categorie tempCategorie= sc.SelectOneCategorie(rs.getInt("idcc"));
                p.setIdcc(rs.getInt("idcc"));
                p.setIdu(rs.getInt("idu"));

                postes.add(p);
            }
            return postes;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return postes;
        
    }

   // @Override
    public void modifier(Poste t) {
       
        try {
        String qry ="UPDATE poste SET `nomp`='" +t.getNomp()+"',`domaine`='"+t.getDomaine()+"',`descp`='"+ t.getDescp() +"',`emailp`='"+t.getEmailp()+"' where idp = " +t.getIdp()+ ";" ;
      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }

 
    public void supprimer(int idp) {
    try {
        String qry ="DELETE from poste where idp = "+idp+";";
       cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}


