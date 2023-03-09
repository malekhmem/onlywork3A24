/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Evenement;
import services.ServiceEvenement;

import entities.Evenement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import services.ServiceEvenement;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;
import java.sql.SQLException;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;

import java.awt.image.BufferedImage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import com.google.zxing.qrcode.encoder.QRCode;
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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;
/**
 *
 * @author chino
 */
public class EvenementFrontController implements Initializable {


    @FXML
    private Label lbMesEvenement;
    private Label lbTitre;


    @FXML
    private Label lbNouveau;

    @FXML
    private Label lbRetour;

    @FXML
    private Pane pnNouveau;

    @FXML
    private Label lbTItreNouveau;

    @FXML
    private TextField tfTitre;
    
    private TextField tfNumero;


    @FXML
    private TextField tfDescription;

    @FXML
    private TextField tfNom_societe;

    @FXML
    private Button btnAnuller;

    @FXML
    private Button btnConfModifier;

    @FXML
    private Button btnConfAjouter;

    @FXML
    private Label lbTItreUpdate;

    @FXML
    private Pane pnMesEvenement;
   
    @FXML
    private TableView<Evenement> tvMesEvenement;

    @FXML
    private TableColumn<Evenement, String> colTitre;

    @FXML
    private TableColumn<Evenement, String> colDescription;

    @FXML
    private TableColumn<Evenement, String> colNom_societe;
 ObservableList<Evenement> list ;

    @FXML
    private Button btnAjouter;

    @FXML
    private VBox vboxDetail;

    @FXML
    private Button btnSupprimer;

    @FXML
    private Button btnModifier;

    private Label lbidEvenement;
    @FXML
    private Label lbidevenement;
    @FXML
    private TextField chercher;
    @FXML
    private Button TriTitre;
   ServiceEvenement sp = new ServiceEvenement();
    @FXML
    private ImageView QRcode;
    @FXML
    private Button PDF;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
       //@Override
    public void initialize(URL url, ResourceBundle rb) {
        pnMesEvenement.toFront();
       // tfNom_societe.setText(AnnoncesFrontController.currentannonces.getNoms());
        System.out.println("+++++++++++++++++");
        fnshow();

        // TODO
    } 
    public void fnshow(){
        ServiceEvenement sp=new ServiceEvenement();
         ObservableList<Evenement> list =FXCollections.observableList(sp.afficher()); 
     
     colTitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
     colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
     colNom_societe.setCellValueFactory(new PropertyValueFactory<>("nomss"));
     tvMesEvenement.setItems(list);
     
     
      
    }

    private void fnMenuMesaostes(MouseEvent event) {
        pnMesEvenement.toFront();
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
    void fnAjouter(ActionEvent event) {
        pnNouveau.toFront();

    }

    
    @FXML
    private void fnSupprimer(ActionEvent event) {
        ServiceEvenement sp=new ServiceEvenement();
        System.out.println(lbidevenement.getText());
        sp.supprimer(Integer.parseInt(lbidevenement.getText()));
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
        Evenement p =  tvMesEvenement.getSelectionModel().getSelectedItem();
       //ServiceCategorie sc=new ServiceCategorie();
         //Categorie c=sc.SelectOneCategorie(p.getIdcc());
         //tfCategorie.setValue(c.getNomc());
        tfNom_societe.setText(p.getNomss());
        tfDescription.setText(p.getDescription());
        tfTitre.setText(p.getTitre());
    }
    
    @FXML
    private void fnAnnuler(ActionEvent event) {
        //tfCategorie.setValue("");
        tfNom_societe.setText("");
        tfDescription.setText("");
        tfTitre.setText("");
        pnMesEvenement.toFront();
    }
    
   /* @FXML
    void fnConfAjouter(ActionEvent event) {
       Evenement p=new Evenement();
        p.setNomss(tfNom_societe.getText());
        p.setDescription(tfDescription.getText());
        p.setTitre(tfTitre.getText());
        ServiceEvenement sp = new ServiceEvenement();
        sp.add(p);
        fnshow();
        pnMesEvenement.toFront();
        tfNom_societe.setText("");
        tfDescription.setText("");
        tfTitre.setText("");

    }*/

    
        @FXML
void fnConfAjouter(ActionEvent event) {
if (tfNom_societe.getText().isEmpty() || !tfNom_societe.getText().matches("^[a-zA-Z]+$")) {
// Afficher un message d'erreur et sortir de la fonction si le champ nom n'est pas valide
Alert alert = new Alert(AlertType.ERROR, "Le champ nom societe est invalide !");
alert.showAndWait();
return;
}
if (tfTitre.getText().isEmpty()) {
// Afficher un message d'erreur et sortir de la fonction si le champ titre est vide
Alert alert = new Alert(AlertType.ERROR, "Le champ titre est obligatoire !");
alert.showAndWait();
return;
}
if (tfDescription.getText().isEmpty()) {
// Afficher un message d'erreur et sortir de la fonction si le champ description est vide
Alert alert = new Alert(AlertType.ERROR, "Le champ description est obligatoire !");
alert.showAndWait();
return;

}
Evenement p=new Evenement();
p.setNomss(tfNom_societe.getText());
p.setDescription(tfDescription.getText());
p.setTitre(tfTitre.getText());
//p.setIds(AnnoncesFrontController.currentannonces.getIds());
ServiceEvenement sp = new ServiceEvenement();
sp.add(p);
fnshow();
pnMesEvenement.toFront();
tfNom_societe.setText("");
tfDescription.setText("");
tfTitre.setText("");
}
    
    
    /*@FXML
    void fnConfModifier(ActionEvent event) {
 Evenement p=new Evenement();
        p.setIde(Integer.parseInt(lbidevenement.getText()));
        p.setNomss(tfNom_societe.getText());
        p.setDescription(tfDescription.getText());
        p.setTitre(tfTitre.getText());
        p.setIds(1);
        ServiceEvenement sp = new ServiceEvenement();
        sp.modifier(p);
        fnshow();
        pnMesEvenement.toFront();
        tfNom_societe.setText("");
        tfDescription.setText("");
        tfTitre.setText("");

    }*/


@FXML
    void fnConfModifier(ActionEvent event) {
        Evenement p=new Evenement();
         p.setIde(Integer.parseInt(lbidevenement.getText()));
        // Contrôle de saisie pour le nom de la société (seuls les alphabets sont autorisés)
String nomSociete = tfNom_societe.getText().trim();
if (nomSociete.isEmpty()) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setHeaderText("Erreur de saisie");
    alert.setContentText("Le nom de la société est requis");
    alert.showAndWait();
    return;
} else if (!nomSociete.matches("[a-zA-Z]+")) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setHeaderText("Erreur de saisie");
    alert.setContentText("Le nom de la société ne doit contenir que des lettres alphabétiques");
    alert.showAndWait();
    return;
}
p.setNomss(nomSociete);

// Contrôle de saisie pour la description
String description = tfDescription.getText().trim();
if (description.isEmpty()) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setHeaderText("Erreur de saisie");
    alert.setContentText("La description de l'événement est requise");
    alert.showAndWait();
    return;
}
p.setDescription(description);

// Contrôle de saisie pour le titre
String titre = tfTitre.getText().trim();
if (titre.isEmpty()) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setHeaderText("Erreur de saisie");
    alert.setContentText("Le titre de l'événement est requis");
    alert.showAndWait();
    return;
}
p.setTitre(titre);

p.setIds(1); // à modifier si nécessaire

// Modification de l'événement dans la base de données
ServiceEvenement sp = new ServiceEvenement();
sp.modifier(p);

// Actualisation de l'affichage
fnshow();
pnMesEvenement.toFront();

// Réinitialisation des champs de saisie
tfNom_societe.setText("");
tfDescription.setText("");
tfTitre.setText("");
lbTItreUpdate.setVisible(false);
btnConfModifier.setVisible(false);
lbTItreNouveau.setVisible(true);
btnConfAjouter.setVisible(true);
        
    }




    @FXML
    private void fnMenuMesEvenement(MouseEvent event) {
        pnMesEvenement.toFront();
    }

   


    @FXML
    private void fnSelectionEvenemnt(MouseEvent event) {
        Evenement f = tvMesEvenement.getSelectionModel().getSelectedItem();
         lbidevenement.setText(f.getIde()+"");
         vboxDetail.setVisible(true);
         start(f);
    }

    @FXML
    private void Recherche(KeyEvent event) throws SQLException {
        
         Evenement p=new Evenement();
ServiceEvenement sp = new ServiceEvenement();
       tvMesEvenement.setItems(sp.searchByEvenement(chercher.getText()))  ;
    }

    @FXML
    private void TriTitre(ActionEvent event) {
        colTitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
      colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
   colNom_societe.setCellValueFactory(new PropertyValueFactory<>("nomss"));


  list=sp.getAllTriTitre();
       tvMesEvenement.setItems(list)  ;
    }

    /*
    
  private void setChosenEvent(Evenement e) throws IOException {
        Evenement EventPie = new Evenement();
        int nbPie = 0;
        colTitre.setText(e.getTitre());
        colTitre.setText(e.getTitre());
        colNom_societe.setText(e.getNomss());

        try {

        ServiceEvenement sp=new ServiceEvenement();
            String filename = sp.GenerateQrEvent(e);
            System.out.println("filename lenaaa " + filename);
            Image image = new Image(getClass().getResourceAsStream("/tn/esprit/utils/img/" + filename));
            QrCode.setImage(image);

        } catch (Exception ex) {
            System.out.println("mafamesh qr");
        }

        tvMesEvenement.setStyle("-fx-background-color: #DEEFBD" + ";\n"
                + "    -fx-background-radius: 30;");
    }

*/

   /* @FXML
    private void btnGenPDF(ActionEvent event) throws DocumentException, FileNotFoundException, IOException  {
        long millis = System.currentTimeMillis();
        java.sql.Date DateRapport = new java.sql.Date(millis);

        String DateLyoum = new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH).format(DateRapport);//yyyyMMddHHmmss
        System.out.println("Date d'aujourdhui : " + DateLyoum);

        com.itextpdf.text.Document document = new com.itextpdf.text.Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(String.valueOf(DateLyoum + ".pdf")));//yyyy-MM-dd
            document.open();
            Paragraph ph1 = new Paragraph("Voici un rapport détaillé de notre application qui contient tous les événements . Pour chaque événement, nous fournissons des informations telles que la date d'aujourdhui :" + DateRapport );
            Paragraph ph2 = new Paragraph(".");
            PdfPTable table = new PdfPTable(3);

            //On créer l'objet cellule.
            PdfPCell cell;

            //contenu du tableau.
            table.addCell("titre");
            table.addCell("description");
            table.addCell("nom_societe");
            Evenement r = new Evenement();
            sp.afficher().forEach(e
                    -> {
                table.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(String.valueOf(e.getTitre()));
                table.addCell(String.valueOf(e.getDescription()));
                table.addCell(String.valueOf(e.getNomss()));

            }
            );
            document.add(ph1);
            document.add(ph2);
            document.add(table);
            //  document.addAuthor("Bike");
            // AlertDialog.showNotification("Creation PDF ", "Votre fichier PDF a ete cree avec success", AlertDialog.image_checked);
        } catch (Exception e) {
            System.out.println(e);
        }
        document.close();

        ///Open FilePdf
        File file = new File(DateLyoum + ".pdf");
        Desktop desktop = Desktop.getDesktop();
        if (file.exists()) //checks file exists or not  
        {
            desktop.open(file); //opens the specified file   
        }
        
    }*/
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
        Paragraph title = new Paragraph("LES EVENEMENTS DISPONIBLE DANS NOTRE APPLICATION", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        // Ajouter un paragraphe avec un style personnalisé
        Font paragraphFont = FontFactory.getFont(FontFactory.TIMES, 14, BaseColor.BLACK);
        Paragraph ph1 = new Paragraph("Voici un rapport détaillé des evenements disponobles de notre application . Pour chaque événement, nous fournissons des informations telles que la date d'aujourd'hui : " + DateRapport, paragraphFont);
        ph1.setSpacingAfter(10);
        document.add(ph1);

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);

        // Créer une cellule avec un style personnalisé
        Font cellFont = FontFactory.getFont(FontFactory.TIMES, 12, BaseColor.WHITE);
        PdfPCell cell = new PdfPCell(new Phrase("Titre", cellFont));
        cell.setBackgroundColor(BaseColor.DARK_GRAY);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Description", cellFont));
        cell.setBackgroundColor(BaseColor.DARK_GRAY);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("Nom société", cellFont));
        cell.setBackgroundColor(BaseColor.DARK_GRAY);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

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


public void start(Evenement u) {

    QRCodeWriter QRCodeWriter;
    
    QRCodeWriter qrCodeWriter = new QRCodeWriter();
    String myWeb = "titre evenemment : " +u.getTitre()+"\n"+"description : "+u.getDescription()+"\n"+"nom société : "+u.getNomss();
    int width = 300;
    int height = 300;
    String fileType = "png";
    
    BufferedImage bufferedImage = null;
    try {
        BitMatrix byteMatrix = qrCodeWriter.encode(myWeb, BarcodeFormat.QR_CODE, width, height);
        //BitMatrix byteMatrix = qrCodeWriter.encode(myData, BarcodeFormat.QR_CODE, width, height);
        bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        bufferedImage.createGraphics();
        
        Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, width, height);
        graphics.setColor(Color.BLACK);
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (byteMatrix.get(i, j)) {
                    graphics.fillRect(i, j, 1, 1);
                }
            }
        }

        ImageView qrView = new ImageView();
        qrView.setImage(SwingFXUtils.toFXImage(bufferedImage, null));

        StackPane root = new StackPane();
        root.getChildren().add(qrView);

        Scene scene = new Scene(root, 350, 350);

        Stage stage = new Stage();
        stage.setTitle("QR Code");
        stage.setScene(scene);
        stage.show();

        System.out.println("Success...");
        
    } catch (WriterException ex) {
      //  Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
    }
}
 
    /*public void start(Evenement u) {
        
        QRCodeWriter QRCodeWriter;
        
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        String myWeb = u.getTitre();
        int width = 300;
        int height = 300;
        String fileType = "png";
        
        BufferedImage bufferedImage = null;
        try {
            BitMatrix byteMatrix = qrCodeWriter.encode(myWeb, BarcodeFormat.QR_CODE, width, height);
            bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            bufferedImage.createGraphics();
            
            Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, width, height);
            graphics.setColor(Color.BLACK);
            if(bufferedImage!=null){
                System.out.println("hello world");
            }else{
                System.out.println("null");
            }
            ImageView qrView = new ImageView();
        qrView.setImage(SwingFXUtils.toFXImage(bufferedImage, null));
                
        QRcode.setImage(qrView.getImage());
            
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }


System.out.println("Success...");
            
        } catch (WriterException ex) {
            Logger.getLogger(NewFXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        //StackPane root = new StackPane();
        /*root.getChildren().add(qrView);
        
        Scene scene = new Scene(root, 350, 350);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }*/
    private void QR(ActionEvent event) {
          Evenement u = tvMesEvenement.getSelectionModel().getSelectedItem();
        if (u == null) {
            //veuillez selectionner une liiiiiiiiiiiiiiiigne
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Erreur !");
            alert1.setHeaderText(null);
            alert1.setContentText("veuillez selectionner une ligne du tableau puis appuyez sur le bouton recuperer");
            alert1.show();

        } else {
        
        start(u);
    }
    }

 
    
}









