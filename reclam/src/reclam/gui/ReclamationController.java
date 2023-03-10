/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reclam.gui;

import reclam.gui.*;
import java.net.URL;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
import reclam.Entities.blackliste;
import reclam.Entities.reclamation;
import reclam.Services.Serviceblackliste;
import reclam.Services.Servicereclamation;
import reclam.Entities.rating;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * FXML Controller class import reclam.Entities.blackliste; import
 * reclam.Entities.reclamation; import reclam.Services.Serviceblackliste; import
 * reclam.Services.Servicereclamation;
 *
 * @author houssem
 */
public class ReclamationController implements Initializable {
 ObservableList<reclamation> dataList;
 
    @FXML
    private Label lbMesreclamations;
    private Slider ratingSlider;

    @FXML
    private Label lbNouveau;
    @FXML
    private Label lbRetour;
    @FXML
    private Pane pnreclamation;
    @FXML
    private TableView<reclamation> table;
    @FXML
    private TableColumn<reclamation, String> colNom1;
    @FXML
    private TableColumn<String, reclamation> colEmail;
    @FXML
            private TableColumn<String, reclamation> coltraiter;
    @FXML

    private TableColumn<reclamation, String> colDomain1;

    @FXML
    private TableColumn<reclamation, String> coltype;

    ObservableList<reclamation> List;
    @FXML
    private Pane pnNouveau;
    @FXML
    private Label lbTItreNouveau;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfDescript;
    @FXML
    private TextField tftype;
    public static reclamation currentannonces;

    @FXML
     
    private TextField tfrecherche2;
    @FXML
    public Button TriNom2;
    @FXML
    private Button btnConfModifier;
    @FXML
      private Button rating;
        @FXML

    private Label lbTItreUpdate;
    @FXML
    private VBox vboxDetail;
    @FXML
    private Label lbCategorie;
    @FXML
    private Label lbDescription;
    @FXML
    private Label lbidposte;
    @FXML
    private Label lbTItreNouveau1;
    @FXML
    private Button btnSupprimer;
  


    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        pnreclamation.toFront();
        System.out.println("weclome");
        fnshow();

    }

    public void fnshow() {

        Servicereclamation sr = new Servicereclamation();
        ObservableList<reclamation> list = FXCollections.observableList(sr.afficher());
        
        colNom1.setCellValueFactory(new PropertyValueFactory<>("nomr"));
        colEmail.setCellValueFactory(new PropertyValueFactory<String,reclamation>("emailr"));
        colDomain1.setCellValueFactory(new PropertyValueFactory<reclamation, String>("descr"));
       
        
        coltype.setCellValueFactory(new PropertyValueFactory<>("type"));
       coltraiter.setCellValueFactory(new PropertyValueFactory<>("traiter"));
        table.setItems(list);

    }

    @FXML
    private void fnMenuMesreclamations(MouseEvent event) {
        pnreclamation.toFront();
        fnshow();

    }

    @FXML
    private void fnMenuNouveau(MouseEvent event) {
        pnNouveau.toFront();

    }

    private void fnSelectionreclamation(MouseEvent event) {
        reclamation r = table.getSelectionModel().getSelectedItem();
        currentannonces = r;

    }

    @FXML
    private void annuler(ActionEvent event) {
        Servicereclamation sr = new Servicereclamation();
        sr.supprimer(tfNom.getText());
        pnreclamation.toFront();
        fnshow();

    }

    @FXML
    private void fnConfModifier(ActionEvent event) {
        reclamation r = new reclamation();
// Vérifier que tous les champs obligatoires sont remplis
        if (tfNom.getText().isEmpty() || tfDescript.getText().isEmpty() || tfEmail.getText().isEmpty() || tftype.getText().isEmpty()) {
            // Afficher un message d'erreur
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Tous les champs sont obligatoires");
            alert.setContentText("Veuillez remplir tous les champs obligatoires.");
            alert.showAndWait();
            return;
        }

// Vérifier que le nom est composé uniquement de lettres
        if (!tfNom.getText().matches("[a-zA-Z]+")) {
            // Afficher un message d'erreur
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Le nom n'est pas valide");
            alert.setContentText("Le nom doit être composé uniquement des lettres.");
            alert.showAndWait();
            return;
        }

// Vérifier que le numéro est composé uniquement de chiffres
        if (!tfDescript.getText().matches("[a-zA-Z]+")) {
            // Afficher un message d'erreur
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Lq description n'est pas valide");
            alert.setContentText("La description doit être composé uniquement des lettres.");
            alert.showAndWait();
            return;
        }
// Vérifier que l'email est au format valide
        if (!tfEmail.getText().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            // Afficher un message d'erreur
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("L'email n'est pas valide");
            alert.setContentText("L'email doit être au format valide (exemple: nom@domaine.com).");
            alert.showAndWait();
            return;
        }

        r.setNomr(tfNom.getText());
        r.setDescr(tfDescript.getText());
        r.setEmailr(tfEmail.getText());
        r.setType(tftype.getText());
        Servicereclamation sr = new Servicereclamation();
        sr.modifier(r);
        fnshow();

        pnreclamation.toFront();
        tfNom.setText("");
        tfDescript.setText("");
        tfEmail.setText("");
        tftype.setText("");

    }

    @FXML
    private void ajouter(ActionEvent event) {
        reclamation r = new reclamation();
// Vérifier que tous les champs obligatoires sont remplis
        if (tfNom.getText().isEmpty() || tfDescript.getText().isEmpty() || tfEmail.getText().isEmpty() || tftype.getText().isEmpty()) {
            // Afficher un message d'erreur
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Tous les champs sont obligatoires");
            alert.setContentText("Veuillez remplir tous les champs obligatoires.");
            alert.showAndWait();
            return;
        }

// Vérifier que le nom est composé uniquement de lettres
        if (!tfNom.getText().matches("[a-zA-Z]+")) {
            // Afficher un message d'erreur
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Le nom n'est pas valide");
            alert.setContentText("Le nom doit être composé uniquement des lettres.");
            alert.showAndWait();
            return;
        }

// Vérifier que le numéro est composé uniquement de chiffres
        if (!tfDescript.getText().matches("[a-zA-Z]+")) {
            // Afficher un message d'erreur
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Lq description n'est pas valide");
            alert.setContentText("La description doit être composé uniquement des lettres.");
            alert.showAndWait();
            return;
        }
// Vérifier que l'email est au format valide
        if (!tfEmail.getText().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
            // Afficher un message d'erreur
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("L'email n'est pas valide");
            alert.setContentText("L'email doit être au format valide (exemple: nom@domaine.com).");
            alert.showAndWait();
            return;
        }

        r.setNomr(tfNom.getText());
        r.setDescr(tfDescript.getText());
        r.setEmailr(tfEmail.getText());
        r.setType(tftype.getText());
        r.setTraiter("non traiter");
        Servicereclamation sr = new Servicereclamation();
        sr.add(r);
        fnshow();
        pnreclamation.toFront();
        tfNom.setText("");
        tfDescript.setText("");
        tfEmail.setText("");
        tftype.setText("");

    }

    @FXML
    void Recherche() {

        colNom1.setCellValueFactory(new PropertyValueFactory<>("nomr"));
        colEmail.setCellValueFactory(new PropertyValueFactory<String,reclamation>("emailr"));
        colDomain1.setCellValueFactory(new PropertyValueFactory<reclamation, String>("descr"));
       
        
        coltype.setCellValueFactory(new PropertyValueFactory<>("type"));
coltraiter.setCellValueFactory(new PropertyValueFactory<>("traiter"));

        Servicereclamation ex = new Servicereclamation();
        dataList = ex.getDatareclamation();
        table.setItems(dataList);

        FilteredList<reclamation> filteredData = new FilteredList<>(dataList, b -> true);
        tfrecherche2.textProperty().addListener((observable, oldValue, newValue) -> {

            filteredData.setPredicate(t -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (t.getNomr().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else {
                    return false;
                }

            });

        });
        SortedList<reclamation> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);

    }

    @FXML
    public void TriNom2(ActionEvent event) throws SQLException {

        Servicereclamation sr = new Servicereclamation();
        ObservableList<reclamation> list = FXCollections.observableList(sr.afficher());

        colNom1.setCellValueFactory(new PropertyValueFactory<>("nomr"));

        colEmail.setCellValueFactory(new PropertyValueFactory<>("emailr"));
        colDomain1.setCellValueFactory(new PropertyValueFactory<>("descr"));

        coltype.setCellValueFactory(new PropertyValueFactory<>("type"));

        list = sr.getAllTrinom();
        table.setItems(list);
    }
            @FXML

    private void rating(ActionEvent event) {

        reclamation r = new reclamation();
        Servicereclamation sr = new Servicereclamation();

        sr.onSaveRating((int) ratingSlider.getValue());

    }

}
