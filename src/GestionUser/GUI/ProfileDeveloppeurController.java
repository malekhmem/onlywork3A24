/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionUser.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import GestionUser.Entities.Utilisateur;
import GestionUser.Entities.UserSession;
import GestionUser.Services.ServiceUtilisateur;

/**
 * FXML Controller class
 *
 * @author eya
 */
public class ProfileDeveloppeurController implements Initializable {

    @FXML
    private Button btn_Acceuil;
    @FXML
    private Button btn_Messagerie;
    @FXML
    private Button btn_Profile;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btn_listOffre;
    @FXML
    private Button btnSettings;
    @FXML
    private Button btnSignout;
    @FXML
    private Pane pnlCustomer;
    @FXML
    private Pane pnlOrders;
    @FXML
    private Pane pnlMenus;
    @FXML
    private Pane pnlOverview;
    @FXML
    private Label LabelName;
    @FXML
    private Label LabelExperience;
    @FXML
    private Label LabelEducation;
    @FXML
    private Label LabelSpecialite;
    
    ServiceUtilisateur ds= new ServiceUtilisateur();
   // Utilisateur d= ds.getUserName(UserSession.userName);
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
    }    
    
}
