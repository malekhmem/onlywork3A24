/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionUser.Entities;

/**
 *
 * @author bouchrit
 */
public final class UserSession {
    
    private static UserSession instance;
    public static int id;
    public static String userName;
    public static String role;

    public UserSession(int id, String userName, String role) {
        UserSession.id = id;
        UserSession.userName = userName;
        UserSession.role = role;
    }
    
    
    public UserSession(String userName,  String role) {
        UserSession.userName = userName;
        UserSession.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        UserSession.id = id;
    }
    
    
    
    public static UserSession getInstace(String userName, String role) {
        if(instance == null) {
            instance = new UserSession(userName, role);
        }
        return instance;
    }

    public String getUserName() {
        return userName;
    }

    public String getRole() {
        return role;
    }

    public void cleanUserSession() {
        userName = "";
        role = null;
    }

    @Override
    public String toString() {
        return "UserSession{" +
                "userName='" + userName + '\'' +
                ", role=" + role +
                '}';
    }
    
}
