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
public class blackliste {
    private int  idb,nbrr  ;
    private String descb;

    public blackliste() {
    }

    public blackliste(String descb, int nbrr ) {
        this.descb = descb;
        this.nbrr = nbrr;
     
    }

 
  

    public int getIdb() {
        return idb;
    }

    public void setIdb(int idb) {
        this.idb = idb;
    }

    public String getDescb() {
        return descb;
    }

    public void setDescb(String descb) {
        this.descb = descb;
    }

    public int getNbrr() {
        return nbrr;
    }

    public void setNbrr(int nbrr) {
        this.nbrr = nbrr;
    }

   
    @Override
    public String toString() {
        return "blackliste{" + "idb=" + idb + ", descb=" + descb + ", nbrr=" + nbrr +  "\n}";
    }
    
    
}
