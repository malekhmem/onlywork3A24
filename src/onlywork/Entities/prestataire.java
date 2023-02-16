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
public class prestataire {
    int idp;
    String nomp,domaine,descp,emailp;

    public prestataire() {
    }

    public prestataire(int idp, String nomp, String domaine, String descp, String emailp) {
        this.idp=idp;
        this.nomp = nomp;
        this.domaine = domaine;
        this.descp = descp;
        this.emailp = emailp;
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

    @Override
    public String toString() {
        return "prestataire{" + "idp=" + idp + ", nomp=" + nomp + ", domaine=" + domaine + ", descp=" + descp + ", emailp=" + emailp + '}';
    }
    
}
