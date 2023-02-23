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
public class PostBackController implements Initializable {

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
    private VBox vboxDetail;
    @FXML
    private Label lbCategorie;
    @FXML
    private Label lbDescription;
    @FXML
    private Button btnSupprimer;
    @FXML
    private Label lbidposte;
    @FXML
    private Pane pnCategorie;
    @FXML
    private TableView<Categorie> tvViewCat;
    @FXML
    private TableColumn<Categorie, String> colCat;
    @FXML
    private Button btnAjouterC;
    @FXML
    private Button btnModifierC;
    @FXML
    private Button btnSupprimerC;
    @FXML
    private Pane pnCatAj;
    @FXML
    private TextField tfNomCat;
    @FXML
    private Button btnConfAjouterC;
    @FXML
    private Button btnConfModifierC;
    @FXML
    private Label lbidcat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pnMesPostes.toFront();
        fnshow();
        // TODO
    }    
    
    public void fnshow(){
        ServicePoste sp=new ServicePoste();
         ObservableList<Poste> list =FXCollections.observableList(sp.afficher()); 
     
     
     colDomain.setCellValueFactory(new PropertyValueFactory<>("domaine"));
     colMail.setCellValueFactory(new PropertyValueFactory<>("emailp"));
          colNom.setCellValueFactory(new PropertyValueFactory<>("nomp"));
     tvMesPostes.setItems(list);
     
     
      
    }

    @FXML
    private void fnMenuMesPostes(MouseEvent event) {
        pnMesPostes.toFront();
    }

    @FXML
    private void fnMenuNouveau(MouseEvent event) {
        pnCategorie.toFront();
        fnShowCat();
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
    private void fnSupprimer(ActionEvent event) {
        ServicePoste sp=new ServicePoste();
        System.out.println(lbidposte.getText());
        sp.supprimer(Integer.parseInt(lbidposte.getText()));
        fnshow();
        vboxDetail.setVisible(false);
    }

    @FXML
    private void fnAjouterC(ActionEvent event) {
         btnConfModifierC.setVisible(false);
        btnConfAjouterC.setVisible(true);
        tfNomCat.setText("");
        pnCatAj.toFront();
    }

    @FXML
    private void fnModifierC(ActionEvent event) {
        btnConfModifierC.setVisible(true);
        btnConfAjouterC.setVisible(false);
        int id=Integer.parseInt(lbidcat.getText());
        ServiceCategorie sc = new ServiceCategorie();
        Categorie c=sc.SelectOneCategorie(id);
        tfNomCat.setText(c.getNomc());
        pnCatAj.toFront();
    }

    @FXML
    private void fnSupprimerC(ActionEvent event) {
        ServiceCategorie sc=new ServiceCategorie();
        sc.supprimer(Integer.parseInt(lbidcat.getText()));
        fnShowCat();
    }

    private void fnShowCat() {
        
        ServiceCategorie sp=new ServiceCategorie();
         ObservableList<Categorie> list =FXCollections.observableList(sp.afficher()); 
     
     
     colCat.setCellValueFactory(new PropertyValueFactory<>("nomc"));
     tvViewCat.setItems(list);
    }

    @FXML
    private void fnConfAjouterC(ActionEvent event) {
        /*ServiceCategorie sc= new ServiceCategorie();
        Categorie c=new Categorie();
        c.setNomc(tfNomCat.getText());
        sc.add(c);
        fnShowCat();
        pnCategorie.toFront();*/
        if (!tfNomCat.getText().isEmpty() && tfNomCat.getText().matches("[a-zA-Z]+")) {
    ServiceCategorie sc = new ServiceCategorie();
    Categorie c = new Categorie();
    c.setNomc(tfNomCat.getText());
    sc.add(c);
    fnShowCat();
    pnCategorie.toFront();
    tfNomCat.setText("");
} else {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur de saisie");
    alert.setHeaderText("Veuillez saisir un nom de catégorie valide !");
    alert.showAndWait();
}

    }

    @FXML
    private void fnConfModifierC(ActionEvent event) {
        /*int id=Integer.parseInt(lbidcat.getText());
        ServiceCategorie sc = new ServiceCategorie();
        Categorie c=sc.SelectOneCategorie(id);
        c.setNomc(tfNomCat.getText());
        sc.modifier(c);
        fnShowCat();
        pnCategorie.toFront();*/
        if (!tfNomCat.getText().isEmpty() && tfNomCat.getText().matches("[a-zA-Z]+")) {
    int id=Integer.parseInt(lbidcat.getText());
    ServiceCategorie sc = new ServiceCategorie();
    Categorie c=sc.SelectOneCategorie(id);
    c.setNomc(tfNomCat.getText());
    sc.modifier(c);
    fnShowCat();
    pnCategorie.toFront();
    tfNomCat.setText("");
} else {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur de saisie");
    alert.setHeaderText("Veuillez saisir un nom de catégorie valide !");
    alert.showAndWait();
}
    }

    @FXML
    private void fnSelectedCat(MouseEvent event) {
         Categorie c = tvViewCat.getSelectionModel().getSelectedItem();
         System.out.println(c.getIdc()+"___________dsgsdgsdfsdfsd");
         lbidcat.setText(c.getIdc()+"");
         btnSupprimerC.setVisible(true);
         btnModifierC.setVisible(true);
    }
    
}
