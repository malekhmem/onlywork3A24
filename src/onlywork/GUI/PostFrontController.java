/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlywork.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import onlywork.Entities.Categorie;
import onlywork.Entities.Poste;
import onlywork.Services.ServiceCategorie;
import onlywork.Services.ServicePoste;

/**
 * FXML Controller class
 *
 * @author zeine
 */
public class PostFrontController implements Initializable {

    @FXML
    private Label lbMesPoste;
    @FXML
    private Label lbNouveau;
    @FXML
    private Label lbRetour;
    @FXML
    private Pane pnMesPostes;
    @FXML
    private TableView<Poste> tvMesPostes;
    @FXML
    private TableColumn<Poste, String> colNom;
    @FXML
    private TableColumn<Poste, String> colDomain;
    @FXML
    private TableColumn<Poste, String> colMail;
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
    private Pane pnNouveau;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfDomaine;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfDescript;
    @FXML
    private ComboBox<String> tfCategorie;
    @FXML
    private Button btnAnuller;
    @FXML
    private Label lbidposte;
    @FXML
    private Label lbTItreNouveau;
    @FXML
    private Label lbTItreUpdate;
    @FXML
    private Button btnConfModifier;
    @FXML
    private Button btnConfAjouter;
    @FXML
    private Label lbLesPoste;
    @FXML
    private Pane pnMesPostes1;
    @FXML
    private TableView<Poste> tvMesPostes1;
    @FXML
    private TableColumn<Poste, String> colNom1;
    @FXML
    private TableColumn<Poste, String> colDomain1;
    @FXML
    private TableColumn<Poste, String> colMail1;
    @FXML
    private VBox vboxDetail1;
    @FXML
    private Label lbCategorie1;
    @FXML
    private Label lbDescription1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pnMesPostes.toFront();
        System.out.println("+++++++++++++++++");
        fnshow();
        ServiceCategorie sc=new ServiceCategorie();
        ObservableList<String>  list =FXCollections.observableArrayList(sc.afficherNom()); // TODO
        for(int i = 0 ; i<list.size();i++){
            System.out.println("========");
            System.out.println(list.get(i));
        }
    tfCategorie.setItems(list);
        fnshowLesPoste();
        // TODO
    }    
    public void fnshow(){
        ServicePoste sp=new ServicePoste();
         ObservableList<Poste> list =FXCollections.observableList(sp.afficherByID(1)); 
     
     
     colDomain.setCellValueFactory(new PropertyValueFactory<>("domaine"));
     colMail.setCellValueFactory(new PropertyValueFactory<>("emailp"));
          colNom.setCellValueFactory(new PropertyValueFactory<>("nomp"));
     tvMesPostes.setItems(list);
     
     
      
    }
    
    
    public void fnshowLesPoste(){
        ServicePoste sp=new ServicePoste();
         ObservableList<Poste> list =FXCollections.observableList(sp.afficher()); 
     
     
     colDomain1.setCellValueFactory(new PropertyValueFactory<>("domaine"));
     colMail1.setCellValueFactory(new PropertyValueFactory<>("emailp"));
          colNom1.setCellValueFactory(new PropertyValueFactory<>("nomp"));
     tvMesPostes1.setItems(list);
     
     
      
    }

    @FXML
    private void fnMenuMesPostes(MouseEvent event) {
        pnMesPostes.toFront();
    }

    @FXML
    private void fnMenuNouveau(MouseEvent event) {
        pnNouveau.toFront();
    }

    @FXML
    private void fnSelectionPoste(MouseEvent event) {
         Poste p = tvMesPostes.getSelectionModel().getSelectedItem();
         lbidposte.setText(p.getIdp()+"");
         vboxDetail.setVisible(true);
         lbDescription.setText(p.getDescp());
         ServiceCategorie sc=new ServiceCategorie();
         Categorie c=sc.SelectOneCategorie(p.getIdcc());
         lbCategorie.setText(c.getNomc());
    }

    @FXML
    private void fnAjouter(ActionEvent event) {
        pnNouveau.toFront();
    }

    @FXML
    private void fnSupprimer(ActionEvent event) {
        ServicePoste sp=new ServicePoste();
        System.out.println(lbidposte.getText());
        sp.supprimer(Integer.parseInt(lbidposte.getText()));
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
        Poste p = tvMesPostes.getSelectionModel().getSelectedItem();
       ServiceCategorie sc=new ServiceCategorie();
         Categorie c=sc.SelectOneCategorie(p.getIdcc());
         tfCategorie.setValue(c.getNomc());
        tfDescript.setText(p.getDescp());
        tfDomaine.setText(p.getDomaine());
        tfEmail.setText(p.getEmailp());
        tfNom.setText(p.getNomp());
    }
    

    @FXML
    private void fnAnnuler(ActionEvent event) {
        tfCategorie.setValue("");
        tfDescript.setText("");
        tfDomaine.setText("");
        tfEmail.setText("");
        tfNom.setText("");
        btnConfModifier.setVisible(false);
        btnConfAjouter.setVisible(true);
        lbTItreUpdate.setVisible(false);
        lbTItreNouveau.setVisible(true);
        pnMesPostes.toFront();
    }

    @FXML
    private void fnConfAjouter(ActionEvent event) {
        /*Poste p=new Poste();
        ServiceCategorie sc= new ServiceCategorie();
        Categorie c = sc.SelectOneCategorieByNom(tfCategorie.getValue());
        p.setCategorie(c);
        p.setDescp(tfDescript.getText());
        p.setIdu(1);
        p.setEmailp(tfEmail.getText());
        p.setDomaine(tfDomaine.getText());
        p.setNomp(tfNom.getText());
        ServicePoste sp = new ServicePoste();
        sp.add(p);
        fnshow();
        pnMesPostes.toFront();
        tfCategorie.setValue("");
        tfDescript.setText("");
        tfDomaine.setText("");
        tfEmail.setText("");
        tfNom.setText("");*/
        // Vérification de la catégorie
        String categorie = tfCategorie.getValue();
if (categorie == null || categorie.isEmpty()) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur de saisie");
    alert.setHeaderText("Catégorie manquante");
    alert.setContentText("Veuillez sélectionner une catégorie.");
    alert.showAndWait();
    return; 
}

// Vérification de la description
String description = tfDescript.getText();
if (description == null || description.isEmpty()) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur de saisie");
    alert.setHeaderText("Description manquante");
    alert.setContentText("Veuillez saisir une description valide.");
    alert.showAndWait();
    return; 
}


String email = tfEmail.getText();
if (email == null || email.isEmpty() || !email.matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur de saisie");
    alert.setHeaderText("Email invalide");
    alert.setContentText("Veuillez saisir une adresse email valide.");
    alert.showAndWait();
    return; 
}

// Vérification du domaine
String domaine = tfDomaine.getText();
if (domaine == null || domaine.isEmpty() || !domaine.matches("[a-zA-Z]+")) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur de saisie");
    alert.setHeaderText("Domaine invalide");
    alert.setContentText("Veuillez saisir un domaine valide (composé uniquement de lettres alphabétiques).");
    alert.showAndWait();
    return; 
}


String nom = tfNom.getText();
if (nom == null || nom.isEmpty() || !nom.matches("[a-zA-Z]+")) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur de saisie");
    alert.setHeaderText("Nom invalide");
    alert.setContentText("Veuillez saisir un nom valide (composé uniquement de lettres alphabétiques).");
    alert.showAndWait();
    return; 
}

Poste p = new Poste();
ServiceCategorie sc = new ServiceCategorie();
Categorie c = sc.SelectOneCategorieByNom(categorie);
p.setCategorie(c);
p.setDescp(description);
p.setIdu(1);
p.setEmailp(email);
p.setDomaine(domaine);
p.setNomp(nom);
ServicePoste sp = new ServicePoste();
sp.add(p);
fnshow();
pnMesPostes.toFront();
tfCategorie.setValue("");
tfDescript.setText("");
tfDomaine.setText("");
tfEmail.setText("");
tfNom.setText("");


        
    }

    @FXML
    private void fnConfModifier(ActionEvent event) {
        /*Poste p=new Poste();
        ServiceCategorie sc= new ServiceCategorie();
        Categorie c = sc.SelectOneCategorieByNom(tfCategorie.getValue());
        p.setCategorie(c);
        p.setDescp(tfDescript.getText());
        p.setIdu(1);
        p.setEmailp(tfEmail.getText());
        p.setDomaine(tfDomaine.getText());
        p.setNomp(tfNom.getText());
        p.setIdp(Integer.parseInt(lbidposte.getText()));
        ServicePoste sp = new ServicePoste();
        sp.modifier(p);
        fnshow();
        pnMesPostes.toFront();
        tfCategorie.setValue("");
        tfDescript.setText("");
        tfDomaine.setText("");
        tfEmail.setText("");
        tfNom.setText("");*/
        String categorie = tfCategorie.getValue();
if (categorie == null || categorie.isEmpty()) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur de saisie");
    alert.setHeaderText("Catégorie manquante");
    alert.setContentText("Veuillez sélectionner une catégorie.");
    alert.showAndWait();
    return; 
}

String description = tfDescript.getText();
if (description == null || description.isEmpty()) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur de saisie");
    alert.setHeaderText("Description manquante");
    alert.setContentText("Veuillez saisir une description valide.");
    alert.showAndWait();
    return; 
}

String email = tfEmail.getText();
if (email == null || email.isEmpty() || !email.matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur de saisie");
    alert.setHeaderText("Email invalide");
    alert.setContentText("Veuillez saisir une adresse email valide.");
    alert.showAndWait();
    return; 
}

String domaine = tfDomaine.getText();
if (domaine == null || domaine.isEmpty() || !domaine.matches("[a-zA-Z]+")) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur de saisie");
    alert.setHeaderText("Domaine invalide");
    alert.setContentText("Veuillez saisir un domaine valide (composé uniquement de lettres alphabétiques).");
    alert.showAndWait();
    return; 
}

String nom = tfNom.getText();
if (nom == null || nom.isEmpty() || !nom.matches("[a-zA-Z]+")) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur de saisie");
    alert.setHeaderText("Nom invalide");
    alert.setContentText("Veuillez saisir un nom valide (composé uniquement de lettres alphabétiques).");
    alert.showAndWait();
    return; 
}

Poste p = new Poste();
ServiceCategorie sc = new ServiceCategorie();
Categorie c = sc.SelectOneCategorieByNom(categorie);
p.setCategorie(c);
p.setDescp(description);
p.setIdu(1);
p.setEmailp(email);
p.setDomaine(domaine);
p.setNomp(nom);
ServicePoste sp = new ServicePoste();
sp.add(p);
fnshow();
pnMesPostes.toFront();
tfCategorie.setValue("");
tfDescript.setText("");
tfDomaine.setText("");
tfEmail.setText("");
tfNom.setText("");




    }

    @FXML
    private void fnSelectionPoste1(MouseEvent event) {
        Poste p = tvMesPostes1.getSelectionModel().getSelectedItem();
         vboxDetail1.setVisible(true);
         lbDescription1.setText(p.getDescp());
         ServiceCategorie sc=new ServiceCategorie();
         Categorie c=sc.SelectOneCategorie(p.getIdcc());
         lbCategorie1.setText(c.getNomc());
    }

    @FXML
    private void fnMenuLesPostes(MouseEvent event) {
        pnMesPostes1.toFront();
        fnshowLesPoste();
    }
    
}
