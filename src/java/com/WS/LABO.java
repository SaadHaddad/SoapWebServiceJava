/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS;

import com.login.MODEL.Billan;
import com.login.MODEL.Patients;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author SAAD
 */
@WebService(serviceName = "LABO")
public class LABO {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AjouterBillan")
    public String AjouterBillan(@WebParam(name = "billan") String billan, @WebParam(name = "id_pa") int id_pa) {
        //TODO write your implementation code here:
        return DB.AjouerBillan(billan, id_pa);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ListeBillan")
    public List<Billan> ListeBillan() {
        //TODO write your implementation code here:
        return DB.listeBillan();
    }
    @WebMethod(operationName = "ListePatiens")
    public  List<Patients> ListePatiens() {
        //TODO write your implementation code here:
        return DB.ListPatints();
    }
}
