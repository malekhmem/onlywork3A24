/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author imtinen
 */
public class fournisseur {
    int idf;
    String nomf,adresse,emailf,nomma;
    public fournisseur(){}
    public fournisseur(String nomf, String adresse, String emailf, String nomma) {
        this.nomf = nomf;
        this.adresse = adresse;
        this.emailf = emailf;
        this.nomma = nomma;
    }

    public int getIdf() {
        return idf;
    }

    public void setIdf(int idf) {
        this.idf = idf;
    }

    public String getNomf() {
        return nomf;
    }

    public void setNomf(String nomf) {
        this.nomf = nomf;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmailf() {
        return emailf;
    }

    public void setEmailf(String emailf) {
        this.emailf = emailf;
    }

    public String getNomma() {
        return nomma;
    }

    public void setNomma(String nomma) {
        this.nomma = nomma;
    }

    @Override
    public String toString() {
        return "fournisseur{" + "idf=" + idf + ", nomf=" + nomf + ", adresse=" + adresse + ", emailf=" + emailf + ", nomma=" + nomma + '}';
    }

  
    
    
}
