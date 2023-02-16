/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24;

import workshop3a24.Entities.blackliste;
import workshop3a24.Entities.reclamation;

import workshop3a24.Services.Serviceblackliste;
import workshop3a24.Services.Servicereclamation;


/**
 *
 * @author houssem
 */
public class reclam_blackliste {

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

      reclamation r = new reclamation( "test", "houssem","houssem@email.com","traiter");
      reclamation R = new reclamation( "test", "houssem","houssem@email.com","traiter");
        
      
      
      /* blackliste b = new blackliste( 52,4,"test");
       blackliste B = new blackliste( 5, "test2"); */
      

       Servicereclamation sr = new Servicereclamation();
       sr.add(r);
        Serviceblackliste sb= new Serviceblackliste();
        
        System.out.println( sr.afficher());
      
      
      
    }
    
}

