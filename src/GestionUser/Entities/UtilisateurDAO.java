/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionUser.Entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author bouchrit
 */
public class UtilisateurDAO {
    private Connection connexion;

    public UtilisateurDAO(Connection connexion) {
        this.connexion = connexion;
    }

    public Utilisateur findByEmail(String mailu) {
        PreparedStatement preparedStatement = null;
        ResultSet resultat = null;
        Utilisateur utilisateur = null;

        try {
            preparedStatement = connexion.prepareStatement("SELECT * FROM utilisateur WHERE mailu = ?");
            preparedStatement.setString(1, mailu);
            resultat = preparedStatement.executeQuery();

            if (resultat.next()) {
                utilisateur = new Utilisateur();
                utilisateur.setNomu(resultat.getString("nom"));
                utilisateur.setMailu(resultat.getString("email"));
                utilisateur.setMdp(resultat.getString("mdp"));
                utilisateur.setNumerou(resultat.getInt("num"));
                utilisateur.setRole(resultat.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultat != null) resultat.close();
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return utilisateur;
    }

    // Autres méthodes CRUD pour l'entité "Utilisateur"
    // ...
}
