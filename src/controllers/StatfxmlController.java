/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.shape.Circle;
import services.ServiceUtilisateurIMP;
import javafx.util.Duration;


/**
 * FXML Controller class
 *
 * @author chaker
 */
public class StatfxmlController implements Initializable {

    private PieChart pieChart;

    /**
     * Initializes the controller class.
     */
    
        ServiceUtilisateurIMP su = new ServiceUtilisateurIMP();
    @FXML
    private Circle c1;
    @FXML
    private Circle c2;
    @FXML
    private Circle c3;
    @FXML
    private Circle c4;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        Map<String, Integer> countMap = new HashMap<>();
        countMap.putAll(su.countUsersByRole());

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        countMap.forEach((role, count) -> {
            pieChartData.add(new PieChart.Data(role, count));
        });
        pieChart.setTitle("Statistiques des roles des utilisateurs");
        pieChart.setData(pieChartData);
        FadeTransition transition = new FadeTransition(Duration.seconds(3), pieChart);
        transition.setFromValue(0);
        transition.setToValue(1);
        transition.play();
        
    }    

    private void goToAdminDashboard(ActionEvent event) {
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/AdminDashboardFXML.fxml"));
            Parent root = loader.load();
            pieChart.getScene().setRoot(root);
        } catch (IOException ex) {
              System.out.println(ex.getMessage());        }
    }

    @FXML
    private void ChangerScene(ActionEvent event) {
    }
    
}
