/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package gestion_user;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author chaker
 */
public class Gestion_user extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try{ 
              /*
            Parent root = FXMLLoader.load(getClass().getResource("/GUI/ajouterTicket.fxml"));
            primaryStage.setResizable(false);
            primaryStage.setScene(new Scene(root));
   
            primaryStage.show(); 
            */
              
              Parent root = FXMLLoader.load(getClass().getResource("/GUI/startFxml.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);

            primaryStage.show();
            
            
        }catch(IOException ex) {
              System.out.println(ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
