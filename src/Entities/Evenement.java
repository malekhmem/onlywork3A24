/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author chino
 */
public class Evenement {  

    private int ide ;
    public  Annonces annonces;
    private String titre,description,nomss;
        private int ids ;


    public Evenement() {
        
    }

    public Evenement(Annonces annonces, String titre, String description, String nomss, int ids) {
        this.annonces = annonces;
        this.titre = titre;
        this.description = description;
        this.nomss = nomss;
        this.ids = ids;
    }

    public Evenement(String titre, String description) {
        this.titre = titre;
        this.description = description;
    }

    public Evenement(int ide, Annonces annonces, String titre, String description, String nomss, int ids) {
        this.ide = ide;
        this.annonces = annonces;
        this.titre = titre;
        this.description = description;
        this.nomss = nomss;
        this.ids = ids;
    }

    public int getIde() {
        return ide;
    }

    public Annonces getAnnonces() {
        return annonces;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public String getNomss() {
        return nomss;
    }

    public int getIds() {
        return ids;
    }

    public void setIde(int ide) {
        this.ide = ide;
    }

    public void setAnnonces(Annonces annonces) {
        this.annonces = annonces;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNomss(String nomss) {
        this.nomss = nomss;
    }

    public void setIds(int ids) {
        this.ids = ids;
    }

 
   
   
   
    @Override
    public String toString() {
        return "Evenement{" + "ide=" + ide + ", annonces=" + annonces + ", titre=" + titre + ", description=" + description + ", nomss=" + nomss + ", ids=" + ids + '}';
    }

   

    

    
    
}
