/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reclam.gui;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import javafx.event.ActionEvent;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import static java.lang.Integer.parseInt;

import reclam.Entities.blackliste;
import reclam.Entities.reclamation;
import reclam.Services.Serviceblackliste;
import reclam.Services.Servicereclamation;


/**
 * FXML Controller class
 *
 * @author houssem
 */
public class BlacklisteController implements Initializable {
       
    ObservableList<blackliste> dataList;
    
    

@FXML
    private Label lbMesblackliste;
    @FXML
    private Label lbNouveau;
    @FXML
    private Label lbRetour;
    @FXML
    private StackPane pnMesnouveau;
    @FXML
    private Pane pnnouveau;
    @FXML
    private Pane pnNouveau;
    @FXML
     private TableView<blackliste> table2 ; 
        @FXML

    private Label lbTItreNouveau;
    @FXML
    private TextField tfdescrip;
    @FXML
    private TextField tfnumb;
    @FXML
    private Button btnAnuller2;
    @FXML
    private Button btnModifier2;
    @FXML
    private Button btnConfAjouter2;
    @FXML
    private Label lbTItreUpdate;
    @FXML
    private Pane pnMesblackliste;
    @FXML
    private TableColumn<blackliste, String> colNom;
    @FXML
    private TableColumn<blackliste, String> colDomain;
    
      ObservableList<blackliste> List;

    @FXML
     private TextField tfrecherche;
    @FXML
    private Button tribynbrr;
 Serviceblackliste sb=new Serviceblackliste();
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
     * @param url
     * @param rb
     */
    @Override


    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                 pnnouveau.toFront();

        Serviceblackliste sb= new Serviceblackliste();
        fnshowcase();
       
        
        
    }    

    @FXML    
    
   public void fnshowcase(){
        Serviceblackliste sb=new Serviceblackliste();
         ObservableList<blackliste> list =FXCollections.observableList(sb.afficher()); 

     colNom.setCellValueFactory(new PropertyValueFactory<>("descb"));
        colDomain.setCellValueFactory(new PropertyValueFactory<>("nbrr"));
        
           table2.setItems(list);
     
   }
      

    public void fnMenuMesblackliste(MouseEvent event) {
                pnMesblackliste.toFront();
                        fnshowcase();


    }

    @FXML
    public void fnMenuNouveau(MouseEvent event) {
                 pnNouveau.toFront();
    }
        @FXML

      private void fnSelectionblackliste(MouseEvent event) {
          
    }
      

    @FXML
    private void fnAnnuler2(ActionEvent event) 
    {
         Serviceblackliste sb = new Serviceblackliste();
        System.out.println(tfdescrip.getText());
        sb.supprimer(tfdescrip.getText());
        fnshowcase();
         
        
    }

    @FXML
    private void btnModifier2(ActionEvent event) {
        
      blackliste b =new blackliste();
// Vérifier que tous les champs obligatoires sont remplis
if (tfdescrip.getText().isEmpty() || tfnumb.getText().isEmpty() ) {
    // Afficher un message d'erreur
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Erreur");
    alert.setHeaderText("Tous les champs sont obligatoires");
    alert.setContentText("Veuillez remplir tous les champs obligatoires.");
    alert.showAndWait();
    return;
}

// Vérifier que le nom est composé uniquement de lettres
if (!tfdescrip.getText().matches("[a-zA-Z]+")) {
    // Afficher un message d'erreur
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Erreur");
    alert.setHeaderText("Le nom n'est pas valide");
    alert.setContentText("Le nom doit être composé uniquement de lettres.");
    alert.showAndWait();
    return;
}

// Vérifier que le numéro est composé uniquement de chiffres
if (!tfnumb.getText().matches("\\d+")) {
    // Afficher un message d'erreur
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Erreur");
    alert.setHeaderText("Le numéro n'est pas valide");
    alert.setContentText("Le numéro doit être composé uniquement de chiffres.");
    alert.showAndWait();
    return;
}


b.setNbrr(Integer.parseInt(tfnumb.getText()));
b.setDescb(tfdescrip.getText());
Serviceblackliste sp = new Serviceblackliste();
sp.modifier(b);
fnshowcase();
 pnMesblackliste.toFront();
tfdescrip.setText("");
tfnumb.setText("");

      
    
    }

    @FXML
   
    private void btnConfAjouter2(ActionEvent event) {
        
      blackliste b =new blackliste();
// Vérifier que tous les champs obligatoires sont remplis
if (tfdescrip.getText().isEmpty() || tfnumb.getText().isEmpty() ) {
    // Afficher un message d'erreur
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Erreur");
    alert.setHeaderText("Tous les champs sont obligatoires");
    alert.setContentText("Veuillez remplir tous les champs obligatoires.");
    alert.showAndWait();
    return;
}

// Vérifier que le nom est composé uniquement de lettres
if (!tfdescrip.getText().matches("[a-zA-Z]+")) {
    // Afficher un message d'erreur
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Erreur");
    alert.setHeaderText("Le nom n'est pas valide");
    alert.setContentText("Le nom doit être composé uniquement de lettres.");
    alert.showAndWait();
    return;
}

// Vérifier que le numéro est composé uniquement de chiffres
if (!tfnumb.getText().matches("\\d+")) {
    // Afficher un message d'erreur
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("Erreur");
    alert.setHeaderText("Le numéro n'est pas valide");
    alert.setContentText("Le numéro doit être composé uniquement de chiffres.");
    alert.showAndWait();
    return;
}


b.setNbrr(Integer.parseInt(tfnumb.getText()));
b.setDescb(tfdescrip.getText());
Serviceblackliste sp = new Serviceblackliste();
sp.add(b);
fnshowcase();
 pnMesblackliste.toFront();
tfdescrip.setText("");
tfnumb.setText("");

         
    }
    
    @FXML
   void Recherche()  {
              colNom.setCellValueFactory(new PropertyValueFactory<>("descb"));
        colDomain.setCellValueFactory(new PropertyValueFactory<>("nbrr"));
      


        Serviceblackliste ex = new Serviceblackliste();
        dataList = ex.getDatablackliste();
        table2.setItems(dataList);

        FilteredList<blackliste> filteredData = new FilteredList<>(dataList, b -> true);
        tfrecherche.textProperty().addListener((observable, oldValue, newValue) -> {

            filteredData.setPredicate(t -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (t.getDescb().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true;
                } else {
                    return false;
                }

            });

        });
        SortedList<blackliste> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table2.comparatorProperty());
        table2.setItems(sortedData);
        
    }

    @FXML
    private void tribynbrr(ActionEvent event) throws SQLException {
            
        Serviceblackliste sb = new Serviceblackliste();
        ObservableList<blackliste> list =FXCollections.observableList(sb.afficher()); 

   colNom.setCellValueFactory(new PropertyValueFactory<>("descb"));
        colDomain.setCellValueFactory(new PropertyValueFactory<>("nbrr"));
    


       list=sb.getAllTrinbr();
       table2.setItems(list)  ;
    }
   
    }