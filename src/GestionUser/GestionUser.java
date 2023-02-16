/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionUser;

import GestionUser.Entities.Utilisateur;
import GestionUser.Services.ServiceUtilisateur;
import GestionUser.Utils.MyDB;

/**
 *
 * @author Mohamed
 */
public class GestionUser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//     A a = A.getInstance();
//     A a1 =A.getInstance();
//        System.out.println(a.hashCode());
//        System.out.println(a1.hashCode());
//        MyDB a = MyDB.getInstance();
//        MyDB a1 = MyDB.getInstance();
//        System.out.println(a.hashCode());
//        System.out.println(a1.hashCode());

        Utilisateur p = new Utilisateur("amine", "amine@esprit.tn", "0000",22222222);
         Utilisateur p1 = new Utilisateur("ahmed", "ahmed@esprit.tn", "1111",9999999);
        ServiceUtilisateur sp = new ServiceUtilisateur();
        sp.add(p);
         sp.add(p1);
        System.out.println( sp.afficher());
       sp.modifier(p);
       sp.supprimer(p);
    }
    
}
