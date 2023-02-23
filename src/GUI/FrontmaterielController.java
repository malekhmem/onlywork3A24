/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
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
import entities.Materiel;
import entities.Annoncef;
import Services.Serviceannoncef;
import Services.Servicemateriel;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


/**
 * FXML Controller class
 *
 * @author imtinen
 */
public class FrontmaterielController implements Initializable {

    @FXML
    private Label lbMesMateriel;
    @FXML
    private Label lbNouveau;
    @FXML
    private Label lbRetour;
    @FXML
    private Pane pnMesMateriels;
    @FXML
    private TableView<Materiel> tvMesMateriels;
    @FXML
    private TableColumn<Materiel, String> colNom;
    @FXML
    private TableColumn<Materiel, String> colMarque;
    @FXML
    private TableColumn<Materiel, Integer> colPrix;
    @FXML
    private TableColumn<Materiel, String> colDescript;
    @FXML
    private Button btnAjouter;
    @FXML
    private VBox vboxDetail;
    @FXML
    private Label lbAnnoncef;
   
    @FXML
    private Button btnSupprimer;
    @FXML
    private Button btnModifier;
    @FXML
    private Pane pnNouveau;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfMarque;
    @FXML
    private TextField tfPrix;
    @FXML
    private TextField tfDescript;
    @FXML
    private ComboBox<String> tfAnnoncef;
    @FXML
    private Button btnAnuller;
    @FXML
    private Label lbidmateriel;
    @FXML
    private Label lbTItreNouveau;
    @FXML
    private Label lbTItreUpdate;
    @FXML
    private Button btnConfModifier;
    @FXML
    private Button btnConfAjouter;
    @FXML
    private Label lbLesMateriels;
    @FXML
    private Pane pnLesMateriels;
    @FXML
    private TableColumn<Materiel, String> colNomm;
    @FXML
    private TableColumn<Materiel, String> colMarquee;
    @FXML
    private TableColumn<Materiel, String> colPrixx;
    @FXML
    private TableColumn<Materiel, String> colDescriptt;
    @FXML
    private Button btnAjouterr;
    @FXML
    private Label lbidannonceff;
    @FXML
    private TableView<Materiel> tvLesMateriels;


   
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     pnLesMateriels.toFront();
        fnshowtout();

        Serviceannoncef sc=new Serviceannoncef();
        ObservableList<String>  list =FXCollections.observableArrayList(sc.afficherNom(1)); // TODO
        for(int i = 0 ; i<list.size();i++){
           list.get(i);
        }
    tfAnnoncef.setItems(list);
        // TODO
    }    
    public void fnshow(){
        Servicemateriel sp=new Servicemateriel();
         ObservableList<Materiel> list =FXCollections.observableList(sp.afficherByID(1)); 
     
     
     colMarque.setCellValueFactory(new PropertyValueFactory<>("marque"));
     colPrix.setCellValueFactory(new PropertyValueFactory<>("Prix"));
          colNom.setCellValueFactory(new PropertyValueFactory<>("nomm"));
         colDescript.setCellValueFactory(new PropertyValueFactory<>("descm"));
     tvMesMateriels.setItems(list);
     
     
      
    }
    public void fnshowtout(){
        Servicemateriel sp=new Servicemateriel();
         ObservableList<Materiel> list =FXCollections.observableList(sp.afficher()); 
     
     
     colMarquee.setCellValueFactory(new PropertyValueFactory<>("marque"));
     colPrixx.setCellValueFactory(new PropertyValueFactory<>("Prix"));
          colNomm.setCellValueFactory(new PropertyValueFactory<>("nomm"));
         colDescriptt.setCellValueFactory(new PropertyValueFactory<>("descm"));
     tvLesMateriels.setItems(list);
     
     
      
    }

    @FXML
    private void fnMenuMesMateriels(MouseEvent event) {
        pnMesMateriels.toFront();
        fnshow();
    }

    @FXML
    private void fnMenuNouveau(MouseEvent event) {
        pnNouveau.toFront();
    }

    @FXML
    private void fnSelectionMateriel(MouseEvent event) {
         Materiel m = tvMesMateriels.getSelectionModel().getSelectedItem();
         lbidmateriel.setText(m.getIdm()+"");
         vboxDetail.setVisible(true);
         Serviceannoncef sc=new Serviceannoncef();
         Annoncef f=sc.SelectOneAnnoncef(m.getIdff());
         lbAnnoncef.setText(f.getNomf());
    }

    @FXML
    private void fnAjouter(ActionEvent event) {
        pnNouveau.toFront();
    }

    @FXML
    private void fnSupprimer(ActionEvent event) {
        Servicemateriel sp=new Servicemateriel();
        System.out.println(lbidmateriel.getText());
        sp.supprimer(Integer.parseInt(lbidmateriel.getText()));
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
        Materiel m = tvMesMateriels.getSelectionModel().getSelectedItem();
       Serviceannoncef sc=new Serviceannoncef();
         Annoncef f=sc.SelectOneAnnoncef(m.getIdff());
         tfAnnoncef.setValue(f.getNomf());
        tfDescript.setText(m.getDescm());
        tfMarque.setText(m.getMarque());
       tfPrix.setText(m.getPrix());
        tfNom.setText(m.getNomm());
    }
    

    @FXML
    private void fnAnnuler(ActionEvent event) {
        tfAnnoncef.setValue("");
        tfDescript.setText("");
        tfMarque.setText("");
        tfPrix.setText("");
        tfNom.setText("");
        pnMesMateriels.toFront();
    }

    @FXML
    private void fnConfAjouter(ActionEvent event) {
Materiel m=new Materiel();
if (tfAnnoncef.getValue() != null && !tfDescript.getText().isEmpty() && !tfPrix.getText().isEmpty() 
        && !tfMarque.getText().isEmpty() && !tfNom.getText().isEmpty()) {
    if (tfPrix.getText().matches("[0-9]+") && tfNom.getText().matches("[a-zA-Z]+") && tfMarque.getText().matches("[a-zA-Z]+")) {
        m.setIdu(1);
        Serviceannoncef sc= new Serviceannoncef();
        Annoncef f = sc.SelectOneAnnoncefByNom(tfAnnoncef.getValue());
        m.setAnnoncef(f);    
        m.setDescm(tfDescript.getText());
        m.setPrix(tfPrix.getText());
        m.setMarque(tfMarque.getText());
        m.setNomm(tfNom.getText());
        Servicemateriel sp = new Servicemateriel();
        sp.add(m);
        fnshow();
        fnshowtout();
        pnMesMateriels.toFront();
        tfAnnoncef.setValue("");
        tfDescript.setText("");
        tfMarque.setText("");
        tfPrix.setText("");
        tfNom.setText("");
    } else {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur de saisie");
        alert.setHeaderText("Veuillez vérifier les champs saisis !");
        alert.showAndWait();
    }
} else {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Champs vides");
    alert.setHeaderText("Veuillez remplir tous les champs !");
    alert.showAndWait();
}

    }

    @FXML
    private void fnConfModifier(ActionEvent event) {
Materiel m=new Materiel();
Serviceannoncef sc= new Serviceannoncef();
Annoncef f = sc.SelectOneAnnoncefByNom(tfAnnoncef.getValue());
m.setAnnoncef(f);
m.setIdu(1);
if (!tfPrix.getText().isEmpty() && tfPrix.getText().matches("\\d+")
        && !tfMarque.getText().isEmpty() && tfMarque.getText().matches("[a-zA-Z]+")
        && !tfNom.getText().isEmpty() && tfNom.getText().matches("[a-zA-Z]+")) {
    m.setPrix(tfPrix.getText());
    m.setMarque(tfMarque.getText());
    m.setNomm(tfNom.getText());
    m.setDescm(tfDescript.getText());
    m.setIdm(Integer.parseInt(lbidmateriel.getText()));
    Servicemateriel sp = new Servicemateriel();
    sp.modifier(m);
    fnshowtout();
    fnshow();
    pnMesMateriels.toFront();
    tfAnnoncef.setValue("");
    tfDescript.setText("");
    tfMarque.setText("");
    tfPrix.setText("");
    tfNom.setText("");
} else {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur de saisie");
    alert.setHeaderText("Veuillez vérifier les champs saisis !");
    alert.showAndWait();
}

    }

    @FXML
    private void fnMenuLesMateriels(MouseEvent event) {
             pnLesMateriels.toFront();
    }

    @FXML
    private void fnSelectlesmateriels(MouseEvent event) {
        Materiel m = tvLesMateriels.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void fnfront(MouseEvent event) {
                               try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("front.fxml"));
            Parent root = loader.load();
            lbRetour.getScene().setRoot(root);
           } catch (IOException ex) {
               System.out.print(ex.getMessage());
        }
    }

  
}