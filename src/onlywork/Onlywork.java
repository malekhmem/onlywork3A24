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
import onlywork.Entities.Poste;
import onlywork.Services.ServicePoste;
import onlywork.Entities.Categorie;
import onlywork.Services.ServiceCategorie;
import onlywork.Utils.MyDB;
public class Onlywork {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                 Categorie c = new Categorie(4,"test");
                 Poste p = new Poste(32,23,"lllmmmmlll", "tttttt", "hahaha", "offf",c);
//Poste p = new Poste(29,"zeeeeineb", "hello", "hahaha", "benkhalifa@gmail.com");

        ServicePoste sp = new ServicePoste();
        ServiceCategorie sc = new ServiceCategorie();
       sp.add(p);
       // sc.add(c);
      //sp.modifier(p);
       //sp.supprimer(32);
       //System.out.println( sp.afficher());
        //sc.supprimer(20);
       // sc.modifier(c);
        //System.out.println( sc.afficher());
    }
    
}
