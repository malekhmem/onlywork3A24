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

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author imtinen
 */
public class FrontController implements Initializable {

    @FXML
    private Button btnBack;
        public void ouvrirDeuxiemeInterface() throws IOException {
        Stage stage = new Stage();
        stage.show();
    }
    
    @FXML
    private Button btnAnnoncef;
    @FXML
    private Button btnMateriel;

    AnchorPane GestionAnnoncef;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {


    } 


    @FXML
    private void fnAnnonce(ActionEvent event) throws IOException {
               try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("frontannoncef.fxml"));
            Parent root = loader.load();
            btnAnnoncef.getScene().setRoot(root);
           } catch (IOException ex) {
               System.out.print(ex.getMessage());
        }
    }

    @FXML
    private void fnMaterieel(ActionEvent event) {      
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("frontmateriel.fxml"));
            Parent root = loader.load();
            btnAnnoncef.getScene().setRoot(root);
           } catch (IOException ex) {
               System.out.print(ex.getMessage());
        }
    }

    @FXML
    private void fnBack(ActionEvent event) {
                try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("back.fxml"));
            Parent root = loader.load();
            btnAnnoncef.getScene().setRoot(root);
           } catch (IOException ex) {
               System.out.print(ex.getMessage());
        }
    }
    
}