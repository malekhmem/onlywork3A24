/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.Entities;

/**
 *
 * @author Mohamed
 */
public class reclamation {
    private int  idr  ;
    private String nomr,emailr,descr,type;

    public reclamation() {
    }

    public reclamation( String descr, String nomr, String emailr, String type) {
      
        this.descr = descr;
        this.nomr = nomr;
        this.emailr = emailr;
        this.type = type;
    }

 

    public int getIdr() {
        return idr;
    }

    public void setIdr(int idr) {
        this.idr = idr;
    }

    public String getdescr() {
        return descr;
    }

    public void setdescr(String descr) {
        this.descr = descr;
    }

    public String getNomr() {
        return nomr;
    }

    public void setNomr(String nomr) {
        this.nomr = nomr;
    }

    public String gettype() {
        return type;
    }

    public void settype(String type) {
        this.type = type;
    }
  public String getemailr() {
        return emailr;
    }

    public void setemailr(String emailr) {
        this.emailr = emailr;
    }
    @Override
    public String toString() {
        return "reclamation{" + "idr=" + idr + ", descr=" + descr + ", nomr=" + nomr + ", type=" + type + ", emailr=" + emailr + "\n}";
    }
    
    
}
