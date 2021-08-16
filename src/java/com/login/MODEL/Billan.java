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
public class Billan {

    /**
     * @return the id_pat
     */
    public int getId_pat() {
        return id_pat;
    }

    /**
     * @param id_pat the id_pat to set
     */
    public void setId_pat(int id_pat) {
        this.id_pat = id_pat;
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
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the date_n
     */
    public String getDate_n() {
        return date_n;
    }

    /**
     * @param date_n the date_n to set
     */
    public void setDate_n(String date_n) {
        this.date_n = date_n;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return the Tel
     */
    public String getTel() {
        return Tel;
    }

    /**
     * @param Tel the Tel to set
     */
    public void setTel(String Tel) {
        this.Tel = Tel;
    }

    /**
     * @return the adress
     */
    public String getAdress() {
        return adress;
    }

    /**
     * @param adress the adress to set
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

    /**
     * @return the num_billan
     */
    public int getNum_billan() {
        return num_billan;
    }

    /**
     * @param num_billan the num_billan to set
     */
    public void setNum_billan(int num_billan) {
        this.num_billan = num_billan;
    }

    /**
     * @return the Billan
     */
    public String getBillan() {
        return Billan;
    }

    /**
     * @param Billan the Billan to set
     */
    public void setBillan(String Billan) {
        this.Billan = Billan;
    }
     private int id_pat;
    private String nom;
    private String prenom;
    private String date_n;
    private String sex;
    private String Tel;
    private String adress;
    private int num_billan;
    private String Billan;

    public Billan(int id_pat, String nom, String prenom, String date_n, String sex, String Tel, String adress, int num_billan, String Billan) {
        this.id_pat = id_pat; 
        this.nom = nom;
        this.prenom = prenom;
        this.date_n = date_n;
        this.Tel = Tel;
        this.sex=sex;
        this.adress = adress;
        this.num_billan = num_billan;
        this.Billan = Billan;
    }

    public Billan() {
    }
    
    
    
}
