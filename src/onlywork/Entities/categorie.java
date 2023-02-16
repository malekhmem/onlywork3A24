/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlywork.Entities;

/**
 *
 * @author zeine
 */
public class categorie {
  int idc;
String nomc;
   public categorie() {
    }

    public categorie(int idc,String nomc) {
        this.idc=idc;
        this.nomc = nomc;
    }


    public int getIdc() {
        return idc;
    }

    public String getNomc() {
        return nomc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public void setNomc(String nomc) {
        this.nomc = nomc;
    }

 
    @Override
    public String toString() {
        return "categorie{" + "idc=" + idc + ", nomc=" + nomc + '}';
    }

}
