/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author zeine
 */
public class Poste {
    int idp,idcc,idu;
    String nomp,domaine,descp,emailp;
    public Categorie categorie; 
    

    public Poste() {
    }

    public Poste(int idp, int idcc, String nomp, String domaine, String descp, String emailp, Categorie categorie) {
        this.idp = idp;
        this.idcc = idcc;
        this.nomp = nomp;
        this.domaine = domaine;
        this.descp = descp;
        this.emailp = emailp;
        this.categorie = categorie;
    }

    public int getIdu() {
        return idu;
    }

    public void setIdu(int idu) {
        this.idu = idu;
    }

    
    
    public int getIdcc() {
        return idcc;
    }

    public void setIdcc(int idcc) {
        this.idcc = idcc;
    }

   
    

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public String getNomp() {
        return nomp;
    }

    public void setNomp(String nomp) {
        this.nomp = nomp;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }

    public String getEmailp() {
        return emailp;
    }

    public void setEmailp(String emailp) {
        this.emailp = emailp;
    }
    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
    
    public Poste(int idp, String nomp, String domaine, String descp, String emailp) {
        this.idp = idp;
        this.nomp = nomp;
        this.domaine = domaine;
        this.descp = descp;
        this.emailp = emailp;
    }

    @Override
    public String toString() {
        return "Poste{" + "idcc=" + idcc + ", nomp=" + nomp + ", domaine=" + domaine + ", descp=" + descp + ", emailp=" + emailp + '}';
    }

   
 
    
 }
