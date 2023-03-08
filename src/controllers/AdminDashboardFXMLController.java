/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import entities.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import services.ServiceUtilisateurIMP;
import utils.MailTools;

/**
 * FXML Controller class
 *
 * @author chaker
 */
public class AdminDashboardFXMLController implements Initializable {

    @FXML
    private TableView<Utilisateur> tableView_user;
    @FXML
    private TableColumn<Utilisateur, String> nom;
    @FXML
    private TableColumn<Utilisateur, String> prenom;
    @FXML
    private TableColumn<Utilisateur, String> email;
    @FXML
    private TableColumn<Utilisateur, Integer> phone;
    @FXML
    private TableColumn<Utilisateur, String> etatTexte;
    @FXML
    private TextField nomTexte;
    @FXML
    private TextField prenomTexte;
    @FXML
    private TextField numTexte;
    @FXML
    private TextField emailTexte;
    @FXML
    private ChoiceBox<String> ChoiceBox;
    @FXML
    private TextField setPromptText;

    /**
     * Initializes the controller class.
     */
    ServiceUtilisateurIMP su = new ServiceUtilisateurIMP();
    Utilisateur userConn = Utilisateur.user_connecter;
    @FXML
    private Button lbRetour;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nomTexte.setText(userConn.getNom());
        prenomTexte.setText(userConn.getPrenom());
        emailTexte.setText(userConn.getEmail());
        numTexte.setText(String.valueOf(userConn.getNum_tel()));
        
         ChoiceBox.getItems().addAll("Nom", "Email", "Role", "Prenom");
        ChoiceBox.setValue("Nom");
        setPromptText.setPromptText("Rechercher ");
        
        afficheTableView();
        filteredSearch();
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

//        if (passwordTexte.getText().trim().equals("")) {
//            passwordTexte.setStyle(style);
//            verif = 1;
//
//        }
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

    private void afficheTableView() {
        List users = su.afficherUtilisateur();
        users.addAll(su.afficherUtilisateur());
        ObservableList list = FXCollections.observableArrayList(users);
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        phone.setCellValueFactory(new PropertyValueFactory<>("num_tel"));
        etatTexte.setCellValueFactory(new PropertyValueFactory<>("etat"));

        tableView_user.setItems(list);

    }
    
    
    public void filteredSearch() {

        List<Utilisateur> list_user = su.afficherUtilisateur();
        ObservableList<Utilisateur> list = FXCollections.observableArrayList(list_user);
        FilteredList<Utilisateur> flProduit = new FilteredList(list, p -> true);
        setPromptText.textProperty().addListener((obs, oldValue, newValue) -> {
            switch (ChoiceBox.getValue()) {
                case "Nom":
                    flProduit.setPredicate(p -> p.getNom().toLowerCase().contains(newValue.toLowerCase().trim()));
                    break;
                case "Email":
                    flProduit.setPredicate(p -> p.getEmail().toLowerCase().contains(newValue.toLowerCase().trim()));
                    break;
                case "Role":
                    flProduit.setPredicate(p -> p.getRole().toLowerCase().contains(newValue.toLowerCase().trim()));
                    break;
                case "Prenom":
                    flProduit.setPredicate(p -> p.getPrenom().toLowerCase().contains(newValue.toLowerCase().trim()));
                    break;
            }

        });
        tableView_user.setItems(flProduit);
        ChoiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal)
                -> {
            if (newVal != null) {
                setPromptText.setText("");
            }
        });

    }

    @FXML
    private void changerEtat(ActionEvent event) {
         Utilisateur user = tableView_user.getSelectionModel().getSelectedItem();
        if (user == null) {
            Alert al = new Alert(Alert.AlertType.WARNING);
            al.setTitle("Warning");
            al.setContentText("Selctionner un ustilisateur");
            al.setHeaderText(null);
            al.show();
        } else if (user.getEtat().equals("active")) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Demande de confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Est-ce que vous etes sure de votre supspension ");
            Optional<ButtonType> btn = alert.showAndWait();
            if (btn.get() == ButtonType.OK) {
                su.DescativerUser(user.getId());
                try {
                    MailTools.sendMail(user,"Desactivation de compte","Votre compte a ete desactivee.\n contacter l administrateur pour plus d information");
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());                }
                Alert resAlert = new Alert(Alert.AlertType.INFORMATION);
                resAlert.setHeaderText(null);
                resAlert.setContentText("La suspension a été effecuter avec sucess. Un mail a ete envoye a "+user.getNom());
                resAlert.showAndWait();
            } else {

                alert.close();
            }

        } else if (user.getEtat().equals("desactive")) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Demande de confirmation");
            alert.setHeaderText(null);
            alert.setContentText("Est-ce que vous etes sure de votre activation ");
            Optional<ButtonType> btn = alert.showAndWait();
            if (btn.get() == ButtonType.OK) {
                su.ActiverUser(user.getId());
                 try {
                    MailTools.sendMail(user,"Activation de compte","Votre compte a ete reactivee.\n Vous pouvez vous connecter");
                } catch (Exception ex) {
                     System.out.println(ex.getMessage());     
                }
                Alert resAlert = new Alert(Alert.AlertType.INFORMATION);
                resAlert.setHeaderText(null);
                resAlert.setContentText("L activation a été effecuter avec sucess. Un mail a ete envoye a "+user.getNom());
                resAlert.showAndWait();
            } else {

                alert.close();
            }

        }

        afficheTableView();
    }

    @FXML
    private void LogOut(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/loginfxml.fxml"));
            Parent root = loader.load();
            nomTexte.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());     
        }
    }

 


    @FXML
    private void fnreturn(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/home.fxml"));
            Parent root = loader.load();
            lbRetour.getScene().setRoot(root);
           } catch (IOException ex) {
               System.out.print(ex.getMessage());
        }
    }
    
    

}
