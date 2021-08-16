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
public class Operation {

    /**
     * @return the dateOperation
     */
    public String getDateOperation() {
        return dateOperation;
    }

    /**
     * @param dateOperation the dateOperation to set
     */
    public void setDateOperation(String dateOperation) {
        this.dateOperation = dateOperation;
    }

    /**
     * @return the Medecin_operation
     */
    public String getMedecin_operation() {
        return Medecin_operation;
    }

    /**
     * @param Medecin_operation the Medecin_operation to set
     */
    public void setMedecin_operation(String Medecin_operation) {
        this.Medecin_operation = Medecin_operation;
    }

      private int id_pat;
    private String nom;
    private String prenom;
    private String date_n;
    private String sex;
    private String Tel;
    private String adress;
       private String dateOperation;
    private int id_operation;
    private String nom_medecin_prv;
    private String cause_medecal;
    private String compte_rendu;
    private String etat_med;
    private String etat_chu;
    private String billan="";
    private String Compte_rendu="";

private String Medecin_operation;

    
    
    
    
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
     * @return the id_operation
     */
    public int getId_operation() {
        return id_operation;
    }

    /**
     * @param id_operation the id_operation to set
     */
    public void setId_operation(int id_operation) {
        this.id_operation = id_operation;
    }

    /**
     * @return the nom_medecin_prv
     */
    public String getNom_medecin_prv() {
        return nom_medecin_prv;
    }

    /**
     * @param nom_medecin_prv the nom_medecin_prv to set
     */
    public void setNom_medecin_prv(String nom_medecin_prv) {
        this.nom_medecin_prv = nom_medecin_prv;
    }

    /**
     * @return the cause_medecal
     */
    public String getCause_medecal() {
        return cause_medecal;
    }

    /**
     * @param cause_medecal the cause_medecal to set
     */
    public void setCause_medecal(String cause_medecal) {
        this.cause_medecal = cause_medecal;
    }

    /**
     * @return the compte_rendu
     */
    public String getCompte_rendu() {
        return compte_rendu;
    }

    /**
     * @param compte_rendu the compte_rendu to set
     */
    public void setCompte_rendu(String compte_rendu) {
        this.compte_rendu = compte_rendu;
    }

    /**
     * @return the etat_med
     */
    public String getEtat_med() {
        return etat_med;
    }

    /**
     * @param etat_med the etat_med to set
     */
    public void setEtat_med(String etat_med) {
        this.etat_med = etat_med;
    }

    /**
     * @return the etat_chu
     */
    public String getEtat_chu() {
        return etat_chu;
    }

    /**
     * @param etat_chu the etat_chu to set
     */
    public void setEtat_chu(String etat_chu) {
        this.etat_chu = etat_chu;
    }

    /**
     * @return the billan
     */
    public String getBillan() {
        return billan;
    }

    /**
     * @param billan the billan to set
     */
    public void setBillan(String billan) {
        this.billan = billan;
    }
  

    public Operation( int id_operation, String nom_medecin_prv, String cause_medecal, String etat_chu,int id_pat, String nom, String prenom, String date_n, String sex, String Tel, String adress) {
        this.id_pat = id_pat;
        this.nom = nom;
        this.prenom = prenom;
        this.date_n = date_n;
        this.sex = sex;
        this.Tel = Tel;
        this.adress = adress;
        this.id_operation = id_operation;
        this.nom_medecin_prv = nom_medecin_prv;
        this.cause_medecal = cause_medecal;
        this.etat_chu = etat_chu;
        
    }
 public Operation( int id_operation, String nom_medecin_prv, String cause_medecal, String etat_chu,String Compte_rendu,String billan,int id_pat, String nom, String prenom, String date_n, String sex, String Tel, String adress) {
        this.id_pat = id_pat;
        this.nom = nom;
        this.prenom = prenom;
        this.date_n = date_n;
        this.sex = sex;
        this.Tel = Tel;
        this.adress = adress;
        this.id_operation = id_operation;
        this.nom_medecin_prv = nom_medecin_prv;
        this.cause_medecal = cause_medecal;
        this.etat_chu = etat_chu;
       this.Compte_rendu=Compte_rendu;
       this.billan=billan;
        
    }
    
    
    
    public Operation() {
    }
    private String degre;
    
    
    
}
