/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS;

import com.login.MODEL.Operation;
import java.util.List;
import java.util.Map;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 *
 * @author SAAD
 */
@WebService(serviceName = "Chirurgical")
public class Chirurgical {


    @WebMethod(operationName = "ListeOperation")
    public List<Operation> ListeOperation() {
        //TODO write your implementation code here:
        return DB.listTOUSOperation();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "DisponinibibiliteResource")
    public boolean DisponinibibiliteResource(@WebParam(name ="num_cabinet") int id) {
        //TODO write your implementation code here:
        return DB.DisponinibibiliteResource(id);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "DisponinibibiliteMedecin")
    public String DisponinibibiliteMedecin(@WebParam(name ="date")String Date) {
        //TODO write your implementation code here:
        return DB.DisponinibibiliteMedecin(Date);
    }
    


    /**
     * Web service operation
     */
    @WebMethod(operationName = "RecupereDateOperation")
    public String RecupereDateOperation() {
        //TODO write your implementation code here:
        return DB.GetDateOperation();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ConfirmerOperation")
    public String ConfirmerOperation(@WebParam(name = "ID_op") int ID_op, @WebParam(name = "DATE") String DATE, @WebParam(name = "NOM") String NOM) {
        //TODO write your implementation code here:
        return DB.ConfirmerOperation(ID_op, DATE, NOM);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "AllouerResource")
    public String AllouerResource(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        return DB.AllouerResource(id);
    }
   
}
