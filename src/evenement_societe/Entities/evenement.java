/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evenement_societe.Entities;

/**
 *
 * @author chino
 */
public class evenement {  

    private int ide ;
    private String titre,description;

    public evenement() {
        
    }

    public evenement( int ide ,String titre, String description) {
        this.ide=ide;
        this.titre = titre;
        this.description = description;
    }
     public evenement( String titre, String description) {
        
        this.titre = titre;
        this.description = description;
    }

   
    public int getIde() {
        return ide;
    }

    public void setIde(int ide) {
        this.ide = ide;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "evenement{" + "ide=" + ide + ", titre=" + titre + ", description=" + description + '}';
    }
    
}
