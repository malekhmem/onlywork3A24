/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entities.Materiel;
import Utils.MyDB;
import entities.Annoncef;


/**
 *
 * @author imtinen
 */
public class Servicemateriel implements IService<Materiel>{
    Connection cnx;
@Override
public void add(Materiel t) {
   
        Serviceannoncef sc= new  Serviceannoncef();
        Annoncef f = new Annoncef();
        try{
               String qry ="INSERT INTO `materiel`( `nomm`, `marque`, `descm`,`prix`,`idff`,`idu`) VALUES ('"+t.getNomm()+"','"+t.getMarque()+"','"+t.getDescm()+"','"+t.getPrix()+"','"+t.getAnnoncef().getIdf()+"','"+t.getIdu()+"')";
      cnx = MyDB.getInstance().getCnx();
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
        } 
catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
     
}



    @Override
    public List<Materiel> afficher() {
        List<Materiel> Materiel = new ArrayList<>();
        Serviceannoncef es= new  Serviceannoncef();
        Annoncef annoncef = new Annoncef();
        try {
            String qry ="SELECT * FROM `materiel` ";
            
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                Materiel m =new Materiel();
   
                m.setIdm(rs.getInt(1));
                m.setNomm(rs.getString("nomm"));
                m.setMarque(rs.getString("marque"));
                m.setPrix(rs.getString("prix"));
                m.setDescm(rs.getString("descm"));

                
                Annoncef tempf = es.SelectOneAnnoncef(rs.getInt("idff"));

                Materiel.add(m);
            }
            return Materiel;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Materiel;
        
    }

 
 public List<Materiel> afficherByID(int i) {
        List<Materiel> Materiel = new ArrayList<>();
         Serviceannoncef sc= new  Serviceannoncef();
        Materiel cat = new Materiel();
        try {
            String qry ="SELECT * FROM `materiel` where idu="+i+"";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                Materiel p =new Materiel();
               p.setIdm(rs.getInt(1));
                p.setNomm(rs.getString("nomm"));
                p.setMarque(rs.getString("marque"));
                p.setDescm(rs.getString("descm"));
                p.setPrix(rs.getString("prix"));
                Annoncef tempAnnoncef= sc.SelectOneAnnoncef(rs.getInt("idff"));
                p.setIdff(rs.getInt("idff"));
                p.setIdu(rs.getInt("idu"));

                Materiel.add(p);
            }
            return Materiel;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Materiel;
        
    }


    @Override
    public void modifier(Materiel t) {
            try {
        String qry ="UPDATE `materiel` SET `nomm`='"+t.getNomm()+"',`marque`='"+t.getMarque()+"',`prix`='"+t.getPrix()+"',`descm`='"+t.getDescm()+"' WHERE idm="+t.getIdm()+";";
        cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }

    
    public void supprimer(int idm) {
             try {
        String qry ="DELETE FROM `materiel` WHERE idm="+idm+";";
        cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }
   
}
