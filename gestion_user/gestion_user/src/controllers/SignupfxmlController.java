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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import services.ServiceUtilisateurIMP;

/**
 * FXML Controller class
 *
 * @author chaker
 */
public class SignupfxmlController implements Initializable {

    @FXML
    private TextField tf_login;
    @FXML
    private TextField tf_password;
    @FXML
    private TextField tf_nom;
    @FXML
    private TextField tf_prenom;
    @FXML
    private TextField tf_email;
    @FXML
    private TextField tf_numTel;
    @FXML
    private Button btn_register;

    /**
     * Initializes the controller class.
     */
        ServiceUtilisateurIMP su = new ServiceUtilisateurIMP();

        // service call
    ServiceUtilisateurIMP service_user = new ServiceUtilisateurIMP();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void RegisterAction(ActionEvent event) {
        
        Utilisateur user = new Utilisateur();

        if (CheckLogin() && VerifUserChamps() && validateNumberPhone()  && ValidateEmail()) {

            user.setLogin(tf_login.getText());
            user.setPassword(su.encrypt(tf_password.getText()));
            user.setNom(tf_nom.getText());
            user.setPrenom(tf_prenom.getText());
            user.setEmail(tf_email.getText());
            user.setNum_tel(Integer.parseInt(tf_numTel.getText()));
             user.setEtat("active");


         
            service_user.ajoutUtilisateur(user);
            Alert resAlert = new Alert(Alert.AlertType.INFORMATION);
            resAlert.setHeaderText(null);
            resAlert.setContentText("Account a ete cree avec sucess");
            resAlert.showAndWait();
            GoToLogin(event);

        }
        
        
        
    }
    
    
    
    
    
    public Boolean VerifUserChamps() {

        int verif = 0;

        String style = " -fx-border-color: red;";
        // i will make it better 
        if (tf_login.getText().trim().equals("")) {
            tf_login.setStyle(style);
            verif = 1;

        }
        if (tf_password.getText().trim().equals("")) {
            tf_password.setStyle(style);
            verif = 1;

        }
        if (tf_nom.getText().trim().equals("")) {
            tf_nom.setStyle(style);
            verif = 1;

        }
        if (tf_prenom.getText().trim().equals("")) {
            tf_prenom.setStyle(style);
            verif = 1;

        }
        if (tf_email.getText().trim().equals("")) {
            tf_email.setStyle(style);
            verif = 1;

        }
        if (tf_numTel.getText().trim().equals("")) {
            tf_numTel.setStyle(style);
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
    
        public Boolean CheckLogin() {
        Boolean verif = true;
        List<Utilisateur> list_user = service_user.afficherUtilisateur();
        for (int i = 0; i < list_user.size(); i++) {
            if (list_user.get(i).getLogin().equals(tf_login.getText())) {
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
        
        public boolean validateNumberPhone() {

        Pattern p = Pattern.compile("[0-9]+\\.[0-9]+|[0-9]+");
        Matcher m = p.matcher(tf_numTel.getText());
        if (m.find() && m.group().equals(tf_numTel.getText()) && tf_numTel.getText().length() == 8) {
            return true;
        } else {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setTitle("Alert");
            al.setContentText("cin only can containes 8 didgets");
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
        Matcher m = p.matcher(tf_email.getText());
        if (m.find() && m.group().equals(tf_email.getText())) {
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
          
         
    private void GoToLogin(ActionEvent event) {

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/loginfxml.fxml"));
            Parent root = loader.load();
            tf_email.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());      
        }

    }

    @FXML
    private void retoureAction(ActionEvent event) {
         try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/loginfxml.fxml"));
            Parent root = loader.load();
            tf_email.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());      
        }
    }
    
}
