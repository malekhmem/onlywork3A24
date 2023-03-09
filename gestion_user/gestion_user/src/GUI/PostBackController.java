/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.itextpdf.text.BadElementException;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import entities.Categorie;
import entities.Poste;
import services.ServiceCategorie;
import services.ServicePoste;
//import com.google.common.io.FileBackedOutputStream;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Header;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import static com.itextpdf.text.PageSize.A4;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.scenario.effect.ImageData;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableRow;
import javafx.scene.Parent;


/**
 * FXML Controller class
 *
 * @author zeine
 */
public class PostBackController implements Initializable {

    @FXML
    private Label lbMesPoste;
    @FXML
    private Label lbNouveau;
    @FXML
    private Label lbRetour;
    @FXML
    private Pane pnMesPostes;
    @FXML
    private TableView<Poste> tvMesPostes;
    @FXML
    private TableColumn<Poste, String> colNom;
    @FXML
    private TableColumn<Poste, String> colDomain;
    @FXML
    private TableColumn<Poste, String> colMail;
    @FXML
    private VBox vboxDetail;
    @FXML
    private Label lbCategorie;
    @FXML
    private Label lbDescription;
    @FXML
    private Button btnSupprimer;
    @FXML
    private Label lbidposte;
    @FXML
    private Pane pnCategorie;
    @FXML
    private TableView<Categorie> tvViewCat;
    @FXML
    private TableColumn<Categorie, String> colCat;
    @FXML
    private Button btnAjouterC;
    @FXML
    private Button btnModifierC;
    @FXML
    private Button btnSupprimerC;
    @FXML
    private Pane pnCatAj;
    @FXML
    private TextField tfNomCat;
    @FXML
    private Button btnConfAjouterC;
    @FXML
    private Button btnConfModifierC;
    @FXML
    private Label lbidcat;
    @FXML
    private Button btnExporter;
    @FXML
    private ComboBox<String> CbRecherchePoste;
    @FXML
    private TextField tfRecherchePost;
    @FXML
    private TextField tfRechercheCategorie;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pnMesPostes.toFront();
        fnshow();
        // TODO
        ServiceCategorie sc=new ServiceCategorie();
        ObservableList<String>  list =FXCollections.observableArrayList(sc.afficherNom()); // TODO
        for(int i = 0 ; i<list.size();i++){
            System.out.println("========");
            System.out.println(list.get(i));
        }
    CbRecherchePoste.setItems(list);
    }    
    
    public void fnshow(){
        ServicePoste sp=new ServicePoste();
         ObservableList<Poste> list =FXCollections.observableList(sp.afficher()); 
     
     
     colDomain.setCellValueFactory(new PropertyValueFactory<>("domaine"));
     colMail.setCellValueFactory(new PropertyValueFactory<>("emailp"));
          colNom.setCellValueFactory(new PropertyValueFactory<>("nomp"));
     tvMesPostes.setItems(list);
     tvMesPostes.setRowFactory(tv -> new TableRow<Poste>() {
    @Override
    protected void updateItem(Poste item, boolean empty) {
        super.updateItem(item, empty);
        
    }
});
      
    FilteredList<Poste> filteredData = new FilteredList<>(list, b -> true);
		
		tfRecherchePost.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(Poste -> {
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (Poste.getDomaine().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; 
				} else if(String.valueOf(Poste.getNomp()).toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; 
				} else if(String.valueOf(Poste.getEmailp()).toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true;
				}
				     else  
				    	 return false;
			});
		});
                
                CbRecherchePoste.valueProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(Poste -> {
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (Poste.getCategorie().getNomc().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; 
				} 
				     else  
				    	 return false;
			});
		});
		
		SortedList<Poste> sortedData = new SortedList<>(filteredData);

		sortedData.comparatorProperty().bind(tvMesPostes.comparatorProperty());
		
		tvMesPostes.setItems(sortedData);
     
      
    }

    @FXML
    private void fnMenuMesPostes(MouseEvent event) {
        pnMesPostes.toFront();
    }

    @FXML
    private void fnMenuNouveau(MouseEvent event) {
        pnCategorie.toFront();
        fnShowCat();
    }

    @FXML
    private void fnSelectionPoste(MouseEvent event) {
        Poste p = tvMesPostes.getSelectionModel().getSelectedItem();
         lbidposte.setText(p.getIdp()+"");
         vboxDetail.setVisible(true);
         lbDescription.setText(p.getDescp());
         ServiceCategorie sc=new ServiceCategorie();
         Categorie c=sc.SelectOneCategorie(p.getIdcc());
         lbCategorie.setText(c.getNomc());
    }

    @FXML
    private void fnSupprimer(ActionEvent event) {
        ServicePoste sp=new ServicePoste();
        System.out.println(lbidposte.getText());
        sp.supprimer(Integer.parseInt(lbidposte.getText()));
        fnshow();
        vboxDetail.setVisible(false);
    }

    @FXML
    private void fnAjouterC(ActionEvent event) {
         btnConfModifierC.setVisible(false);
        btnConfAjouterC.setVisible(true);
        tfNomCat.setText("");
        pnCatAj.toFront();
    }

    @FXML
    private void fnModifierC(ActionEvent event) {
        btnConfModifierC.setVisible(true);
        btnConfAjouterC.setVisible(false);
        int id=Integer.parseInt(lbidcat.getText());
        ServiceCategorie sc = new ServiceCategorie();
        Categorie c=sc.SelectOneCategorie(id);
        tfNomCat.setText(c.getNomc());
        pnCatAj.toFront();
    }

    @FXML
    private void fnSupprimerC(ActionEvent event) {
        ServiceCategorie sc=new ServiceCategorie();
        sc.supprimer(Integer.parseInt(lbidcat.getText()));
        fnShowCat();
    }

    private void fnShowCat() {
        
        ServiceCategorie sp=new ServiceCategorie();
         ObservableList<Categorie> list =FXCollections.observableList(sp.afficher()); 
     
     
     colCat.setCellValueFactory(new PropertyValueFactory<>("nomc"));
     tvViewCat.setItems(list);
     tvViewCat.setRowFactory(tv -> new TableRow<Categorie>() {
    @Override
    protected void updateItem(Categorie item, boolean empty) {
        super.updateItem(item, empty);
        
    }
});
      
    FilteredList<Categorie> filteredData = new FilteredList<>(list, b -> true);
		
		tfRechercheCategorie.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(Categorie -> {
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (Categorie.getNomc().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; 
				} 
				     else  
				    	 return false;
			});
		});
		
		SortedList<Categorie> sortedData = new SortedList<>(filteredData);

		sortedData.comparatorProperty().bind(tvViewCat.comparatorProperty());
		
		tvViewCat.setItems(sortedData);
    }

    @FXML
    private void fnConfAjouterC(ActionEvent event) {
        /*ServiceCategorie sc= new ServiceCategorie();
        Categorie c=new Categorie();
        c.setNomc(tfNomCat.getText());
        sc.add(c);
        fnShowCat();
        pnCategorie.toFront();*/
        if (!tfNomCat.getText().isEmpty() && tfNomCat.getText().matches("[a-zA-Z]+")) {
    ServiceCategorie sc = new ServiceCategorie();
    Categorie c = new Categorie();
    c.setNomc(tfNomCat.getText());
    sc.add(c);
    fnShowCat();
    pnCategorie.toFront();
    tfNomCat.setText("");
} else {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur de saisie");
    alert.setHeaderText("Veuillez saisir un nom de catégorie valide !");
    alert.showAndWait();
}

    }

    @FXML
    private void fnConfModifierC(ActionEvent event) {
        /*int id=Integer.parseInt(lbidcat.getText());
        ServiceCategorie sc = new ServiceCategorie();
        Categorie c=sc.SelectOneCategorie(id);
        c.setNomc(tfNomCat.getText());
        sc.modifier(c);
        fnShowCat();
        pnCategorie.toFront();*/
        if (!tfNomCat.getText().isEmpty() && tfNomCat.getText().matches("[a-zA-Z]+")) {
    int id=Integer.parseInt(lbidcat.getText());
    ServiceCategorie sc = new ServiceCategorie();
    Categorie c=sc.SelectOneCategorie(id);
    c.setNomc(tfNomCat.getText());
    sc.modifier(c);
    fnShowCat();
    pnCategorie.toFront();
    tfNomCat.setText("");
} else {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur de saisie");
    alert.setHeaderText("Veuillez saisir un nom de catégorie valide !");
    alert.showAndWait();
}

    }

    @FXML
    private void fnSelectedCat(MouseEvent event) {
         Categorie c = tvViewCat.getSelectionModel().getSelectedItem();
         System.out.println(c.getIdc()+"___________dsgsdgsdfsdfsd");
         lbidcat.setText(c.getIdc()+"");
         btnSupprimerC.setVisible(true);
         btnModifierC.setVisible(true);
    }

  @FXML
    private void fnPdf(ActionEvent event) throws BadElementException, FileNotFoundException, IOException {
        
        FileChooser fc=new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF FILE","*.pdf"));
        fc.setTitle("Save to PDF");
        fc.setInitialFileName("Untitled.pdf");
        Stage window = (Stage)pnMesPostes.getScene().getWindow();
        File file = fc.showSaveDialog(window);
        if(file!=null){
            String str = file.getAbsolutePath();
            Document doc=new Document();
            try{
            PdfWriter writer=PdfWriter.getInstance(doc, new FileOutputStream(str));
            doc.open();
            String imgSrc="Header.jpg";
            Image image=Image.getInstance(imgSrc);
            image.scalePercent(10, 5);
             
            
            
             PdfPTable pdfTableFooter1= new PdfPTable(1);
            PdfPCell cell1 =new PdfPCell(image);
            cell1.setBorderWidth(0);
            pdfTableFooter1.addCell(cell1);
            
            
            
                 image.setAlignment(Element.ALIGN_CENTER);
                 image.setAbsolutePosition(450, 750);
                 
         /*   PdfContentByte canvas = writer.getDirectContent();
            String titre="Postes";
            Font f = new Font(Font.FontFamily.TIMES_ROMAN, 25.0f, Font.BOLD, BaseColor.BLACK);
            Phrase tite=new Phrase(titre, f);
            
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, tite, 250, 750, 0);*/
            
         
            doc.add(image);
            PdfPTable table = new PdfPTable(5);
            
            table.setTotalWidth(1000);
            Phrase o1=new Phrase("Nom");
            Phrase o2=new Phrase("Domaine");
            Phrase o3=new Phrase("Description");
            Phrase o4=new Phrase("Email");
            Phrase o5=new Phrase("Categorie");
           PdfPCell obj=new PdfPCell(o1);
           obj.setBackgroundColor(BaseColor.LIGHT_GRAY);
           
           PdfPCell prx=new PdfPCell(o2);
           prx.setBackgroundColor(BaseColor.LIGHT_GRAY);
           
           PdfPCell prx1=new PdfPCell(o3);
           prx1.setBackgroundColor(BaseColor.LIGHT_GRAY);
           PdfPCell prx2=new PdfPCell(o4);
           prx2.setBackgroundColor(BaseColor.LIGHT_GRAY);
           PdfPCell prx3=new PdfPCell(o5);
           prx3.setBackgroundColor(BaseColor.LIGHT_GRAY);
           
           table.addCell(obj);
           table.addCell(prx);
           table.addCell(prx1);
           table.addCell(prx2);
           table.addCell(prx3);
             List<Poste> items = tvMesPostes.getItems();
             for (Poste comm : items) {
             table.addCell(""+comm.getNomp());
             table.addCell(comm.getDomaine());
             table.addCell(comm.getDescp());
             table.addCell(comm.getEmailp());
             table.addCell(comm.getCategorie().getNomc());
             }
           doc.addTitle("Postes");
           //Create Paragraph
        Paragraph paragraph = new Paragraph("Postes :", new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD));

        //New line
        paragraph.add(new Paragraph(" "));
        paragraph.add(new Paragraph(" "));
        doc.add(paragraph);
           doc.add(table);
            
            doc.close();
            }catch(DocumentException e){
                e.printStackTrace();
            }catch(FileNotFoundException e){
                e.printStackTrace();
            }
            
        }
    }
    

    

    @FXML
    private void fnreturn(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("home.fxml"));
            Parent root = loader.load();
            lbRetour.getScene().setRoot(root);
           } catch (IOException ex) {
               System.out.print(ex.getMessage());
        }
    }
    
}
