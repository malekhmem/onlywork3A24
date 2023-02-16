/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evenement_societe;

import evenement_societe.Entities.evenement;
import evenement_societe.Entities.societe;

import evenement_societe.Services.ServiceEvenement;
import evenement_societe.Services.ServiceSociete;

import evenement_societe.Utiles.MyDB;

/**
 *
 * @author chino
 */
public class Evenement_societe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //     A a = A.getInstance();
//     A a1 =A.getInstance();
//        System.out.println(a.hashCode());
//        System.out.println(a1.hashCode());
//        MyDB a = MyDB.getInstance();
//        MyDB a1 = MyDB.getInstance();
//        System.out.println(a.hashCode());
//        System.out.println(a1.hashCode());

      evenement p = new evenement( 18,"mayasine", "hello mayasine hello");
      evenement p1 = new evenement( "mayasineee", "hmemmmm");
       societe s = new societe( 4,"hmdd", "mar7bee",222,"mt");
       societe s1 = new societe( "hello", "malek" ,54318456,"ariana");
       societe s2 = new societe( 3,"hhh", "hhh" ,215544,"ariana");

       //evenement p1 = new evenement( "zeineb", "hello zeineb hello");
      // evenement p2 = new evenement( "imtinen", "hello imtinen hello");


      //ServiceEvenement sp = new ServiceEvenement();
     // ServiceSociete sp = new ServiceSociete();

      // sp.add(p1);
      //sp.supprimer(12);
     // sp.modifier(p);
      //System.out.println( sp.afficher());
      
      
     //sp.add(s1);
      //sp.supprimer(5);
    // sp.modifier(s);
      System.out.println( sp.afficher());
      
      
      
    }
    
}
