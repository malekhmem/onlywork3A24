/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import services.ServiceAnnonces;
import services.ServiceEvenement;


import entities.Annonces;
import entities.Evenement;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.QRCodeWriter;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author chino
 */
public class Back1Controller implements Initializable {

    @FXML
    private Label lbLesAnnonces;
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
    private TableColumn<Annonces, String> colEmail;
    @FXML
    private TableColumn<Annonces, Integer> colNumero;
    @FXML
    private TableColumn<Annonces, String> colAdresse;
    @FXML
    private VBox vboxDetail;
    @FXML
    private Button btnSupprimer;
    @FXML
    private Label lbidannonces;
    @FXML
    private Pane pnLesEvenements;
    @FXML
    private TableView<Evenement> tvLesEvenement;
    @FXML
    private TableColumn<Evenement, String> colTitre;
    @FXML
    private TableColumn<Evenement, String> colDescription;
    @FXML
    private TableColumn<Evenement, String> colNoms;
    @FXML
    private VBox vboxDetaill;
    @FXML
    private Label lbAnnonces;
    @FXML
    private Button btnSupprimerr;
    @FXML
    private Label lbidevenement;
    private TextField Recherche;
    @FXML
    private Button TriNom;
    @FXML
    private Button TriTitre;
    @FXML
    private Button PDF; 
    @FXML
    private TextField ann;
    @FXML
    private TextField mayasine;
    @FXML
    private ImageView QRcode;
  

    /**
     * Initializes the controller class.
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
     colEmail.setCellValueFactory(new PropertyValueFactory<>("emails"));
      colNom.setCellValueFactory(new PropertyValueFactory<>("noms"));
      colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
      tvLesAnnonces.setItems(list);
     
     
   }
 public void fnshowtout(){
        ServiceEvenement sp=new ServiceEvenement();
         ObservableList<Evenement> list =FXCollections.observableList(sp.afficher()); 
     
     
     colTitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
     colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
          colNoms.setCellValueFactory(new PropertyValueFactory<>("nomss"));
     tvLesEvenement.setItems(list);
     
     
      
    }

    @FXML
    private void fnMenuLesAnnonces(MouseEvent event) {
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
            Parent root = loader.load();
            lbRetour.getScene().setRoot(root);
           } catch (IOException ex) {
               System.out.print(ex.getMessage());
        }
    }

    @FXML
    private void fnSelectiannonces(MouseEvent event) {
         Annonces f = tvLesAnnonces.getSelectionModel().getSelectedItem();
         lbidannonces.setText(f.getIds()+"");
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
         Evenement m = tvLesEvenement.getSelectionModel().getSelectedItem();
         lbidevenement.setText(m.getIde()+"");
         vboxDetaill.setVisible(true);
         ServiceAnnonces sc=new ServiceAnnonces();
         Annonces f=sc.SelectOneAnnonces(m.getIds());
         lbAnnonces.setText(f.getNoms());
    }

    @FXML
    private void fnSupprimerr(ActionEvent event) {
         ServiceEvenement sp=new ServiceEvenement();
        System.out.println(lbidevenement.getText());
        sp.supprimer(Integer.parseInt(lbidevenement.getText()));
        fnshowtout();
        vboxDetaill.setVisible(false);
    }
    
     @FXML
    private void ann(KeyEvent event)throws SQLException   {
        Annonces p=new Annonces();
ServiceAnnonces sp = new ServiceAnnonces();
       tvLesAnnonces.setItems(sp.searchByAnnonces(ann.getText()))  ;
    }

    @FXML
    private void mayasine(KeyEvent event) throws SQLException  {
        Evenement p=new Evenement();
ServiceEvenement sp = new ServiceEvenement();
       tvLesEvenement.setItems(sp.searchByEvenement(mayasine.getText()))  ;
    }

      @FXML
    private void TriNom(ActionEvent event) throws SQLException {
     
   colNom.setCellValueFactory(new PropertyValueFactory<Annonces,String>("noms"));
      colEmail.setCellValueFactory(new PropertyValueFactory<Annonces,String>("emails"));
colNumero.setCellValueFactory(new PropertyValueFactory<Annonces, Integer>("numeros"));
   colAdresse.setCellValueFactory(new PropertyValueFactory<Annonces,String>("adresses"));

ServiceAnnonces sp = new ServiceAnnonces();
         ObservableList<Annonces> list ;

  list=sp.getAllTriNom();
       tvLesAnnonces.setItems(list)  ;
    }

    @FXML
    private void TriTitre(ActionEvent event) {
          colTitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
      colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
   colNom.setCellValueFactory(new PropertyValueFactory<>("nomss"));

ServiceEvenement sp = new ServiceEvenement();
 ObservableList<Evenement> list ;

  list=sp.getAllTriTitre();
       tvLesEvenement.setItems(list)  ;
        
    }

    @FXML
private void btnGenPDF(ActionEvent event) throws DocumentException, FileNotFoundException, IOException {
    long millis = System.currentTimeMillis();
    java.sql.Date DateRapport = new java.sql.Date(millis);

    String DateLyoum = new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH).format(DateRapport);
    System.out.println("Date d'aujourdhui : " + DateLyoum);

    com.itextpdf.text.Document document = new com.itextpdf.text.Document();

    try {
         com.itextpdf.text.Image img = com.itextpdf.text.Image.getInstance("C:\\Users\\bouchrit\\Videos\\logo.png");
               img.scaleAbsoluteWidth(200);
               img.scaleAbsoluteHeight(50);
               img.setAlignment(com.itextpdf.text.Image.ALIGN_CENTER);
        
        PdfWriter.getInstance(document, new FileOutputStream(String.valueOf(DateLyoum + ".pdf")));
        document.open();
                        document.add(img);

// Ajouter le logo
       /* Image logo = Image.getInstance("C://xampp//htdocs//onlywork/logo.png");
        logo.scaleAbsolute(100, 100);
        logo.setAlignment(Element.ALIGN_CENTER);
        document.add(logo);*/
        // Ajouter un titre avec un style personnalisé
        Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLUE);
        Paragraph title = new Paragraph("Rapport détaillé de notre application", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        // Ajouter un paragraphe avec un style personnalisé
        Font paragraphFont = FontFactory.getFont(FontFactory.TIMES, 14, BaseColor.BLACK);
        Paragraph ph1 = new Paragraph("Voici un rapport détaillé de notre application qui contient tous les événements. Pour chaque événement, nous fournissons des informations telles que la date d'aujourd'hui : " + DateRapport, paragraphFont);
        ph1.setSpacingAfter(10);
        document.add(ph1);

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);

        // Créer une cellule avec un style personnalisé
        Font cellFont = FontFactory.getFont(FontFactory.TIMES, 12, BaseColor.WHITE);
        PdfPCell cell = new PdfPCell(new Phrase("Titre", cellFont));
        cell.setBackgroundColor(BaseColor.BLUE);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Description", cellFont));
        cell.setBackgroundColor(BaseColor.BLUE);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Nom société", cellFont));
        cell.setBackgroundColor(BaseColor.BLUE);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
   ServiceEvenement sp = new ServiceEvenement();

        Evenement r = new Evenement();
        sp.afficher().forEach(e -> {
            table.addCell(String.valueOf(e.getTitre()));
            table.addCell(String.valueOf(e.getDescription()));
            table.addCell(String.valueOf(e.getNomss()));
        });

        document.add(table);
    } catch (Exception e) {
        System.out.println(e);
    }
    document.close();

    // Ouvrir le fichier PDF
    File file = new File(DateLyoum + ".pdf");
    Desktop desktop = Desktop.getDesktop();
    if (file.exists()) {
        desktop.open(file);
    }
}




  

    
    
   
    

    }
    

    
    

