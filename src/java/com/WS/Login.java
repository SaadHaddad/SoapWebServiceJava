/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS;

import com.login.MODEL.User;
import java.util.List;
import java.util.Vector;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author SAAD
 */
@WebService(serviceName = "Login")
public class Login {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "Login")
    public User Login(@WebParam(name = "user") String user,@WebParam(name = "pass") String pass) {
        return DB.Login(user,pass);
    }
}
