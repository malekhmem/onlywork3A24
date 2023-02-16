/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlywork;

/**
 *
 * @author zeine
 */
import onlywork.Entities.prestataire;
import onlywork.Services.ServicePrestataire;
import onlywork.Entities.categorie;
import onlywork.Services.ServiceCategorie;
import onlywork.Utils.MyDB;
public class Onlywork {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         prestataire p = new prestataire(28,"test", "hello", "hahaha", "benkhalifa@gmail.com");
         categorie c = new categorie(3,"heey");
        ServicePrestataire sp = new ServicePrestataire();
        ServiceCategorie sc = new ServiceCategorie();
       // sp.add(p);
        sc.add(c);
      ////sp.modifier(p);
        //sp.supprimer(28);
        //System.out.println( sp.afficher());
       // sc.supprimer(2);
       // sc.modifier(c);
        System.out.println( sc.afficher());
    }
    
}
