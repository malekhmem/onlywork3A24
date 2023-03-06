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
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

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
    @FXML
    private Button exportButton;
    @FXML
    private TableColumn<Materiel, String> colImage;
    @FXML
    private ImageView materielimage;
    @FXML
    private Label filr_path;
    

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
           colImage.setCellValueFactory(new PropertyValueFactory<>("image"));
     tvLesMateriels.setItems(list);
     
     
      
    }
   
    public void updateTable(){
        Servicemateriel sm = new Servicemateriel();
        
        List<Materiel> materiel = sm.afficher();
        ObservableList<Materiel> listM=FXCollections.observableArrayList(materiel);
        colNomm.setCellValueFactory(new PropertyValueFactory<Materiel,String>("nomm"));
        colMarque.setCellValueFactory(new PropertyValueFactory<Materiel,String>("marque"));
        //colPrix.setCellValueFactory(new PropertyValueFactory<Materiel,Integer>("prix"));
        colDescriptt.setCellValueFactory(new PropertyValueFactory<Materiel,String>("descm"));
        colImage.setCellValueFactory(new PropertyValueFactory<Materiel,String>("image"));
        tvLesMateriels.setItems(listM);

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
           Servicemateriel sp=new Servicemateriel();
         Materiel m = tvLesMateriels.getSelectionModel().getSelectedItem();
         lbidmateriel.setText(m.getIdm()+"");
         vboxDetaill.setVisible(true);

        int index = tvLesMateriels.getSelectionModel().getSelectedIndex();
        if (index <= -1){
            return;
        }String picture ="file:" +  colImage.getCellData(index).toString();
        filr_path.setText(colImage.getCellData(index).toString());
    Image image1 = new Image(picture, 110, 110, false, true);            
            materielimage.setImage(image1);
    }
         
    

    @FXML
    private void fnSupprimerr(ActionEvent event) {
                Servicemateriel sp=new Servicemateriel();
        System.out.println(lbidmateriel.getText());
        sp.supprimer(Integer.parseInt(lbidmateriel.getText()));
        fnshowtout();
        vboxDetaill.setVisible(false);
    }

    @FXML
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
            ObservableList<Annoncef> annonces = tvLesAnnoncef.getItems();

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
    }

    @FXML
    private void showStat(ActionEvent event) {
                                       try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("stat.fxml"));
            Parent root = loader.load();
            lbRetour.getScene().setRoot(root);
           } catch (IOException ex) {
               System.out.print(ex.getMessage());
        }
         
   }
    }
  
    

