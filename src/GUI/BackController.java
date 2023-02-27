/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Annonces;
import Entities.Evenement;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import Entities.Annonces;
import Services.ServiceAnnonces;
import Entities.Evenement;
import Services.ServiceEvenement;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 * FXML Controller class
 *
 * @author chino
 */
public class BackController implements Initializable {

    @FXML
    private Label lbLesEvenements;
    @FXML
    private Label lbRetour;
    @FXML
    private Pane pnLesAnnonces;
    @FXML
    private TableView<Annonces> tvLesAnnonces;
    @FXML
    private TableColumn<Annonces, String> colNom;
    @FXML
    private TableColumn<Annonces, String> colMail;
    @FXML
    private TableColumn<Annonces, String> colNumero;
    @FXML
    private TableColumn<Annonces, String> colAdresse;
    @FXML
    private VBox vboxDetail;
    @FXML
    private Button btnSupprimer;
    @FXML
    private Pane pnLesEvenements;
    @FXML
    private TableView<Evenement> tvLesEvenements;
    @FXML
    private TableColumn<Evenement, String> coltitre;
    @FXML
    private TableColumn<Evenement, String> colDescription;
    @FXML
    private TableColumn<Evenement, String> colNoms;
    @FXML
    private VBox vboxDetaill;
    @FXML
    private Button btnSupprimerr;
    @FXML
    private Label lbidevenement;
     @FXML
    private Label lbidannonces;
    @FXML
    private Label lbLesAnnonces;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
                pnLesAnnonces.toFront();
                fnshow();
        // TODO
    }    
 public void fnshow(){
        ServiceAnnonces sp=new ServiceAnnonces();
         ObservableList<Annonces> list =FXCollections.observableList(sp.afficher());   
     colAdresse.setCellValueFactory(new PropertyValueFactory<>("adresses"));
     colMail.setCellValueFactory(new PropertyValueFactory<>("emails"));
      colNom.setCellValueFactory(new PropertyValueFactory<>("noms"));
      colNumero.setCellValueFactory(new PropertyValueFactory<>("numeros"));
      tvLesAnnonces.setItems(list);
     
     
   }
  public void fnshowtout(){
        ServiceEvenement sp=new ServiceEvenement();
         ObservableList<Evenement> list =FXCollections.observableList(sp.afficher()); 
     
     
     coltitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
     colDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
          colNoms.setCellValueFactory(new PropertyValueFactory<>("nom_societe"));
     tvLesEvenements.setItems(list);
     
     
      
    }
    @FXML
    private void fnMenuLesAnnonces   (MouseEvent event) {
                 pnLesAnnonces.toFront();

    }

    @FXML
    private void fnMenuLesEvenements(MouseEvent event) {
         pnLesEvenements.toFront();
            fnshowtout();
    }

    @FXML
    private void fnfront(MouseEvent event) {
           try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("front.fxml"));
            Parent root = loader.load();
            lbRetour.getScene().setRoot(root);
           } catch (IOException ex) {
               System.out.print(ex.getMessage());}
    }

    @FXML
    private void fnSelectiannonces (MouseEvent event) {
                Annonces s = tvLesAnnonces.getSelectionModel().getSelectedItem();
         lbidannonces.setText(s.getIds()+"");
         vboxDetail.setVisible(true);
                 fnshow();
    }

    @FXML
    private void fnSupprimer(ActionEvent event) {
         ServiceAnnonces sp=new ServiceAnnonces();
        System.out.println(lbidannonces.getText());
        sp.supprimer(Integer.parseInt(lbidannonces.getText()));
        fnshow();
        vboxDetail.setVisible(false);
    }

    @FXML
    private void fnSelectionevenement(MouseEvent event) {
          Evenement m = tvLesEvenements.getSelectionModel().getSelectedItem();
         lbidevenement.setText(m.getIde()+"");
         vboxDetaill.setVisible(true);
         ServiceAnnonces sc=new ServiceAnnonces();
         Annonces f = sc.SelectOneAnnonces(m.getIds());
         lbLesAnnonces.setText(f.getNoms());
    }

    @FXML
    private void fnSupprimerr(ActionEvent event) {
          ServiceEvenement sp=new ServiceEvenement();
        System.out.println(lbidevenement.getText());
        sp.supprimer(Integer.parseInt(lbidevenement.getText()));
        fnshowtout();
        vboxDetaill.setVisible(false);
    
    }
    
}
