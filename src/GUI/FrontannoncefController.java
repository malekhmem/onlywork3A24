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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import static java.time.zone.ZoneRulesProvider.refresh;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.input.KeyEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.logging.log4j.LogManager;


/**
 * FXML Controller class
 *
 * @author imtinen
 */
public class FrontannoncefController implements Initializable {

    @FXML
    private Label lbMesAnnoncef;
    @FXML
    private Label lbNouveau;
    @FXML
    private Label lbRetour;
    @FXML
    private Pane pnNouveau;
    @FXML
    private Label lbTItreNouveau;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfAdresse;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfDescript;

    @FXML
    private Button btnAnuller;
    @FXML
    private Button btnConfModifier;
    @FXML
    private Button btnConfAjouter;
    @FXML
    private Label lbTItreUpdate;
    @FXML
    private Pane pnMesAnnoncef;
    @FXML
    private TableView<Annoncef> tvMesAnnoncef;
    @FXML
    private TableColumn<Annoncef, String> colNom;
    @FXML
    private TableColumn<Annoncef, String> colAdresse;
    @FXML
    private TableColumn<Annoncef, String> colMail;
    @FXML
    private Button btnAjouter;
    @FXML
    private VBox vboxDetail;
    @FXML
    private Label lbDescription;
    @FXML
    private Button btnSupprimer;
    @FXML
    private Button btnModifier;
    @FXML
    private Label lbidannoncef;
    @FXML
    private TableColumn<Annoncef, String> colDescript;
    @FXML
    private TableView<Annoncef> tvLesAnnoncef;
    @FXML
    private Label lbLesAnnoncef;
    @FXML
    private Pane pnLesAnnoncef;
    @FXML
    private TableColumn<Annoncef, String> colNomm;
    @FXML
    private TableColumn<Annoncef, String> colAdressee;
    @FXML
    private TableColumn<Annoncef, String> colMaill;
    @FXML
    private TableColumn<Annoncef, String> colDescriptt;
    @FXML
    private Button btnAjouterr;
    @FXML
    private Label lbidannonceff;
    @FXML
    private TextField chercher;
    @FXML
    private TextField cherche;
    @FXML
    private Button exportButton;
 

    /**
     * Initializes the controller class.
     */
        @Override
    public void initialize(URL url, ResourceBundle rb) {
        pnLesAnnoncef.toFront();
        fnshowtout();
   
      


        // TODO
    }    
    public void fnshow(){
        Serviceannoncef sp=new Serviceannoncef();
         ObservableList<Annoncef> list =FXCollections.observableList(sp.afficherByID(1)); 
     colAdresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
     colMail.setCellValueFactory(new PropertyValueFactory<>("emailf"));
      colNom.setCellValueFactory(new PropertyValueFactory<>("nomf"));
      colDescript.setCellValueFactory(new PropertyValueFactory<>("descf"));
      tvMesAnnoncef.setItems(list);
     
     
      
    }
   public void fnshowtout(){
        Serviceannoncef sp=new Serviceannoncef();
         ObservableList<Annoncef> list =FXCollections.observableList(sp.afficher());   
     colAdressee.setCellValueFactory(new PropertyValueFactory<>("adresse"));
     colMaill.setCellValueFactory(new PropertyValueFactory<>("emailf"));
      colNomm.setCellValueFactory(new PropertyValueFactory<>("nomf"));
      colDescriptt.setCellValueFactory(new PropertyValueFactory<>("descf"));
      tvLesAnnoncef.setItems(list);
     
     
   }


    @FXML
    private void fnMenuNouveau(MouseEvent event) {
        pnNouveau.toFront();
    }

    private void fnSelectionannoncef(MouseEvent event) {
         Annoncef f = tvMesAnnoncef.getSelectionModel().getSelectedItem();
         lbidannoncef.setText(f.getIdf()+"");
         vboxDetail.setVisible(true);
                 fnshow();


    }

    @FXML
    private void fnAjouter(ActionEvent event) {
        pnNouveau.toFront();
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
    private void fnModifier(ActionEvent event) {
        lbTItreNouveau.setVisible(false);
        lbTItreUpdate.setVisible(true);
        btnConfAjouter.setVisible(false);
        btnConfModifier.setVisible(true);
        pnNouveau.toFront();
        Annoncef p = tvMesAnnoncef.getSelectionModel().getSelectedItem();
        tfDescript.setText(p.getDescf());
        tfAdresse.setText(p.getAdresse());
        tfEmail.setText(p.getEmailf());
        tfNom.setText(p.getNomf());
 
    }
    

    @FXML
    private void fnAnnuler(ActionEvent event) {
        tfDescript.setText("");
        tfAdresse.setText("");
        tfEmail.setText("");
        tfNom.setText("");
        pnMesAnnoncef.toFront();
        fnshow();
    }

    @FXML
    private void fnConfAjouter(ActionEvent event) {
String email = tfEmail.getText();
if (email == null || email.isEmpty() || !email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur de saisie");
    alert.setHeaderText("Email invalide");
    alert.setContentText("Veuillez saisir une adresse email valide.");
    alert.showAndWait();
    return; 
}

String adresse = tfAdresse.getText();
if (adresse == null || adresse.isEmpty()) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur de saisie");
    alert.setHeaderText("Adresse manquante");
    alert.setContentText("Veuillez saisir une adresse valide.");
    alert.showAndWait();
    return;
}


String nom = tfNom.getText();
if (nom == null || nom.isEmpty() || !nom.matches("^[a-zA-Z]+$")) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur de saisie");
    alert.setHeaderText("Nom invalide");
    alert.setContentText("Veuillez saisir un nom valide (lettres alphabétiques uniquement).");
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
Annoncef p=new Annoncef();
p.setIdu(1);
p.setDescf(description);
p.setEmailf(email);
p.setAdresse(adresse);
p.setNomf(nom);
Serviceannoncef sp = new Serviceannoncef();
sp.add(p);
fnshow();
fnshowtout();
pnMesAnnoncef.toFront();
tfDescript.setText("");
tfAdresse.setText("");
tfEmail.setText("");
tfNom.setText("");
    
        
    }

    @FXML
    private void fnConfModifier(ActionEvent event) {
String nom = tfNom.getText();
String adresse = tfAdresse.getText();
String email = tfEmail.getText();
String description = tfDescript.getText();

if (nom == null || nom.isEmpty() || !nom.matches("[a-zA-Z]+")) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur de saisie");
    alert.setHeaderText("Nom invalide");
    alert.setContentText("Veuillez saisir un nom valide (lettres uniquement).");
    alert.showAndWait();
    return; 
}

// Vérification de l'adresse
if (adresse == null || adresse.isEmpty()) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur de saisie");
    alert.setHeaderText("Adresse manquante");
    alert.setContentText("Veuillez saisir une adresse valide.");
    alert.showAndWait();
    return; 
}

if (email == null || email.isEmpty() || !email.matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur de saisie");
    alert.setHeaderText("Email invalide");
    alert.setContentText("Veuillez saisir une adresse email valide.");
    alert.showAndWait();
    return; 
}

if (description == null || description.isEmpty()) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur de saisie");
    alert.setHeaderText("Description manquante");
    alert.setContentText("Veuillez saisir une description valide.");
    alert.showAndWait();
    return; 
}


Annoncef p = new Annoncef();
p.setNomf(nom);
p.setAdresse(adresse);
p.setEmailf(email);
p.setDescf(description);
p.setIdu(1);

Serviceannoncef sp = new Serviceannoncef();
sp.add(p);
fnshow();
fnshowtout();
pnMesAnnoncef.toFront();
tfDescript.setText("");
tfAdresse.setText("");
tfEmail.setText("");
tfNom.setText("");

    }

    @FXML
    private void fnMenuMesAnnoncef(MouseEvent event) {
                pnMesAnnoncef.toFront();
                fnshow();
    }

    @FXML
    private void fnSelectiannoncef(MouseEvent event) {
         Annoncef f = tvMesAnnoncef.getSelectionModel().getSelectedItem();
         lbidannoncef.setText(f.getIdf()+"");
         vboxDetail.setVisible(true);
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
    private void fnMenuLesAnnoncef(MouseEvent event) {
                      pnLesAnnoncef.toFront();
        
    }

    @FXML
    private void fnSelectlesannoncef(MouseEvent event) {
         Annoncef f = tvLesAnnoncef.getSelectionModel().getSelectedItem();
        
    }

  

    @FXML
    private void Recherche(KeyEvent event) throws SQLException {
                Annoncef p=new Annoncef();
Serviceannoncef sp = new Serviceannoncef();
       tvLesAnnoncef.setItems(sp.searchByNameAnnoncef(chercher.getText()))  ;
    }

    @FXML
    private void Rechercher(KeyEvent event) throws SQLException {
Annoncef p=new Annoncef();
Serviceannoncef sp = new Serviceannoncef();
       tvMesAnnoncef.setItems(sp.searchByNameAnnoncef(cherche.getText()))  ;
    }
/*
@FXML
private void handleExport(ActionEvent event) {
   FileChooser fileChooser = new FileChooser();
   fileChooser.setTitle("Exporter les annonces");
   fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Fichier Excel (*.xlsx)", "*.xlsx"));
   Stage stage = (Stage) exportButton.getScene().getWindow();
   File file = fileChooser.showSaveDialog(stage);
   if (file != null) {
       try {
           FileOutputStream outputStream;
           if (!file.exists()) {
               file.createNewFile();
           }
           try (XSSFWorkbook workbook = new XSSFWorkbook()) {
               org.apache.poi.ss.usermodel.Sheet sheet = workbook.createSheet("Annoncef");
               Row headerRow = sheet.createRow(0);
               headerRow.createCell(0).setCellValue("nomf");
               headerRow.createCell(1).setCellValue("adresse");
               headerRow.createCell(2).setCellValue("emailf");
               headerRow.createCell(3).setCellValue("descf");
               ObservableList<Annoncef> annonces = tvMesAnnoncef.getItems();
               for (int i = 0; i < annonces.size(); i++) {
                   Annoncef annonce = annonces.get(i);
                   Row row = sheet.createRow(i + 1);
                   row.createCell(0).setCellValue(annonce.getNomf());
                   row.createCell(1).setCellValue(annonce.getAdresse());
                   row.createCell(2).setCellValue(annonce.getEmailf());
                   row.createCell(3).setCellValue(annonce.getDescf());
               }
               outputStream = new FileOutputStream(file);
               workbook.write(outputStream);
           }
           outputStream.close();
       } catch (IOException e) {
       }
   }
}

*/

   /* @FXML
private void handleExport(ActionEvent event) {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Exporter les annonces");
    fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Fichier Excel (.xlsx)", ".xlsx"));
    Stage stage = (Stage) exportButton.getScene().getWindow();
    File file = fileChooser.showSaveDialog(stage);
    if (file != null) {
        try {
            FileOutputStream outputStream;
            if (!file.exists()) {
                file.createNewFile();
            }
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Annoncef");
            XSSFRow headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("nomf");
            headerRow.createCell(1).setCellValue("adresse");
            headerRow.createCell(2).setCellValue("emailf");
            headerRow.createCell(3).setCellValue("descf");
            ObservableList<Annoncef> annonces = tvMesAnnoncef.getItems();

            for (int i = 0; i < annonces.size(); i++) {
                Annoncef annonce = annonces.get(i);
                XSSFRow row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue(annonce.getNomf());
                row.createCell(1).setCellValue(annonce.getAdresse());
                row.createCell(2).setCellValue(annonce.getEmailf());
                row.createCell(3).setCellValue(annonce.getDescf());
            }
            outputStream = new FileOutputStream(file);
            workbook.write(outputStream);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}*/



    /*
   public void handleExport() throws Exception {
    
    PrintWriter writer = new PrintWriter( new OutputStreamWriter(new FileOutputStream("C:\\Users\\imtinen\\Desktop\\annonce.csv"), "UTF-8"));

Serviceannoncef sp = new Serviceannoncef();
        
        List<Annoncef> annonce = sp.afficher();
       writer.write("Nom,Type,Description\n");
               for (Annoncef obj : annonce) {
                   
            writer.write(obj.getNomf().toString());
            writer.write(",");
            writer.write(obj.getAdresse().toString());
            writer.write(",");
            writer.write(obj.getEmailf().toString());
            writer.write("\n");
             writer.write(obj.getDescf().toString());
            writer.write("\n");

               }
               writer.flush();
               writer.close();
}  */
}