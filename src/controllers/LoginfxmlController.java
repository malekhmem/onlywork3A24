/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import entities.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import services.ServiceUtilisateurIMP;

/**
 * FXML Controller class
 *
 * @author chaker
 */
public class LoginfxmlController implements Initializable {

    @FXML
    private TextField LoginTexte;
    @FXML
    private TextField PasswordTexte;

    /**
     * Initializes the controller class.
     */
    ServiceUtilisateurIMP su = new ServiceUtilisateurIMP();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Login(ActionEvent event) {
        Utilisateur user = null;
        String encPass = su.encrypt(PasswordTexte.getText());
        if (su.Authentification(LoginTexte.getText(), encPass) != null) {

            System.out.println(encPass);
            user = su.Authentification(LoginTexte.getText(), encPass);
            Utilisateur.user_connecter = user;
            if (null != user.getRole()) {
                if (user.getEtat().equals("desactive")) {
                    Alert al = new Alert(Alert.AlertType.ERROR);
                    al.setTitle("Alert");
                    al.setContentText("Votre account est suspendue, Veuillez contacter l admininstrateur");
                    al.setHeaderText(null);
                    al.show();
                } else {
                    switch (user.getRole()) {
                        case "admin":
                            // go to admin
                            GoToAdminDashboard(event);
                            System.out.println("admin");
                            break;
                        case "fournisseur":
                            // go to prestatire
                            GoToFournisseurFML(event);
                            System.out.println("fournisseur");
                            break;
                        case "societer":
                            //go to fournisseur
                            // GoToAgencier(event);
                             GoToSociete(event);
                            System.out.println("societer");
                            break;
                        case "prestataire":
                            // go to prestataire
                            GoToPrestataire(event);
                            System.out.println("prestataire");
                            break;
                        default:
                            break;
                    }
                }
            }

        } else {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setTitle("Alert");
            al.setContentText("invalid login or mot de passe");
            al.setHeaderText(null);
            al.show();

        }

    }

    // check if the user is banned
    public Boolean Active_account() {
        Boolean verif = true;
        List<Utilisateur> list_user = su.afficherUtilisateur();
        for (int i = 0; i < list_user.size(); i++) {
            if (list_user.get(i).getLogin().equals(LoginTexte.getText())) {
                verif = false;

            }

        }
        if (verif == false) {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setTitle("Alert");
            al.setContentText("User login existe déja");
            al.setHeaderText(null);
            al.show();
        }

        return verif;
    }

    @FXML
    private void SignUpPage(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/signupfxml.fxml"));
            Parent root = loader.load();
            LoginTexte.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void goToPasswordReset(ActionEvent event) {
        if (null != su.FindByLogin(LoginTexte.getText())) {

            Utilisateur.user_connecter = su.FindByLogin(LoginTexte.getText());

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/modifierpasswordfxml.fxml"));
                Parent root = loader.load();
                LoginTexte.getScene().setRoot(root);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        } else {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setTitle("Alert");
            al.setContentText("invalid login");
            al.setHeaderText(null);
            al.show();
        }

    }

    private void GoToPrestataire(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/PostFront.fxml"));
            Parent root = loader.load();
            LoginTexte.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    private void GoToAdminDashboard(ActionEvent event) {

        try {
           // FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/AdminDashboardFXML.fxml"));
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/home.fxml"));
            Parent root = loader.load();
            LoginTexte.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void GoToFournisseurFML(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/front.fxml"));
            Parent root = loader.load();
            LoginTexte.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
      
    private void GoToSociete(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/front1.fxml"));
            Parent root = loader.load();
            LoginTexte.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void SignUpPageFournisseur(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/SignUpFournisseur.fxml"));
            Parent root = loader.load();
            LoginTexte.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void SignUpPageSocieter(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/SignUpSocieter.fxml"));
            Parent root = loader.load();
            LoginTexte.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
   
}
