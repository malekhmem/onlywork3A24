/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlywork.GUI;



import GestionUser.Entities.UserSession;
import GestionUser.Entities.Utilisateur;
import GestionUser.Entities.UtilisateurDAO;
import GestionUser.Services.ServiceUtilisateur;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import GestionUser.Utils.MyDB;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert.AlertType;
import GestionUser.Entities.UtilisateurDAO;
import GestionUser.Entities.Role;
import GestionUser.Entities.UserSession;
import GestionUser.GUI.AdminController;
import GestionUser.GUI.FournisseurController;
import GestionUser.GUI.PrestataireController;
import GestionUser.GUI.SocieteController;

import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import GestionUser.home1;

/**

/**
 * FXML Controller class
 *
 * @author bouchrit
 *
 */

public class loginController implements Initializable {

    Connection mc;
    

    PreparedStatement ps;
    private Stage primaryStage;
    public loginController() {
         mc= MyDB.getInstance().getCnx();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

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
    
    public static  Utilisateur CurrentUser ;
    public loginController(Stage primaryStage) {
        this.primaryStage = primaryStage;}
    
    @FXML
    private void Signup(ActionEvent event) throws IOException, SQLException {
       TfEmail.setStyle(" -fx-border-color : white ; -fx-border-width :  0 0 2px 0 ; -fx-background-color :  transparent ; -fx-text-fill : white") ; 
       TfPass.setStyle(" -fx-border-color : white ; -fx-border-width :  0 0 2px 0 ; -fx-background-color :  transparent ; -fx-text-fill : white") ; 

       if(TfEmail.getText().equals("")||TfPass.getText().equals("")){
        Alert a = new Alert(Alert.AlertType.WARNING) ; 
        a.setContentText("Veuillez inserer votre email et votre mot de pass");
        a.showAndWait();
        if(TfEmail.getText().equals("")){
        TfEmail.setStyle("-fx-border-color : red ; -fx-border-width :  0 0 2px 0 ; -fx-background-color :  transparent ; -fx-text-fill : white ");
        }
        if(TfPass.getText().equals("")){
        TfPass.setStyle("-fx-border-color : red ; -fx-border-width :  0 0 2px 0 ; -fx-background-color :  transparent ; -fx-text-fill : white ");
        }
        }else{
        String email = TfEmail.getText() ; 
        String password = TfPass.getText() ;
        System.out.println(email+password);
            ServiceUtilisateur ServiceUtilisateur = new ServiceUtilisateur() ;

            Utilisateur u = ServiceUtilisateur.Authentification(email, password) ; 
            
            
            if(u==null){
            Alert a = new Alert(Alert.AlertType.WARNING) ; 
            a.setContentText("Email ou mot de passe incorrect");
            a.showAndWait();
            }
            else {
                CurrentUser = u ;
                
                
                
                if(u.getRole().equals("admin")){
       FXMLLoader loader = new FXMLLoader(getClass().getResource("../GestionUser/GUI/admin.fxml")) ; 
       loader.setController(new AdminController(primaryStage));
                
                AnchorPane root = loader.load();
        AdminController secondController = loader.getController() ;
        
        
        Scene scene = new Scene(root);
        primaryStage.setTitle("Accueil");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setMaximized(true); 
        }else if(u.getRole().equals("prestataire")){
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/GestionUser/GUI/prestataire.fxml")) ; 
       loader.setController(new PrestataireController(primaryStage));
                
                    BorderPane root = loader.load();
        PrestataireController secondController = loader.getController() ;
        
       // secondController.setLabelUserName(u.getNom()+" "+u.getPrenom(),u.getId());
        Scene scene = new Scene(root);
        primaryStage.setTitle("Accueil");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setMaximized(true); 
        }else if(u.getRole().equals("societe")){
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/GestionUser/GUI/societe.fxml")) ; 
       loader.setController(new SocieteController(primaryStage));
                
                BorderPane root = loader.load();
        SocieteController secondController = loader.getController() ;
        
        secondController.setLabelUserName(u.getNomu()+" "+u.getMailu(),u.getNumerou());
        Scene scene = new Scene(root);
        primaryStage.setTitle("Accueil");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setMaximized(true); 
        }else if(u.getRole().equals("fournisseur")){
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/GestionUser/GUI/fournisseur.fxml")) ; 
       loader.setController(new FournisseurController(primaryStage));
                
                AnchorPane root = loader.load();
        FournisseurController secondController = loader.getController() ;
        
        secondController.setLabelUserName(u.getNomu()+" "+u.getMailu(),u.getNomu());
        Scene scene = new Scene(root);
        primaryStage.setTitle("Accueil");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setMaximized(true); 
        }
        }
       } 
 

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


   /* @FXML
    private void Signup(ActionEvent event) throws SQLException {
    ServiceUtilisateur sp = new ServiceUtilisateur();
    Utilisateur utilisateur = sp.getUser(TfEmail.getText(), TfPass.getText());
    if (utilisateur != null) {
         //L'utilisateur existe dans la base de données, vous pouvez l'authentifier
        // et effectuer toutes les opérations nécessaires (par exemple, afficher le tableau de bord, etc.)
    } else {
        // L'utilisateur n'existe pas dans la base de données ou les informations d'identification sont incorrectes.
        // Vous pouvez afficher un message d'erreur ou effectuer une action en conséquence.
    }
}*/

    @FXML
    private void fnSupprimer(ActionEvent event) {
    }

    @FXML
    private void fnModifier(ActionEvent event) {
    }
    
}
