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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import entities.Annoncef;
import Services.Serviceannoncef;
import entities.Materiel;
import Services.Servicemateriel;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 * FXML Controller class
 *
 * @author imtinen
 */
public class BackController implements Initializable {

    @FXML
    private Label lbLesAnnoncef;
    @FXML
    private Label lbRetour;
    @FXML
    private Pane pnLesAnnoncef;
    @FXML
    private TableView<Annoncef> tvLesAnnoncef;
    @FXML
    private TableColumn<Annoncef, String> colNom;
    @FXML
    private TableColumn<Annoncef, String> colAdresse;
    @FXML
    private TableColumn<Annoncef, String> colMail;
    @FXML
    private TableColumn<Annoncef, String> colDescript;
    @FXML
    private VBox vboxDetail;
    @FXML
    private Label lbDescription;
    @FXML
    private Button btnSupprimer;
    @FXML
    private Label lbidannoncef;
    @FXML
    private Label lbLesMateriels;
    @FXML
    private Pane pnLesMateriels;
    @FXML
    private TableView<Materiel> tvLesMateriels;
    @FXML
    private TableColumn<Materiel, String> colNomm;
    @FXML
    private TableColumn<Materiel, String> colMarque;
    @FXML
    private TableColumn<Materiel, String> colPrix;
    @FXML
    private TableColumn<Materiel, String> colDescriptt;
    @FXML
    private VBox vboxDetaill;
    @FXML
    private Button btnSupprimerr;
    @FXML
    private Label lbidmateriel;
    @FXML
    private Label lbAnnoncef;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                pnLesAnnoncef.toFront();
        fnshow();
        // TODO
    }    
   public void fnshow(){
        Serviceannoncef sp=new Serviceannoncef();
         ObservableList<Annoncef> list =FXCollections.observableList(sp.afficher());   
     colAdresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
     colMail.setCellValueFactory(new PropertyValueFactory<>("emailf"));
      colNom.setCellValueFactory(new PropertyValueFactory<>("nomf"));
      colDescript.setCellValueFactory(new PropertyValueFactory<>("descf"));
      tvLesAnnoncef.setItems(list);
     
     
   }
       
   public void fnshowtout(){
        Servicemateriel sp=new Servicemateriel();
         ObservableList<Materiel> list =FXCollections.observableList(sp.afficher()); 
     
     
     colMarque.setCellValueFactory(new PropertyValueFactory<>("marque"));
     colPrix.setCellValueFactory(new PropertyValueFactory<>("Prix"));
          colNomm.setCellValueFactory(new PropertyValueFactory<>("nomm"));
         colDescriptt.setCellValueFactory(new PropertyValueFactory<>("descm"));
     tvLesMateriels.setItems(list);
     
     
      
    }
    @FXML
    private void fnMenuLesAnnoncef(MouseEvent event) {
         pnLesAnnoncef.toFront();
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

    @FXML
    private void fnSelectiannoncef(MouseEvent event) {
                 Annoncef f = tvLesAnnoncef.getSelectionModel().getSelectedItem();
         lbidannoncef.setText(f.getIdf()+"");
         vboxDetail.setVisible(true);
                 fnshow();

    }

    @FXML
    private void fnSupprimer(ActionEvent event) {
       Serviceannoncef sp=new Serviceannoncef();
        System.out.println(lbidannoncef.getText());
        sp.supprimer(Integer.parseInt(lbidannoncef.getText()));
        fnshow();
        vboxDetail.setVisible(false);
    }

    @FXML
    private void fnMenuLesMateriels(MouseEvent event) {
            pnLesMateriels.toFront();
            fnshowtout();
    }

    @FXML
    private void fnSelectionmateriel(MouseEvent event) {
                 Materiel m = tvLesMateriels.getSelectionModel().getSelectedItem();
         lbidmateriel.setText(m.getIdm()+"");
         vboxDetaill.setVisible(true);
         Serviceannoncef sc=new Serviceannoncef();
         Annoncef f=sc.SelectOneAnnoncef(m.getIdff());
         lbAnnoncef.setText(f.getNomf());
    }

    @FXML
    private void fnSupprimerr(ActionEvent event) {
                Servicemateriel sp=new Servicemateriel();
        System.out.println(lbidmateriel.getText());
        sp.supprimer(Integer.parseInt(lbidmateriel.getText()));
        fnshowtout();
        vboxDetaill.setVisible(false);
    }
    
}
