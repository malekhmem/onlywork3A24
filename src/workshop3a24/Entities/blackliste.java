/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.Entities;

/**
 *
 * @author houssem
 */
public class blackliste {
    private int  idb,nbrr  ;
    private String descb;

    public blackliste() {
    }

    public blackliste(int idb, int nbrr , String descb) {
       this.idb = idb ;
        this.descb = descb;
        this.nbrr = nbrr;
     
    }

  

    public int getIdb() {
        return idb;
    }

    public void setidb(int idb) {
        this.idb = idb;
    }

    public String getdescb() {
        return descb;
    }

    public void setdescb(String descb) {
        this.descb = descb;
    }

    public int getnbrr() {
        return nbrr;
    }

    public void setnbrr(int nbrr) {
        this.nbrr = nbrr;
    }

   
    @Override
    public String toString() {
        return "blackliste{" + "idb=" + idb + ", descb=" + descb + ", nbrr=" + nbrr +  "\n}";
    }
    
    
}
