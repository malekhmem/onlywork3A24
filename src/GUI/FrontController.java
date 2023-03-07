/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author chino
 */
public class FrontController implements Initializable {
     @FXML
    private Button btnBack;
        public void ouvrirDeuxiemeInterface() throws IOException {
        Stage stage = new Stage();
        stage.show();}
         @FXML
    private Button btnAnnonces;
    @FXML
    private Button btnEvenement;

    AnchorPane GestionAnnonces;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void fnAnnonce(ActionEvent event) throws IOException {
               try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AnnoncesFront.fxml"));
            Parent root = loader.load();
            btnAnnonces.getScene().setRoot(root);
           } catch (IOException ex) {
               System.out.print(ex.getMessage());
        }
    }

    @FXML
    private void fnEvenement(ActionEvent event) {      
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EvenementFront.fxml"));
            Parent root = loader.load();
            btnAnnonces.getScene().setRoot(root);
           } catch (IOException ex) {
               System.out.print(ex.getMessage());
        }
    }

    @FXML
    private void fnBack(ActionEvent event) {
                try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("back1.fxml"));
            Parent root = loader.load();
            btnAnnonces.getScene().setRoot(root);
           } catch (IOException ex) {
               System.out.print(ex.getMessage());
        }
    }
    
}
