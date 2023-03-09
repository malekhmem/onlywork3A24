/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author chaker
 */
public class Prestataire extends Utilisateur {

    public Prestataire() {
        super();
    }

    public Prestataire(String login, String password, String nom, String prenom, String email, int num_tel, String role, String etat) {
        super(login, password, nom, prenom, email, num_tel, role, etat);
    }

    @Override
    public String toString() {
        return "Prestataire{" + super.toString()
                + '}';
    }

}
