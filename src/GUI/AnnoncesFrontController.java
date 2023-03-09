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
import entities.Annonces;
import entities.Evenement;
import services.ServiceAnnonces;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;



/**
 * FXML Controller class
 *
 * @author zeine
 */
public class AnnoncesFrontController implements Initializable {

    private Pane pnNouveau;

    private Label lbTItreNouveau;

    @FXML
    private Label lbNouveau;
    @FXML
    private Label lbRetour;
    @FXML
    private Pane pnMesAnnonces;
    @FXML
    private TableView<Annonces> tvMesAnnonces;
    @FXML
    private TableColumn<Annonces, String> colNom;
    @FXML
    private TableColumn<Annonces, String> colEmail;
    @FXML
    private TableColumn<Annonces, Integer> colNumero;
    @FXML
    private TableColumn<Annonces, String> colAdresse;

    ObservableList<Annonces> list ;
    


    @FXML
    private Button btnSupprimer;

    @FXML
    private Button btnModifier;

    

    @FXML
    private Button btnAjouter;



    @FXML
    private Label lbMesAnnonces;

    @FXML
    private Pane pnNouveau1;

    @FXML
    private Label lbTItreNouveau1;

    @FXML
    private TextField tfNom1;

    @FXML
    private TextField tfEmail1;

    @FXML
    private TextField tfNumero1;

    @FXML
    private TextField tfAdresse1;

  
    @FXML
    private Button btnConfModifier1;

    @FXML
    private Button btnConfAjouter1;

    @FXML
    private Label lbTItreUpdate1;

    @FXML
    private Button btnAnuller1;
    private Label lbNumero;
    @FXML
    private Label lbidAnnonces;
    @FXML
    private HBox hboxbutton;
    @FXML
    private TextField chercher;
    @FXML
    private Button TriNom;
 ServiceAnnonces sp=new ServiceAnnonces();
 public static Annonces currentannonces;
   
    @FXML
    private Button btnAjouterr;
    @FXML
    private Label lbidannoncess;
    @FXML
    private Pane pnLesAnnonces;
    @FXML
    private Label lbLesAnnoncef;
   
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
       @Override
    public void initialize(URL url, ResourceBundle rb) {

        pnMesAnnonces.toFront();
        System.out.println("***************************************");
        fnshow();


        // TODO
    } 
    public void fnshow(){
        ServiceAnnonces sp=new ServiceAnnonces();
         ObservableList<Annonces> list =FXCollections.observableList(sp.afficher()); 

     colNom.setCellValueFactory(new PropertyValueFactory<>("noms"));
     colEmail.setCellValueFactory(new PropertyValueFactory<>("emails"));
     colNumero.setCellValueFactory(new PropertyValueFactory<>("numeros"));
     colAdresse.setCellValueFactory(new PropertyValueFactory<>("adresses"));
     tvMesAnnonces.setItems(list);
     
     
      
    }
    
     
    

    private void fnMenuMesaostes(MouseEvent event) {
        pnMesAnnonces.toFront();
    }

    @FXML
    private void fnMenuNouveau(MouseEvent event) {
        pnNouveau.toFront();
    }

 @FXML
    private void fnfront(MouseEvent event) {
                       try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("front1.fxml"));
            Parent root = loader.load();
            lbRetour.getScene().setRoot(root);
           } catch (IOException ex) {
               System.out.print(ex.getMessage());
        }
    }
    
    
    @FXML
    private void fnSelectiannonces(MouseEvent event) {
         Annonces p = tvMesAnnonces.getSelectionModel().getSelectedItem();
         lbidAnnonces.setText(p.getIds()+"");
         hboxbutton.setVisible(true);
         currentannonces = p;
        // ServiceCategorie sc=new ServiceCategorie();
         //Categorie c=sc.SelectOneCategorie(p.getIdcc());
         //lbCategorie.setText(c.getNomc());
    }

    @FXML
    private void fnAjouter(ActionEvent event) {
        pnNouveau1.toFront();
        //pnNouveau1.toBack();
        System.out.println("boutton clické");
    }

    @FXML
    private void fnSupprimer(ActionEvent event) {
        ServiceAnnonces sp=new ServiceAnnonces();
        System.out.println(lbidAnnonces.getText());
        sp.supprimer(Integer.parseInt(lbidAnnonces.getText()));
        fnshow();
        hboxbutton.setVisible(false);
    }

    @FXML
    private void fnModifier(ActionEvent event) {
        lbTItreNouveau1.setVisible(false);
        lbTItreUpdate1.setVisible(true);
        btnConfAjouter1.setVisible(false);
        btnConfModifier1.setVisible(true);
        pnNouveau1.toFront();
        Annonces p = tvMesAnnonces.getSelectionModel().getSelectedItem();
       //ServiceCategorie sc=new ServiceCategorie();
         //Categorie c=sc.SelectOneCategorie(p.getIdcc());
         //tfCategorie.setValue(c.getNomc());
        tfAdresse1.setText(p.getAdresses());
        tfNumero1.setText(p.getNumeros()+"");
        tfEmail1.setText(p.getEmails());
        tfNom1.setText(p.getNoms());
    }
    

    @FXML
    private void fnAnnuler(ActionEvent event) {
        //tfCategorie.setValue("");
        tfAdresse1.setText("");
        tfNumero1.setText("");
        tfEmail1.setText("");
        tfNom1.setText("");
        pnMesAnnonces.toFront();
    }

    /*@FXML
    private void fnConfAjouter(ActionEvent event) {
        Annonces p=new Annonces();
        p.setAdresses(tfAdresse1.getText());
        p.setIdu(1);
        p.setNumeros(Integer.parseInt(tfNumero1.getText()));
        p.setEmails(tfEmail1.getText());
        p.setNoms(tfNom1.getText());
        ServiceAnnonces sp = new ServiceAnnonces();
        sp.add(p);
        fnshow();
        pnMesAnnonces.toFront();
        tfAdresse1.setText("");
        tfNumero1.setText("");
        tfEmail1.setText("");
        tfNom1.setText("");
    }*/
    
   @FXML
private void fnConfAjouter(ActionEvent event) {
if(tfAdresse1.getText().isEmpty() || tfNumero1.getText().isEmpty() || tfEmail1.getText().isEmpty() || tfNom1.getText().isEmpty()){
// Gestion des champs vides
Alert alert = new Alert(Alert.AlertType.ERROR);
alert.setTitle("Erreur");
alert.setHeaderText(null);
alert.setContentText("Tous les champs sont obligatoires !");
alert.showAndWait();
} else if(!tfEmail1.getText().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")){
// Contrôle de saisie pour l'email
Alert alert = new Alert(Alert.AlertType.ERROR);
alert.setTitle("Erreur");
alert.setHeaderText(null);
alert.setContentText("Veuillez entrer une adresse e-mail valide !");
alert.showAndWait();
} else if(!tfNom1.getText().matches("^[a-zA-Z]+$")){
// Contrôle de saisie pour le nom
Alert alert = new Alert(Alert.AlertType.ERROR);
alert.setTitle("Erreur");
alert.setHeaderText(null);
alert.setContentText("Veuillez entrer un nom valide !");
alert.showAndWait();
} else if(!tfNumero1.getText().matches("^[0-9]+$")){
// Contrôle de saisie pour le numéro
Alert alert = new Alert(Alert.AlertType.ERROR);
alert.setTitle("Erreur");
alert.setHeaderText(null);
alert.setContentText("Veuillez entrer un numéro valide !");
alert.showAndWait();
} else {
Annonces p=new Annonces();
p.setAdresses(tfAdresse1.getText());
p.setIdu(9);
p.setNumeros(Integer.parseInt(tfNumero1.getText()));
p.setEmails(tfEmail1.getText());
p.setNoms(tfNom1.getText());
ServiceAnnonces sp = new ServiceAnnonces();
sp.add(p);
fnshow();
pnMesAnnonces.toFront();
tfAdresse1.setText("");
tfNumero1.setText("");
tfEmail1.setText("");
tfNom1.setText("");
}
}

    

   /* @FXML
    private void fnConfModifier(ActionEvent event) {
        Annonces p=new Annonces();
        
        p.setAdresses(tfAdresse1.getText());
        p.setIdu(1);
        //p.setNumeros(tfNumero.getText());
        p.setEmails(tfEmail1.getText());
        p.setNoms(tfNom1.getText());
        p.setIds(Integer.parseInt(lbidAnnonces.getText()));
        ServiceAnnonces sp = new ServiceAnnonces();
        sp.modifier(p);
        fnshow();
        pnMesAnnonces.toFront();
        tfAdresse1.setText("");
        tfNumero1.setText("");
        tfEmail1.setText("");
        tfNom1.setText("");
       
    }*/

@FXML
    private void fnConfModifier(ActionEvent event) {
        Annonces p=new Annonces();
// Vérifier que tous les champs obligatoires sont remplis
if (tfNom1.getText().isEmpty() || tfAdresse1.getText().isEmpty() || tfEmail1.getText().isEmpty() || tfNumero1.getText().isEmpty()) {
    // Afficher un message d'erreur
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur");
    alert.setHeaderText("Tous les champs sont obligatoires");
    alert.setContentText("Veuillez remplir tous les champs obligatoires.");
    alert.showAndWait();
    return;
}

// Vérifier que le nom est composé uniquement de lettres
if (!tfNom1.getText().matches("[a-zA-Z]+")) {
    // Afficher un message d'erreur
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur");
    alert.setHeaderText("Le nom n'est pas valide");
    alert.setContentText("Le nom doit être composé uniquement de lettres.");
    alert.showAndWait();
    return;
}

// Vérifier que le numéro est composé uniquement de chiffres
if (!tfNumero1.getText().matches("\\d+")) {
    // Afficher un message d'erreur
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur");
    alert.setHeaderText("Le numéro n'est pas valide");
    alert.setContentText("Le numéro doit être composé uniquement de chiffres.");
    alert.showAndWait();
    return;
}

// Vérifier que l'email est au format valide
if (!tfEmail1.getText().matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
    // Afficher un message d'erreur
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur");
    alert.setHeaderText("L'email n'est pas valide");
    alert.setContentText("L'email doit être au format valide (exemple: nom@domaine.com).");
    alert.showAndWait();
    return;
}

p.setAdresses(tfAdresse1.getText());
p.setIdu(9);
p.setNumeros(Integer.parseInt(tfNumero1.getText()));
p.setEmails(tfEmail1.getText());
p.setNoms(tfNom1.getText());
p.setIds(Integer.parseInt(lbidAnnonces.getText()));
ServiceAnnonces sp = new ServiceAnnonces();
sp.modifier(p);
fnshow();
pnMesAnnonces.toFront();
tfAdresse1.setText("");
tfNumero1.setText("");
tfEmail1.setText("");
tfNom1.setText("");

    }


    @FXML
    private void fnMenuMesAnnonces(MouseEvent event) {
                pnMesAnnonces.toFront();

    }

   /* @FXML
    private void Recherche(ActionEvent event) {
      ServiceAnnonces sp=new ServiceAnnonces();
      String chaine = Recherche.getText();
        populateTable(sp.chercherAnnonces(chaine));
    }

    private void populateTable(List<Annonces> RechercheAnnonces) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/

    @FXML
    
    private void Recherche(KeyEvent event) throws SQLException {
                Annonces p=new Annonces();
ServiceAnnonces sp = new ServiceAnnonces();
       tvMesAnnonces.setItems(sp.searchByAnnonces(chercher.getText()))  ;
        
    }

    @FXML
    private void TriNom(ActionEvent event) throws SQLException {
     
   colNom.setCellValueFactory(new PropertyValueFactory<Annonces,String>("noms"));
      colEmail.setCellValueFactory(new PropertyValueFactory<Annonces,String>("emails"));
colNumero.setCellValueFactory(new PropertyValueFactory<Annonces, Integer>("numeros"));
   colAdresse.setCellValueFactory(new PropertyValueFactory<Annonces,String>("adresses"));


  list=sp.getAllTriNom();
       tvMesAnnonces.setItems(list)  ;
    }
   

  

   
}















