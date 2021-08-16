/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS;

import com.login.MODEL.Operation;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author SAAD
 */
@WebService(serviceName = "Medical")
public class Medical {

    /**
     * This is a sample web service operation
     */
 

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AjouterCompteRendu")
    public String AjouterCompteRendu(@WebParam(name = "ID_ope") int ID_ope,@WebParam(name = "Compt_rendu") String Compt_rendu) {
        //TODO write your implementation code here:
        return DB.AjouerComptRendu(ID_ope, Compt_rendu);
    }
    
       @WebMethod(operationName = "AfficherOperation")
    public  List<Operation>  AfficherOperation() {
        //TODO write your implementation code here:
        return DB.listOperationEnattent();
    }
    
}
