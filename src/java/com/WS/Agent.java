/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS;

import com.login.MODEL.Medecins;
import com.login.MODEL.Operation;
import com.login.MODEL.Patients;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author SAAD
 */
@WebService(serviceName = "Agent")
public class Agent {

    /**
     * This is a sample web service operation
     */
   
    /**
     * Web service operation
     */
    @WebMethod(operationName = "AddPatien")
    public String AddPatien(@WebParam(name = "Nom") String Nom, @WebParam(name = "Prenom") String Prenom, @WebParam(name = "Date_naicence") String Date_naicence, @WebParam(name = "Sex") String Sex, @WebParam(name = "TEL") String TEL, @WebParam(name = "addres") String addres) {
        //TODO write your implementation code here:
        return DB.AjouerPatient(Nom, Prenom, Date_naicence, Sex, TEL, addres);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ListeNomMedecins")
    public List<String>  ListeNomMedecins() {
        //TODO write your implementation code here:
        return DB.ListNomMedecins();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AddOperation")
    public String AddOperation(@WebParam(name = "ID_pat") int ID_pat, @WebParam(name = "nom_medecin_prv") String nom_medecin_prv, @WebParam(name = "cause_medical") String cause_medical, @WebParam(name = "num_B") int num_B) {
        //TODO write your implementation code here:
        return DB.AjouerOperation(ID_pat,nom_medecin_prv,cause_medical,num_B);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AfficherOperation")
    public  List<Operation>  AfficherOperation() {
        //TODO write your implementation code here:
        return DB.AfficherOperation();
    }
    
      @WebMethod(operationName = "ListMedecins")
    public List<Medecins> ListMedecins() {
        return DB.ListMedecins();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ListePatiens")
    public  List<Patients> ListePatiens() {
        //TODO write your implementation code here:
        return DB.ListPatints();
    }
    
    
}
