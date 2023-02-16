/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlywork;
import entities.fournisseur;
import Services.Servicefournisseur;
import Utils.MyDB;
/**
 *
 * @author imtinen
 */

public class Onlywork {

    /**
     * @param args the command line arguments
     */
 
       public static void main(String[] args) {
        // TODO code application logic here
         fournisseur f = new fournisseur( "imtinen", "ariena", "imtinenabrougui@gmail.com","pc ASUS");
        Servicefournisseur sp = new Servicefournisseur();
       sp.add(f);
      System.out.println( sp.afficher());
       //sp.modifier(f);
      //sp.supprimer(f);
       
    }
}
