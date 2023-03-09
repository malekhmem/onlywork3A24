/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.Parent;


/**
 * FXML Controller class
 *
 * @author bouchrit
 */
public class HomeController implements Initializable {

    @FXML
    private Button btnPoste;
    @FXML
    private Button btnUtilisateur;
    @FXML
    private Button btnmateriel;
    @FXML
    private Button btmalek;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void fnPoste(ActionEvent event) {
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PostBack.fxml"));
            Parent root = loader.load();
            btnPoste.getScene().setRoot(root);
           } catch (IOException ex) {
               System.out.print(ex.getMessage());
        }
    }

    @FXML
    private void fnUtilisateur(ActionEvent event) {
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminDashboardFXML.fxml"));
            Parent root = loader.load();
            btnUtilisateur.getScene().setRoot(root);
           } catch (IOException ex) {
               System.out.print(ex.getMessage());
        }
    }

    @FXML
    private void fnmateriel(ActionEvent event) {
                  try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("back.fxml"));
            Parent root = loader.load();
            btnUtilisateur.getScene().setRoot(root);
           } catch (IOException ex) {
               System.out.print(ex.getMessage());
        }
    }

    @FXML
    private void fnmalek(ActionEvent event) {
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("back1.fxml"));
            Parent root = loader.load();
            btnUtilisateur.getScene().setRoot(root);
           } catch (IOException ex) {
               System.out.print(ex.getMessage());
        }
    }
    
}
