/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlywork.GUI;

import GestionUser.Entities.Utilisateur;
import GestionUser.Services.ServiceUtilisateur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author bouchrit
 */
public class PostFrontController implements Initializable {

    @FXML
    private Label lbMesPoste;
    @FXML
    private Label lbNouveau;
    @FXML
    private Label lbRetour;
    @FXML
    private Pane pnNouveau;
    @FXML
    private Label lbTItreNouveau;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfDomaine;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfDescript;
    @FXML
    private ComboBox<?> tfCategorie;
    @FXML
    private Button btnAnuller;
    @FXML
    private Button btnConfModifier;
    @FXML
    private Button btnConfAjouter;
    @FXML
    private Label lbTItreUpdate;
    @FXML
    private Pane pnMesPostes;
    @FXML
    private Button BtnSignup;
    @FXML
    private VBox vboxDetail;
    @FXML
    private Label lbCategorie;
    @FXML
    private Label lbDescription;
    @FXML
    private Button btnSupprimer;
    @FXML
    private Button btnModifier;
    @FXML
    private Label lbidposte;
    @FXML
    private TextField TfEmail;
    @FXML
    private PasswordField TfPass;
    @FXML
    private TextField TfNum;
    @FXML
    private TextField TfRole;
    @FXML
    private TextField TfNom;
    @FXML
    private Button BtnSignup1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void fnMenuMesPostes(MouseEvent event) {
    }

    @FXML
    private void fnMenuNouveau(MouseEvent event) {
    }

    @FXML
    private void fnAnnuler(ActionEvent event) {
    }

    @FXML
    private void fnConfModifier(ActionEvent event) {
    }

    @FXML
    private void fnConfAjouter(ActionEvent event) {
    }

    @FXML
    private void Signup(ActionEvent event) {
         ServiceUtilisateur sp= new ServiceUtilisateur();
        Utilisateur p = new Utilisateur(TfNom.getText(),TfEmail.getText(),TfPass.getText(),Integer.parseInt(TfNum.getText()), TfRole.getText());
        sp.add(p);
    }

    @FXML
    private void fnSupprimer(ActionEvent event) {
    }

    @FXML
    private void fnModifier(ActionEvent event) {
    }
    
}
