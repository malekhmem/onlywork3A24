/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author chaker
 */
public class MyD {
    
 
    private String url = "jdbc:mysql://localhost/onlywork";
    private String user = "root";
    private String pass = "";
    private Connection connection;
    static MyD instance;

  public MyD(){
        try {
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("connection etablit avec sucess");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static MyD getInstance(){
        if(instance == null)
            instance = new MyD();
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
    

    
    
}

