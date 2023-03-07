/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import entities.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import services.ServiceUtilisateurIMP;

/**
 * FXML Controller class
 *
 * @author chaker
 */
public class PrestatairefxmlController implements Initializable {

    /**
     * Initializes the controller class.
     */
         ServiceUtilisateurIMP su = new ServiceUtilisateurIMP();
    Utilisateur userConn = Utilisateur.user_connecter;
    @FXML
    private TextField nomTexte;
    @FXML
    private TextField prenomTexte;
    @FXML
    private TextField numTexte;
    @FXML
    private TextField emailTexte;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nomTexte.setText(userConn.getNom());
        prenomTexte.setText(userConn.getPrenom());
        emailTexte.setText(userConn.getEmail());
        numTexte.setText(String.valueOf(userConn.getNum_tel()));
     
    }    

    @FXML
    private void updatePrestataire(ActionEvent event) {
        
         Utilisateur user = new Utilisateur();
        if (VerifUserChamps()  && validateNumberphone() && ValidateEmail()) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Demande de confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Est-ce que vous etes sur de votre modification");
            Optional<ButtonType> btn = alert.showAndWait();
            if (btn.get() == ButtonType.OK) {
                user.setLogin(userConn.getLogin());
                user.setPassword(userConn.getPassword());
               
                user.setRole(userConn.getRole());
               
                user.setEtat(userConn.getEtat());
               
                user.setNom(nomTexte.getText());
                user.setPrenom(prenomTexte.getText());
                user.setEmail(emailTexte.getText());
                user.setNum_tel(Integer.parseInt(numTexte.getText()));
                
          
                su.modifierUtilisateur(user, userConn.getId());

                Alert resAlert = new Alert(Alert.AlertType.INFORMATION);
                resAlert.setHeaderText(null);
                resAlert.setContentText("La modification a été effectuer avec succes");
                resAlert.showAndWait();
            } else {
                nomTexte.setText(userConn.getNom());
                prenomTexte.setText(userConn.getPrenom());
                emailTexte.setText(userConn.getEmail());
                numTexte.setText(String.valueOf((char) userConn.getNum_tel()));
                alert.close();
            }

        }
        
        
        
    }

    @FXML
    private void goToForgetPass(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/ModifierPasswordPrestatairefxml.fxml"));
            Parent root = loader.load();
            nomTexte.getScene().setRoot(root);
        } catch (IOException ex) {
             System.out.println(ex.getMessage());        }
        
    }

    @FXML
    private void logout(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/loginfxml.fxml"));
            Parent root = loader.load();
            nomTexte.getScene().setRoot(root);
        } catch (IOException ex) {
             System.out.println(ex.getMessage());        }
        
    }
    
    
    
    
      public boolean validateNumberphone() {

        Pattern p = Pattern.compile("[0-9]+\\.[0-9]+|[0-9]+");
        Matcher m = p.matcher(numTexte.getText());
        if (m.find() && m.group().equals(numTexte.getText()) && numTexte.getText().length() == 8) {
            return true;
        } else {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setTitle("Alert");
            al.setContentText("Phone number only can containes 8 didgets");
            al.setHeaderText(null);
            al.show();

        }
        return false;
    }
        public boolean ValidateEmail() {

        Pattern p = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\."
                + "[a-zA-Z0-9_+&*-]+)*@"
                + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$");
        Matcher m = p.matcher(emailTexte.getText());
        if (m.find() && m.group().equals(emailTexte.getText())) {
            return true;
        } else {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setTitle("Alert");
            al.setContentText("Email is wrong");
            al.setHeaderText(null);
            al.show();

        }
        return false;
    }
            public Boolean VerifUserChamps() {

        int verif = 0;

        String style = " -fx-border-color: red;";
        // i will make it better 


        if (nomTexte.getText().trim().equals("")) {
            nomTexte.setStyle(style);
            verif = 1;

        }
        if (prenomTexte.getText().trim().equals("")) {
            prenomTexte.setStyle(style);
            verif = 1;

        }
        if (emailTexte.getText().trim().equals("")) {
            emailTexte.setStyle(style);
            verif = 1;

        }
        if (numTexte.getText().trim().equals("")) {
            numTexte.setStyle(style);
            verif = 1;

        }


        if (verif == 0) {
            return true;
        }
        Alert al = new Alert(Alert.AlertType.ERROR);
        al.setTitle("Alert");
        al.setContentText("Verifier les champs");
        al.setHeaderText(null);
        al.show();

        return false;

    }
    
}
