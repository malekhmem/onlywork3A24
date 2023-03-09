/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import java.util.List;

/**
 *
 * @author chaker
 */
public interface Iutilisateur<T> {

    public void ajoutUtilisateur(T t);

    public void modifierUtilisateur(T t, int id);

    public void supprimerUtilisateur(int id);

    public List<T> afficherUtilisateur();

    public List<T> afficherPrestataireList();

    public List<T> afficherFournisseurList();

}
