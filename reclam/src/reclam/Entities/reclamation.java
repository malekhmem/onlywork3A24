/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reclam.Entities;

/**
 *
 * @author houssem
 */
public class reclamation {
    private int  idr  ;
    private String nomr,emailr,descr,type,traiter;

    public reclamation() {
    }

    public reclamation( String descr, String nomr, String emailr,String type,String traiter) {
      
        this.descr = descr;
        this.nomr = nomr;
        this.emailr = emailr;
        this.type = type;
        this.traiter = traiter;

    }

    public int getIdr() {
        return idr;
    }

    public void setIdr(int idr) {
        this.idr = idr;
    }

    public String getNomr() {
        return nomr;
    }

    public void setNomr(String nomr) {
        this.nomr = nomr;
    }

    public String getEmailr() {
        return emailr;
    }

    public void setEmailr(String emailr) {
        this.emailr = emailr;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
 public String getTraiter() {
        return traiter;
    }
    public void setTraiter(String traiter) {
        this.traiter = traiter;
    }
  

    @Override
    public String toString() {
        return "reclamation{" + "idr=" + idr + ", descr=" + descr + ", nomr=" + nomr + ", type=" + type + ", emailr=" + emailr + ", traiter=" +traiter+ "\n}";
    }
    
    
}
