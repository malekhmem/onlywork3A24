/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Evenement;
import Services.ServiceEvenement;

import Entities.Evenement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
 import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import Services.ServiceEvenement;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author chino
 */
public class EvenementFrontController implements Initializable {


    @FXML
    private Label lbMesEvenement;
    private Label lbTitre;


    @FXML
    private Label lbNouveau;

    @FXML
    private Label lbRetour;

    @FXML
    private Pane pnNouveau;

    @FXML
    private Label lbTItreNouveau;

    @FXML
    private TextField tfTitre;
    
    private TextField tfNumero;


    @FXML
    private TextField tfDescription;

    @FXML
    private TextField tfNom_societe;

    @FXML
    private Button btnAnuller;

    @FXML
    private Button btnConfModifier;

    @FXML
    private Button btnConfAjouter;

    @FXML
    private Label lbTItreUpdate;

    @FXML
    private Pane pnMesEvenement;
   
    @FXML
    private TableView<Evenement> tvMesEvenement;

    @FXML
    private TableColumn<Evenement, String> colTitre;

    @FXML
    private TableColumn<Evenement, String> colDescription;

    @FXML
    private TableColumn<Evenement, String> colNom_societe;
 ObservableList<Evenement> list ;

    @FXML
    private Button btnAjouter;

    @FXML
    private VBox vboxDetail;

    @FXML
    private Button btnSupprimer;

    @FXML
    private Button btnModifier;

    private Label lbidEvenement;
    @FXML
    private Label lbidevenement;
    @FXML
    private TextField chercher;
    @FXML
    private Button TriTitre;
   ServiceEvenement sp = new ServiceEvenement();

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
       //@Override
    public void initialize(URL url, ResourceBundle rb) {
        pnMesEvenement.toFront();
        System.out.println("+++++++++++++++++");
        fnshow();

        // TODO
    } 
    public void fnshow(){
        ServiceEvenement sp=new ServiceEvenement();
         ObservableList<Evenement> list =FXCollections.observableList(sp.afficher()); 
     
     colTitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
     colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
     colNom_societe.setCellValueFactory(new PropertyValueFactory<>("nomss"));
     tvMesEvenement.setItems(list);
     
     
      
    }

    private void fnMenuMesaostes(MouseEvent event) {
        pnMesEvenement.toFront();
    }

    @FXML
    private void fnMenuNouveau(MouseEvent event) {
        pnNouveau.toFront();
    }


  


    @FXML
    void fnAjouter(ActionEvent event) {
        pnNouveau.toFront();

    }

    
    @FXML
    private void fnSupprimer(ActionEvent event) {
        ServiceEvenement sp=new ServiceEvenement();
        System.out.println(lbidevenement.getText());
        sp.supprimer(Integer.parseInt(lbidevenement.getText()));
        fnshow();
        vboxDetail.setVisible(false);
    }

    @FXML
    private void fnModifier(ActionEvent event) {
        lbTItreNouveau.setVisible(false);
        lbTItreUpdate.setVisible(true);
        btnConfAjouter.setVisible(false);
        btnConfModifier.setVisible(true);
        pnNouveau.toFront();
        Evenement p =  tvMesEvenement.getSelectionModel().getSelectedItem();
       //ServiceCategorie sc=new ServiceCategorie();
         //Categorie c=sc.SelectOneCategorie(p.getIdcc());
         //tfCategorie.setValue(c.getNomc());
        tfNom_societe.setText(p.getNomss());
        tfDescription.setText(p.getDescription());
        tfTitre.setText(p.getTitre());
    }
    
    @FXML
    private void fnAnnuler(ActionEvent event) {
        //tfCategorie.setValue("");
        tfNom_societe.setText("");
        tfDescription.setText("");
        tfTitre.setText("");
        pnMesEvenement.toFront();
    }
    
   /* @FXML
    void fnConfAjouter(ActionEvent event) {
       Evenement p=new Evenement();
        p.setNomss(tfNom_societe.getText());
        p.setDescription(tfDescription.getText());
        p.setTitre(tfTitre.getText());
        ServiceEvenement sp = new ServiceEvenement();
        sp.add(p);
        fnshow();
        pnMesEvenement.toFront();
        tfNom_societe.setText("");
        tfDescription.setText("");
        tfTitre.setText("");

    }*/

    
        @FXML
void fnConfAjouter(ActionEvent event) {
if (tfNom_societe.getText().isEmpty() || !tfNom_societe.getText().matches("^[a-zA-Z]+$")) {
// Afficher un message d'erreur et sortir de la fonction si le champ nom n'est pas valide
Alert alert = new Alert(AlertType.ERROR, "Le champ nom societe est invalide !");
alert.showAndWait();
return;
}
if (tfTitre.getText().isEmpty()) {
// Afficher un message d'erreur et sortir de la fonction si le champ titre est vide
Alert alert = new Alert(AlertType.ERROR, "Le champ titre est obligatoire !");
alert.showAndWait();
return;
}
if (tfDescription.getText().isEmpty()) {
// Afficher un message d'erreur et sortir de la fonction si le champ description est vide
Alert alert = new Alert(AlertType.ERROR, "Le champ description est obligatoire !");
alert.showAndWait();
return;
}
Evenement p=new Evenement();
p.setNomss(tfNom_societe.getText());
p.setDescription(tfDescription.getText());
p.setTitre(tfTitre.getText());
ServiceEvenement sp = new ServiceEvenement();
sp.add(p);
fnshow();
pnMesEvenement.toFront();
tfNom_societe.setText("");
tfDescription.setText("");
tfTitre.setText("");
}
    
    
    /*@FXML
    void fnConfModifier(ActionEvent event) {
 Evenement p=new Evenement();
        p.setIde(Integer.parseInt(lbidevenement.getText()));
        p.setNomss(tfNom_societe.getText());
        p.setDescription(tfDescription.getText());
        p.setTitre(tfTitre.getText());
        p.setIds(1);
        ServiceEvenement sp = new ServiceEvenement();
        sp.modifier(p);
        fnshow();
        pnMesEvenement.toFront();
        tfNom_societe.setText("");
        tfDescription.setText("");
        tfTitre.setText("");

    }*/


@FXML
    void fnConfModifier(ActionEvent event) {
        Evenement p=new Evenement();
         p.setIde(Integer.parseInt(lbidevenement.getText()));
        // Contrôle de saisie pour le nom de la société (seuls les alphabets sont autorisés)
String nomSociete = tfNom_societe.getText().trim();
if (nomSociete.isEmpty()) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setHeaderText("Erreur de saisie");
    alert.setContentText("Le nom de la société est requis");
    alert.showAndWait();
    return;
} else if (!nomSociete.matches("[a-zA-Z]+")) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setHeaderText("Erreur de saisie");
    alert.setContentText("Le nom de la société ne doit contenir que des lettres alphabétiques");
    alert.showAndWait();
    return;
}
p.setNomss(nomSociete);

// Contrôle de saisie pour la description
String description = tfDescription.getText().trim();
if (description.isEmpty()) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setHeaderText("Erreur de saisie");
    alert.setContentText("La description de l'événement est requise");
    alert.showAndWait();
    return;
}
p.setDescription(description);

// Contrôle de saisie pour le titre
String titre = tfTitre.getText().trim();
if (titre.isEmpty()) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setHeaderText("Erreur de saisie");
    alert.setContentText("Le titre de l'événement est requis");
    alert.showAndWait();
    return;
}
p.setTitre(titre);

p.setIds(1); // à modifier si nécessaire

// Modification de l'événement dans la base de données
ServiceEvenement sp = new ServiceEvenement();
sp.modifier(p);

// Actualisation de l'affichage
fnshow();
pnMesEvenement.toFront();

// Réinitialisation des champs de saisie
tfNom_societe.setText("");
tfDescription.setText("");
tfTitre.setText("");
        
    }




    @FXML
    private void fnMenuMesEvenement(MouseEvent event) {
        pnMesEvenement.toFront();
    }

   


    @FXML
    private void fnSelectionEvenemnt(MouseEvent event) {
        Evenement f = tvMesEvenement.getSelectionModel().getSelectedItem();
         lbidevenement.setText(f.getIde()+"");
         vboxDetail.setVisible(true);
    }

    @FXML
    private void Recherche(KeyEvent event) throws SQLException {
        
         Evenement p=new Evenement();
ServiceEvenement sp = new ServiceEvenement();
       tvMesEvenement.setItems(sp.searchByEvenement(chercher.getText()))  ;
    }

    @FXML
    private void TriTitre(ActionEvent event) {
        colTitre.setCellValueFactory(new PropertyValueFactory<Evenement,String>("titre"));
      colDescription.setCellValueFactory(new PropertyValueFactory<Evenement,String>("description"));
   colNom_societe.setCellValueFactory(new PropertyValueFactory<Evenement,String>("nomss"));


  list=sp.getAllTriTitre();
       tvMesEvenement.setItems(list)  ;
    }


    
}

































/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*package evenement_societe.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author chino
 */
/*public class EvenementFrontController implements Initializable {

    @FXML
    private Label lbMesEvenement;
    @FXML
    private Label lbNouveau;
    @FXML
    private Label lbRetour;
    @FXML
    private Pane pnNouveau;
    @FXML
    private Label lbTItreNouveau;
    @FXML
    private TextField tfTitre;
    @FXML
    private TextField tfDescription;
    @FXML
    private TextField tfNom_societe;
    @FXML
    private Button btnAnuller;
    @FXML
    private Button btnConfModifier;
    @FXML
    private Button btnConfAjouter;
    @FXML
    private Label lbTItreUpdate;
    @FXML
    private Pane pnMesEvenement;
    @FXML
    private TableView<?> tvMesPostes;
    @FXML
    private TableColumn<?, ?> colTitre;
    @FXML
    private TableColumn<?, ?> colDescription;
    @FXML
    private TableColumn<?, ?> colNom_societe;
    @FXML
    private Button btnAjouter;
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

    /**
     * Initializes the controller class.
     */
    /*@Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void fnMenuMesEvenement(MouseEvent event) {
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
    private void fnSelectionPoste(MouseEvent event) {
    }

    @FXML
    private void fnAjouter(ActionEvent event) {
    }

    @FXML
    private void fnSupprimer(ActionEvent event) {
    }

    @FXML
    private void fnModifier(ActionEvent event) {
    }
    
}*/