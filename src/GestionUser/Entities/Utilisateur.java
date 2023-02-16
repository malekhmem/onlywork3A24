/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionUser.Entities;

/**
 *
 * @author Mohamed
 */
public class Utilisateur {
    private int idu ,numerou ;
    private String nomu,mailu,mdp;

    public Utilisateur() {
    }

    public Utilisateur(String nomu, String mailu, String mdp, int numerou) {
        this.nomu = nomu;
        this.mailu = mailu;
        this.mdp = mdp;
        this.numerou = numerou;
        
    }

    public int getIdu() {
        return idu;
    }

    public void setIdu(int idu) {
        this.idu = idu;
    }

    public String getNomu() {
        return nomu;
    }

    public void setNomu(String nomu) {
        this.nomu = nomu;
    }

    public String getMailu() {
        return mailu;
    }

    public void setMailu(String mailu) {
        this.mailu = mailu;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
 
    public int getNumerou() {
        return numerou;
    }

    public void setNumerou(int numerou) {
        this.numerou = numerou;
    }
    @Override
    public String toString() {
        return "Utilisateur{" + "id user=" + idu + ", nom=" + nomu + ", mail=" + mailu + ", mdp=" + mdp + ", numero=" + numerou + "\n}";
    }
    
    
}
