/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import entities.Admin;
import entities.Fournisseur;
import entities.Prestataire;
import entities.Societe;
import entities.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import utils.MyD;

/**
 *
 * @author chaker
 */
public class ServiceUtilisateurIMP implements Iutilisateur<Utilisateur> {

    // assusrer la connexion a la base de donnee
    Connection cnx;

    public ServiceUtilisateurIMP() {

        cnx = MyD.getInstance().getConnection();

    }

    @Override
    public void ajoutUtilisateur(Utilisateur t) {

        try {

            String req = "INSERT INTO utilisateur (login , password , nom ,prenom , email , num_tel , role, etat) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, t.getLogin());
            ps.setString(2, t.getPassword());
            ps.setString(3, t.getNom());
            ps.setString(4, t.getPrenom());
            ps.setString(5, t.getEmail());
            ps.setInt(6, t.getNum_tel());
            ps.setString(7, "prestataire");
            ps.setString(8, t.getEtat());

            int value = ps.executeUpdate();
            if (value > 0) {
                System.out.println(" l insertion de l utilisateur :" + t.getNom() + " " + t.getPrenom() + " a ete effectuer avec sucess ");
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
    }

    public void ajoutSocieter(Utilisateur t) {

        try {

            String req = "INSERT INTO utilisateur (login , password , nom ,prenom , email , num_tel , role, etat) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, t.getLogin());
            ps.setString(2, t.getPassword());
            ps.setString(3, t.getNom());
            ps.setString(4, t.getPrenom());
            ps.setString(5, t.getEmail());
            ps.setInt(6, t.getNum_tel());
            ps.setString(7, "societer");
            ps.setString(8, t.getEtat());

            int value = ps.executeUpdate();
            if (value > 0) {
                System.out.println(" l insertion du societer  :" + t.getNom() + " " + t.getPrenom() + " a ete effectuer avec sucess ");
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void ajoutFournisseur(Utilisateur t) {

        try {

            String req = "INSERT INTO utilisateur (login , password , nom ,prenom , email , num_tel , role, etat) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, t.getLogin());
            ps.setString(2, t.getPassword());
            ps.setString(3, t.getNom());
            ps.setString(4, t.getPrenom());
            ps.setString(5, t.getEmail());
            ps.setInt(6, t.getNum_tel());
            ps.setString(7, "fournisseur");
            ps.setString(8, t.getEtat());

            int value = ps.executeUpdate();
            if (value > 0) {
                System.out.println(" l insertion du fournisseur  :" + t.getNom() + " " + t.getPrenom() + " a ete effectuer avec sucess ");
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void modifierUtilisateur(Utilisateur t, int id) {
        try {

            String req = "UPDATE utilisateur set login = ? , password = ? , nom = ? ,prenom = ?, email = ?, num_tel= ?, role = ? , etat = ?   WHERE id =" + id;
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, t.getLogin());
            ps.setString(2, t.getPassword());
            ps.setString(3, t.getNom());
            ps.setString(4, t.getPrenom());
            ps.setString(5, t.getEmail());
            ps.setInt(6, t.getNum_tel());
            ps.setString(7, t.getRole());
            ps.setString(8, t.getEtat());

            int value_update = ps.executeUpdate();
            if (value_update > 0) {
                System.out.println(" la modification de l utilisateur :" + t.getNom() + " " + t.getPrenom() + " a ete effectuer avec sucess");
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void supprimerUtilisateur(int id) {
        try {

            String req = "delete from utilisateur where id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id);
            int value_supp = ps.executeUpdate();
            if (value_supp > 0) {
                System.out.println(" Suppression a ete effectuer avec sucess");
            }

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Utilisateur> afficherUtilisateur() {
        List<Utilisateur> list_Utilisateur = new ArrayList<>();
        try {

            String req = "select * from utilisateur";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {

                Utilisateur user = new Utilisateur();
                user.setId(rs.getInt(1));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setNom(rs.getString("nom"));
                user.setPrenom(rs.getString("prenom"));
                user.setEmail(rs.getString("email"));
                user.setNum_tel(rs.getInt("num_tel"));
                user.setRole(rs.getString("role"));
                user.setEtat(rs.getString("etat"));

                list_Utilisateur.add(user);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list_Utilisateur;
    }
    
    
       public List<Utilisateur> afficherUtilisateurs() {
        List<Utilisateur> list_Utilisateur = new ArrayList<>();
        try {

            String req = "select * from utilisateur";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {

                Utilisateur user = new Utilisateur();
                user.setId(rs.getInt(1));
                
                user.setNom(rs.getString("nom"));
                user.setPrenom(rs.getString("prenom"));
                user.setEmail(rs.getString("email"));
                user.setNum_tel(rs.getInt("num_tel"));
                user.setRole(rs.getString("role"));
                user.setEtat(rs.getString("etat"));

                list_Utilisateur.add(user);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list_Utilisateur;
    }

    @Override
    public List<Utilisateur> afficherPrestataireList() {
        List<Utilisateur> list_Clients = new ArrayList<>();
        try {

            String req = "select * from utilisateur where role = 'prestataire'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {

                Utilisateur user = new Utilisateur();
                user.setId(rs.getInt(1));
                user.setNom(rs.getString("nom"));
                user.setPrenom(rs.getString("prenom"));
                user.setEmail(rs.getString("email"));
                user.setNum_tel(rs.getInt("num_tel"));
                user.setRole(rs.getString("role"));
                user.setEtat(rs.getString("etat"));
                

                list_Clients.add(user);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list_Clients;
    }

    @Override
    public List<Utilisateur> afficherFournisseurList() {
List<Utilisateur> list_fournisseur = new ArrayList<>();
        try {

            String req = "select * from utilisateur where role = 'fournisseur'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {

                Utilisateur user = new Utilisateur();
                user.setId(rs.getInt(1));
                user.setNom(rs.getString("nom"));
                user.setPrenom(rs.getString("prenom"));
                user.setEmail(rs.getString("email"));
                user.setNum_tel(rs.getInt("num_tel"));
                user.setRole(rs.getString("role"));
                user.setEtat(rs.getString("etat"));
                ;

                list_fournisseur.add(user);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list_fournisseur;
    }

    public void DescativerUser(int id) {
        try {
            String req = "Update utilisateur set etat = 'desactive' where id =" + id;
            PreparedStatement ps = cnx.prepareStatement(req);
            int value_update = ps.executeUpdate();
            if (value_update > 0) {
                System.out.println(" la desactivation de l utilisateur   a ete effectuer avec sucess");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void ActiverUser(int id) {
        try {
            String req = "Update utilisateur set etat = 'active' where id =" + id;
            PreparedStatement ps = cnx.prepareStatement(req);
            int value_update = ps.executeUpdate();
            if (value_update > 0) {
                System.out.println(" l activation de l utilisateur   a ete effectuer avec sucess");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public String FindNomUserById(int id) {
        String nom = null;
        try {
            String req = "select * from utilisateur where id =" + id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                nom = rs.getString(4);
                System.out.println(nom);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return nom;

    }

    public Map<String, Integer> countUsersByRole() {
        Map<String, Integer> list = new HashMap<>();
        try {
            String req = "select COUNT(*) as count, role from utilisateur GROUP BY role";
            Statement st = cnx.prepareStatement(req);
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                list.put(rs.getString("role"), rs.getInt("count"));

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;

    }

    public String getUtilisateurRole(int id) {
        String role = null;
        try {
            String req = "SELECT role FROM utilisateur WHERE id=" + id;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                role = rs.getString("role");

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(role);
        return role;

    }

    public Utilisateur getUserById(int id) {
        Utilisateur user = new Utilisateur();
        Admin admin = new Admin();
        Fournisseur fournisseur = new Fournisseur();
        Prestataire prestataire = new Prestataire();
        Societe societe = new Societe();

        // cas admin
        if ("admin".equals(getUtilisateurRole(id))) {
            try {
                String req = "SELECT * FROM utilisateur WHERE id=" + id;
                Statement st = cnx.createStatement();
                ResultSet rs = st.executeQuery(req);

                while (rs.next()) {
                    admin.setId(rs.getInt("id"));
                    admin.setLogin(rs.getString("login"));
                    admin.setPassword(rs.getString("password"));
                    admin.setNom(rs.getString("nom"));
                    admin.setPrenom(rs.getString("prenom"));
                    admin.setEmail(rs.getString("email"));
                    admin.setNum_tel(rs.getInt("num_tel"));
                    admin.setRole(rs.getString("role"));
                    admin.setEtat(rs.getString("etat"));

                }

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            user = admin;

        }

        // cas fournisseur
        if ("fournisseur".equals(getUtilisateurRole(id))) {
            try {
                String req = "SELECT * FROM utilisateur WHERE id=" + id;
                Statement st = cnx.createStatement();
                ResultSet rs = st.executeQuery(req);
                while (rs.next()) {
                    admin.setId(rs.getInt("id"));
                    admin.setLogin(rs.getString("login"));
                    admin.setPassword(rs.getString("password"));
                    admin.setNom(rs.getString("nom"));
                    admin.setPrenom(rs.getString("prenom"));
                    admin.setEmail(rs.getString("email"));
                    admin.setNum_tel(rs.getInt("num_tel"));
                    admin.setRole(rs.getString("role"));
                    admin.setEtat(rs.getString("etat"));

                }
                user = fournisseur;

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }

        // cas sociter
        if ("societer".equals(getUtilisateurRole(id))) {
            try {
                String req = "SELECT * FROM utilisateur WHERE id=" + id;
                Statement st = cnx.createStatement();
                ResultSet rs = st.executeQuery(req);
                while (rs.next()) {
                    admin.setId(rs.getInt("id"));
                    admin.setLogin(rs.getString("login"));
                    admin.setPassword(rs.getString("password"));
                    admin.setNom(rs.getString("nom"));
                    admin.setPrenom(rs.getString("prenom"));
                    admin.setEmail(rs.getString("email"));
                    admin.setNum_tel(rs.getInt("num_tel"));
                    admin.setRole(rs.getString("role"));
                    admin.setEtat(rs.getString("etat"));

                }
                user = societe;

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }
        System.out.println(user);
        return user;
    }

    public Utilisateur FindByLogin(String login) {
        Utilisateur user = new Utilisateur();

        try {
            String req = "SELECT * FROM utilisateur WHERE login ='" + login + "'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setNom(rs.getString("nom"));
                user.setPrenom(rs.getString("prenom"));
                user.setEmail(rs.getString("email"));
                user.setNum_tel(rs.getInt("num_tel"));
                user.setRole(rs.getString("role"));

                user.setEtat(rs.getString("etat"));

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return user;

    }

    public Utilisateur FindByLoginAndPassword(String login, String password) {
        Utilisateur user = new Utilisateur();

        try {
            String req = "SELECT * from utilisateur where login='" + login + "'AND password='" + password + "'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {

                user.setId(rs.getInt("id"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setNom(rs.getString("nom"));
                user.setPrenom(rs.getString("prenom"));
                user.setEmail(rs.getString("email"));
                user.setNum_tel(rs.getInt("num_tel"));
                user.setRole(rs.getString("role"));
                user.setEtat(rs.getString("etat"));

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return user;

    }
    
    
    public Utilisateur Authentification(String login, String password) {
        Utilisateur user = null;
// 

        try {
            String req = "select * from Utilisateur where login = ? and password = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9));

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }
        System.out.println(user);
        return user;

    }
    
       public String encrypt(String password) {

        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    public String decrypt(String password) {

        return new String(Base64.getMimeDecoder().decode(password));
    }

    public void ChangerPassword(int id, String nouveauPass) {
        String passCrypter = encrypt(nouveauPass);

        try {
            String req = "update utilisateur set password='" + passCrypter + "'where id='" + id + "'";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());        }

    }
    

}
