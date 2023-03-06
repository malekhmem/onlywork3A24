/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author imtinen
 */


public class Materiel {
     Annoncef Annoncef;
    int idm,idff,idu;
    String nomm,marque,descm,prix,image;
    public Materiel(){}

    public Materiel( int idm, String prix, String nomm, String marque, String descm) {

        this.idm = idm;
        this.prix = prix;
       
        this.nomm = nomm;
        this.marque = marque;
        this.descm = descm;
 
     
    }

    public Materiel( int idm ,String nomm, int idff,  String marque,String descm,String prix,Annoncef Annoncef,String image) {
        this.idm=idm;
        this.Annoncef = Annoncef;
        this.prix = prix;
        this.idff = idff;
        this.nomm = nomm;
        this.marque = marque;
        this.descm = descm;
        this.image = image;
            
    }

    public Annoncef getAnnoncef() {
        return Annoncef;
    }

    public void setAnnoncef(Annoncef Annoncef) {
        this.Annoncef = Annoncef;
    }
    

 public Materiel( String prix, String nomm, String marque, String descm) {

       
        this.prix = prix;
       
        this.nomm = nomm;
        this.marque = marque;
        this.descm = descm;
 
     
    }

    public int getIdu() {
        return idu;
    }

    public void setIdu(int idu) {
        this.idu = idu;
    }

 

    public int getIdm() {
        return idm;
    }

    public String getMarque() {
        return marque;
    }

    public String getNomm() {
        return nomm;
    }

    public void setIdm(int idm) {
        this.idm = idm;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setNomm(String nomm) {
        this.nomm = nomm;
        
    }

    public String getPrix() {
        return prix;
    }

    public String getDescm() {
        return descm;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public void setDescm(String descm) {
        this.descm = descm;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    

    public int getIdff() {
        return idff;
    }

    public void setIdff(int idff) {
        this.idff = idff;
    }

    @Override
    public String toString() {
        return "Materiel{" + "idm=" + idm + ", prix=" + prix + ", nomm=" + nomm + ", marque=" + marque + '}';
    }


 



    

  


    
    
   
    
 

    
    
    
    
}
