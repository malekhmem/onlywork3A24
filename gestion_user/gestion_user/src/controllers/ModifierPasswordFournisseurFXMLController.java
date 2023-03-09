/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import entities.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
public class ModifierPasswordFournisseurFXMLController implements Initializable {

    @FXML
    private TextField motdepasseTexte;
    @FXML
    private TextField nouveaumotdepasseTexte;
    @FXML
    private TextField confiramtiondumotdupasseTexte;

    /**
     * Initializes the controller class.
     */
    
        ServiceUtilisateurIMP su = new ServiceUtilisateurIMP();
    Utilisateur userConn = Utilisateur.user_connecter;
    String passcrypter = userConn.getPassword();
    String passDecrypter = su.decrypt(passcrypter);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ValiderChangementP(ActionEvent event) {
        
         if (passDecrypter.equals(motdepasseTexte.getText())) {
            if (nouveaumotdepasseTexte.getText().equals(confiramtiondumotdupasseTexte.getText())) {
                
                su.ChangerPassword(userConn.getId(), nouveaumotdepasseTexte.getText());
                   Alert resAlert = new Alert(Alert.AlertType.INFORMATION);
            resAlert.setHeaderText(null);
            resAlert.setContentText("votre  nouveau mot de passe a ete changer avec sucess");
            resAlert.showAndWait();
            changerPass();
                        

            } else {
                
                
                Alert resAlert = new Alert(Alert.AlertType.WARNING);
            resAlert.setHeaderText("Miss match");
            resAlert.setContentText("verfier votre  nouveau mot de passe");
            resAlert.showAndWait();
            }
            

        }else {
            Alert resAlert = new Alert(Alert.AlertType.WARNING);
            resAlert.setHeaderText("Erreur");
            resAlert.setContentText("votre mot de passe st incorrect");
            resAlert.showAndWait();
        }
    }
    
      public void changerPass(){
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/fournisseurfxml.fxml"));
            Parent root = loader.load();
            nouveaumotdepasseTexte.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());   
        }
        
    }

    @FXML
    private void retoureAction(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/fournisseurfxml.fxml"));
            Parent root = loader.load();
            nouveaumotdepasseTexte.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());   
        }
        
    }

    
}
