/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entities.Materiel;
import utils.MyDB;
import entities.Annoncef;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import java.util.UUID;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;


/**
 *
 * @author imtinen
 */
public class Servicemateriel implements IService<Materiel>{
    Connection cnx;
    private static final String IMAGES_DIRECTORY = "images/";
@Override
public void add(Materiel t) {
   
        Serviceannoncef sc= new  Serviceannoncef();
        Annoncef f = new Annoncef();
        try{
               String qry ="INSERT INTO `materiel`( `nomm`, `marque`, `descm`,`prix`,`idff`,`idu`,`image`) VALUES ('"+t.getNomm()+"','"+t.getMarque()+"','"+t.getDescm()+"','"+t.getPrix()+"','"+t.getAnnoncef().getIdf()+"','"+t.getIdu()+"','"+t.getImage()+"')";
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
                m.setImage(rs.getString("image"));

                
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
                p.setImage(rs.getString("image"));

                Materiel.add(p);
            }
            return Materiel;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Materiel;
        
    }



    public void modifier(Materiel t) {
            try {
        String qry ="UPDATE `materiel` SET `nomm`='"+t.getNomm()+"',`marque`='"+t.getMarque()+"',`prix`='"+t.getPrix()+"',`descm`='"+t.getDescm()+"',`image`='"+t.getImage()+"' WHERE idm="+t.getIdm()+";";
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
    public ObservableList<Materiel> searchByMarqueMateriel(String marq) throws SQLException{
        String qry="SELECT * FROM materiel where marque LIKE '%"+marq+"%'";
         System.out.println(qry);
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
        ObservableList<Materiel>  list = FXCollections.observableArrayList()  ; 
        while(rs.next()){
        Materiel m = new Materiel(rs.getString(4), rs.getString(2), rs.getString(3),rs.getString(5));     
        list.add(m) ;
        
        }
         

        return list ;
    }
 


}