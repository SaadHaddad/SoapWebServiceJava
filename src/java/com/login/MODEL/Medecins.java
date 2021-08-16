/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.login.MODEL;

/**
 *
 * @author SAAD
 */
public class Medecins {

    public Medecins() {
    }

    /**
     * @return the id_Med
     */
    public int getId_Med() {
        return id_Med;
    }

    /**
     * @param id_Med the id_Med to set
     */
    public void setId_Med(int id_Med) {
        this.id_Med = id_Med;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the specilite
     */
    public String getSpecilite() {
        return specilite;
    }

    /**
     * @param specilite the specilite to set
     */
    public void setSpecilite(String specilite) {
        this.specilite = specilite;
    }

    /**
     * @return the nom_cabinet
     */
    public String getNom_cabinet() {
        return nom_cabinet;
    }

    /**
     * @param nom_cabinet the nom_cabinet to set
     */
    public void setNom_cabinet(String nom_cabinet) {
        this.nom_cabinet = nom_cabinet;
    }

    /**
     * @return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    public Medecins(int id_Med, String nom, String specilite, String nom_cabinet, String tel) {
        this.id_Med = id_Med;
        this.nom = nom;
        this.specilite = specilite;
        this.nom_cabinet = nom_cabinet;
        this.tel = tel;
    }
    
    private int id_Med;
    private String nom;
    private String specilite;
    private String nom_cabinet;
    private String tel;

}
