/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.Annoncef;
import entities.Annonces;
import entities.Categorie;
import entities.Evenement;
import entities.Materiel;
import entities.Poste;
import java.io.IOException;
import java.net.URL;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import services.ServiceAnnonces;
import services.ServiceCategorie;
import services.ServiceEvenement;
import services.ServicePoste;
import services.Serviceannoncef;
import services.Servicemateriel;

/**
 * FXML Controller class
 *
 * @author bouchrit
 */
public class ConsulterController implements Initializable {

    @FXML
    private Label lbLesAnnoncef;
    @FXML
    private Label lbLesMateriels;
    @FXML
    private Label lbLesPostes;
    @FXML
    private Label lbLesAnnonces;
    @FXML
    private Label lbLesEvenements;
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
    private Label lbidannoncef;
    @FXML
    private Pane pnLesMateriels;
    @FXML
    private TableView<Materiel>tvLesMateriels;
    @FXML
    private TableColumn<Materiel, String> colDescriptt;
    @FXML
    private TableColumn<Poste, String> colNomp;
    @FXML
    private VBox vboxDetail;
    @FXML
    private Label lbCategorie;
    @FXML
    private Label lbDescription;
    @FXML
    private Pane pnLesAnnonces;
    @FXML
    private TableView<Annonces> tvLesAnnonces;
    @FXML
    private TableColumn<Evenement, String> colNoms;
    @FXML
    private TableColumn<Annonces, String> colEmail;
    @FXML
    private TableColumn<Annonces, Integer> colNumero;
    @FXML
    private TableColumn<Annonces, String> colAdresses;
    @FXML
    private Label lbidannonces;
    @FXML
    private TableView<Evenement> tvLesEvenement;
    @FXML
    private TableColumn<Evenement, String> colTitre;
    @FXML
    private TableColumn<Evenement, String> colDescription;
    @FXML
    private Label lbidevenement;
    @FXML
    private VBox vboxDetaill;
    @FXML
    private ImageView materielimage;
    @FXML
    private Label filr_path;
    @FXML
    private Label lbidposte;

    @FXML
    private TableView<Poste> tvLesPostes;
    @FXML
    private TableColumn<Poste, String> colDomain;
    @FXML
    private TableColumn<Poste, String> colMaill;
    @FXML
    private Pane pnLesPostes;
    @FXML
    private TableColumn<Materiel, String> colNomt;
    @FXML
    private TableColumn<Materiel, String> colMarque;
    @FXML
    private TableColumn<Materiel, Integer> colPrix;
    @FXML
    private TableColumn<Materiel, String> colImage;
    @FXML
    private Label lbAnnoncef;
    @FXML
    private Label lbidmateriel;
    @FXML
    private TableColumn<Annonces, String> colNomss;
    @FXML
    private VBox vboxDetailll;
    @FXML
    private Pane pnLesEvenements;
    @FXML
    private VBox vboxDetaillll;
    @FXML
    private Label lbAnnonces;
    @FXML
    private Label lbRetour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pnLesPostes.toFront();
        fnshowp();

                Serviceannoncef sc=new Serviceannoncef();
        ObservableList<String>  list =FXCollections.observableArrayList(sc.afficherNom(2)); // TODO
        for(int i = 0 ; i<list.size();i++){
           list.get(i);
        }
        updateTable();
        // TODO
    }    
   public void fnshowf(){
        Serviceannoncef sp=new Serviceannoncef();
         ObservableList<Annoncef> list =FXCollections.observableList(sp.afficher());   
     colAdresse.setCellValueFactory(new PropertyValueFactory<>("adresse"));
     colMail.setCellValueFactory(new PropertyValueFactory<>("emailf"));
      colNom.setCellValueFactory(new PropertyValueFactory<>("nomf"));
      colDescript.setCellValueFactory(new PropertyValueFactory<>("descf"));
      tvLesAnnoncef.setItems(list);
     
     
   }
           public void fnshowm(){
        Servicemateriel sp=new Servicemateriel();
        Materiel m=new Materiel();
         ObservableList<Materiel> list =FXCollections.observableList(sp.afficherByID(2)); 
     
     
     colMarque.setCellValueFactory(new PropertyValueFactory<>("marque"));
     colPrix.setCellValueFactory(new PropertyValueFactory<>("Prix"));
          colNomt.setCellValueFactory(new PropertyValueFactory<>("nomm"));
         colDescriptt.setCellValueFactory(new PropertyValueFactory<>("descm"));
         colImage.setCellValueFactory(new PropertyValueFactory<>("image"));
     tvLesMateriels.setItems(list);
     
     
      
    }

    @FXML
    private void fnMenuLesAnnoncef(MouseEvent event) {
             pnLesAnnoncef.toFront();
             fnshowf();
    }

    @FXML
    private void fnMenuLesMateriels(MouseEvent event) {
                pnLesMateriels.toFront();
        fnshowm();

    }

    
    
         public void fnshowp(){
        ServicePoste sp=new ServicePoste();
         ObservableList<Poste> list =FXCollections.observableList(sp.afficher()); 
       colDomain.setCellValueFactory(new PropertyValueFactory<>("domaine"));
     colMaill.setCellValueFactory(new PropertyValueFactory<>("emailp"));
          colNomp.setCellValueFactory(new PropertyValueFactory<>("nomp"));
     tvLesPostes.setItems(list);
         } 
         
    @FXML
    private void fnSelectionPoste(MouseEvent event) {
        Poste p = tvLesPostes.getSelectionModel().getSelectedItem();
         lbidposte.setText(p.getIdp()+"");
         vboxDetail.setVisible(true);
         lbDescription.setText(p.getDescp());
         ServiceCategorie sc=new ServiceCategorie();
         Categorie c=sc.SelectOneCategorie(p.getIdcc());
         lbCategorie.setText(c.getNomc());
    }
    @FXML
    private void fnMenuLesPostes(MouseEvent event) {
         pnLesPostes.toFront();
         fnshowp();
    }

    @FXML
    private void fnMenuLesAnnonces(MouseEvent event) {
        pnLesAnnonces.toFront();
        fnshowa();
    }

    @FXML
    private void fnMenuLesEvenements(MouseEvent event) {
             pnLesEvenements.toFront();
            fnshowe();
    }

    @FXML
    private void fnSelectionMateriel(MouseEvent event) {
                Servicemateriel sp=new Servicemateriel();
         Materiel m = tvLesMateriels.getSelectionModel().getSelectedItem();
         lbidmateriel.setText(m.getIdm()+"");
         vboxDetaill.setVisible(true);
         Serviceannoncef sc=new Serviceannoncef();
         Annoncef f=sc.SelectOneAnnoncef(m.getIdff());
         lbAnnoncef.setText(f.getNomf());

        int index = tvLesMateriels.getSelectionModel().getSelectedIndex();
        if (index <= -1){
            return;
        }
      

        String picture ="file:" +  colImage.getCellData(index).toString();
        filr_path.setText(colImage.getCellData(index).toString());
    Image image1 = new Image(picture, 110, 110, false, true);            
            materielimage.setImage(image1);
    }
        public void updateTable(){
        Servicemateriel sm = new Servicemateriel();
        
        List<Materiel> materiel = sm.afficher();
        ObservableList<Materiel> listM=FXCollections.observableArrayList(materiel);
        colNomt.setCellValueFactory(new PropertyValueFactory<Materiel,String>("nomm"));
        colMarque.setCellValueFactory(new PropertyValueFactory<Materiel,String>("marque"));
        colPrix.setCellValueFactory(new PropertyValueFactory<Materiel,Integer>("prix"));
        colDescriptt.setCellValueFactory(new PropertyValueFactory<Materiel,String>("descm"));
        colImage.setCellValueFactory(new PropertyValueFactory<Materiel,String>("image"));
        tvLesMateriels.setItems(listM);

    }
public void fnshowa(){
        ServiceAnnonces sp=new ServiceAnnonces();
         ObservableList<Annonces> list =FXCollections.observableList(sp.afficher());   
     colAdresses.setCellValueFactory(new PropertyValueFactory<>("adresses"));
     colEmail.setCellValueFactory(new PropertyValueFactory<>("emails"));
      colNomss.setCellValueFactory(new PropertyValueFactory<>("noms"));
           colNumero.setCellValueFactory(new PropertyValueFactory<>("numeros"));
      colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
      tvLesAnnonces.setItems(list);
     
     
   }
 public void fnshowe(){
        ServiceEvenement sp=new ServiceEvenement();
         ObservableList<Evenement> list =FXCollections.observableList(sp.afficher()); 
     
     
     colTitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
     colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
          colNoms.setCellValueFactory(new PropertyValueFactory<>("nomss"));
     tvLesEvenement.setItems(list);
     
     
      
    }
    @FXML
    private void fnSelectiannonces(MouseEvent event) {
                 Annonces f = tvLesAnnonces.getSelectionModel().getSelectedItem();
         lbidannonces.setText(f.getIds()+"");
         vboxDetailll.setVisible(true);
                 fnshowa();
    }

    @FXML
    private void fnSelectionevenement(MouseEvent event) {
                 Evenement m = tvLesEvenement.getSelectionModel().getSelectedItem();
         lbidevenement.setText(m.getIde()+"");
         vboxDetaillll.setVisible(true);
         ServiceAnnonces sc=new ServiceAnnonces();
         Annonces f=sc.SelectOneAnnonces(m.getIds());
         lbAnnonces.setText(f.getNoms());
    }

    @FXML
    private void fnlog(MouseEvent event) {
                                       try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("loginfxml.fxml"));
            Parent root = loader.load();
            lbRetour.getScene().setRoot(root);
           } catch (IOException ex) {
               System.out.print(ex.getMessage());
        }
    }
    
}
