/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Annonces;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Entities.Evenement;
import Utiles.MyDB;
import com.google.zxing.qrcode.encoder.QRCode;
import com.sun.javafx.iio.ImageStorage.ImageType;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import net.glxn.qrgen.core.image.ImageType;
//import net.glxn.qrgen.javase.QRCode;

/**
 *
 * @author chino
 */
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author chino
 */
public class ServiceEvenement implements IService<Evenement>{
    Connection cnx;
    @Override
    
    public void add(Evenement t) {
        ServiceAnnonces an = new ServiceAnnonces();
        Annonces annonce = new Annonces();
        try { 
        //String qry ="INSERT INTO `evenement`( `titre`, `description`,`nomss` ,`ids`) VALUES ('"+t.getTitre()+"','"+t.getDescription()+"','"+t.getNomss()+"','"+t.getIds()+"')";
         String qry ="INSERT INTO `evenement`( `titre`, `description`,`nomss` ,`ids`) VALUES ('"+t.getTitre()+"','"+t.getDescription()+"','"+t.getNomss()+"','"+1+"')";
      cnx = MyDB.getInstance().getCnx();
            
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
           
             System.out.println(ex.getMessage());
        }
    
    }
   /* public void add(Evenement t, int c) {
    try {
        cnx = MyDB.getInstance().getCnx();
        String selectQuery = "SELECT ids, noms FROM annonces WHERE codes = ?";
        PreparedStatement selectStmt = cnx.prepareStatement(selectQuery);
        selectStmt.setInt(1, c);
        ResultSet rs = selectStmt.executeQuery();
        if (rs.next()) {
            int ids = rs.getInt("ids");
            String noms = rs.getString("noms");
            String insertQuery = "INSERT INTO evenement (titre, description, nomss, ids ) VALUES ( ?, ?, ?,?)";
            PreparedStatement insertStmt = cnx.prepareStatement(insertQuery);
            insertStmt.setString(1, t.getTitre());
            insertStmt.setString(2, t.getDescription());
            insertStmt.setString(3, noms);
            insertStmt.setInt(4, ids);
            insertStmt.executeUpdate();
            insertStmt.close();
        }
        else{
         System.out.println("Le code de l'annonce est invalide.");
        rs.close();
        selectStmt.close();
    }} catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
}*/


  
    
    @Override
    public List<Evenement> afficher() {
        List<Evenement> evenements = new ArrayList<>();
        ServiceAnnonces an= new  ServiceAnnonces();
        Annonces annonce = new Annonces();
      try {
            String qry ="SELECT * FROM `evenement` ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                Evenement p =new Evenement();
                p.setIde(rs.getInt("ide"));
                p.setTitre(rs.getString("titre"));
                p.setDescription(rs.getString("description"));
                p.setNomss(rs.getString("nomss"));

               Annonces tempAnnonces= an.SelectOneAnnonces(rs.getInt("ids"));
               p.setIds(rs.getInt("ids"));
                evenements.add(p);
                
            }
            return evenements;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return evenements;
        
    }


   // @Override
    public void modifier(Evenement t) {
 try {
            String qry ="UPDATE evenement SET `titre`='"+t.getTitre()+"',`description`='"+t.getDescription()+"',nomss='"+t.getNomss()+"' WHERE ide="+t.getIde()+";";    

            cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        }

    //@Override
    public void supprimer(int ide) {
try {
            String qry ="DELETE from evenement where ide = "+ide+";";
      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }    }
    
    
    public ObservableList<Evenement> searchByEvenement(String titre) throws SQLException{
        String qry="SELECT * FROM evenement where titre LIKE '%"+titre+"%'" ;
                  System.out.println(qry);
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
        ObservableList<Evenement>  list = FXCollections.observableArrayList()  ; 
        while(rs.next()){
        Evenement a = new Evenement(rs.getString(2), rs.getString(3),rs.getString(4)); 
        list.add(a) ;
        
        }
         

        return list ;
    }
    
   public ObservableList<Evenement> getAllTriTitre() {
        ObservableList<Evenement> list = FXCollections.observableArrayList();
        try {
         //   String req = "Select * from espacetalent where roles like '%[]%' order by nom";
                String qry = "Select * from evenement  order by titre";
                  System.out.println(qry);
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
            //    EspaceTalent u = new EspaceTalent(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("username"), rs.getString("email"), rs.getString("file"), rs.getInt("etat"), rs.getDate("created_at"));
        Evenement a = new Evenement(rs.getString(2), rs.getString(3),rs.getString(4)); 
      
   
        list.add(a) ;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }
    /*public String GenerateQrEvent(Evenement event) throws FileNotFoundException, IOException {

        String eventTitre = "evenement titre: " + event.getTitre() + "\n" + "evenement nom_societ: " + event.getDescription() + "\n" + "evenement nom_societe: " + event.getNomss() + "\n";
        ByteArrayOutputStream out = QRCode.from(eventTitre).to(ImageType.JPG).stream();
        String filename = event.getTitre() + "_QrCode.jpg";
        File f = new File("src\\tn\\esprit\\utils\\img\\" + filename);
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(out.toByteArray());
        fos.flush();
        System.out.println("qr yemshi");
        return filename;
    }
*/
    
}


