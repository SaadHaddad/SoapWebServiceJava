/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS;

import com.login.MODEL.Medecins;
import com.login.MODEL.Operation;
import com.login.MODEL.Patients;
import com.login.MODEL.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author SAAD
 */
public class Database {
     private static Connection myconn;

    public static Connection  getConnection() {

        try {

            myconn = DriverManager.getConnection("jdbc:mysql://localhost/med", "root", "");

        } catch (Exception ex) {
            System.err.println("erreur" + ex.getMessage());

        }
return myconn;
    }


//-----------------------------------------------------------compte--------------------------

    public static List<User> Login(String user,String pass) {
    List U= new ArrayList<User>();
        getConnection();
        Statement stmt = null;
        ResultSet rs=null;
        try {
            stmt = myconn.createStatement();
           // String sql = "Select * from user where user='"+user+"' AND pass='"+pass+"'";
           String sql = "Select * from user WHERE user='"+user+"' and pass='"+pass+"'";
      rs= stmt.executeQuery(sql);
       if(rs.next())
        {
         U.add(new User(rs.getInt("id"),rs.getString("user"),"s"));       
        }
       else{
        U.add(new User());
       }
           
       return U;
         
        
        } catch (Exception ex) {
           
             return U;
        }

       
    }
  //-------------------------------- list des medcin
     public static List<Medecins> ListMedecins() {
    List U= new ArrayList<Medecins>();
        getConnection();
        Statement stmt = null;
        ResultSet rs=null;
        try {
            stmt = myconn.createStatement();
           // String sql = "Select * from user where user='"+user+"' AND pass='"+pass+"'";
           String sql = "Select * from medcin  ";
      rs= stmt.executeQuery(sql);
       while(rs.next())
        {
         U.add(new Medecins(rs.getInt("Id_med"),rs.getString("nom"),rs.getString("specialite"),rs.getString("nom_cabinet"),rs.getString("TEL")));       
        }
      
           
       return U;
         
        
        } catch (Exception ex) {
           
             return U;
        }

       
    }
     
       public static List<String> ListNomMedecins() {
        List U= new ArrayList<String>();
        getConnection();
        Statement stmt = null;
        ResultSet rs=null;
        try {
            stmt = myconn.createStatement();
           // String sql = "Select * from user where user='"+user+"' AND pass='"+pass+"'";
           String sql = "Select Nom from medcin  ";
      rs= stmt.executeQuery(sql);
       while(rs.next())
        {
         U.add(rs.getString("nom"));       
        }
      
           
       return U;
         
        
        } catch (Exception ex) {
           
             return U;
        }

       
    }
     
   //-----------------------------------------------------------Agent------------------------
       public static String AjouerPatient(String nom, String prenom, String date, String sex,String tel,String adress) {

           getConnection();

        Statement stmt = null;
           PreparedStatement ps = null;
        String sql;
        try {
            //virifier si le client exist deja

            //ajouter  client a la base de donnes
            stmt = myconn.createStatement();
            sql = "INSERT INTO paitents VALUES(null,'"+nom+"','"+prenom+"','"+date+"','"+sex+"','"+tel+"','"+adress+"') ";
          int num =  stmt.executeUpdate(sql);
             if(num==1)
             {        return "patient ajouté avec succès";
        }    else
             {   return "erreur : le patient ñ'est pas ajouter";
             }
        } catch (Exception ex) {
            
          return "erreur: " + ex.getMessage();
        }
    
       }
       
        public static String AjouerOperation(int ID_pa, String nom_med, String cause_med) {

           getConnection();

        Statement stmt = null;
           PreparedStatement ps = null;
        String sql;
        try {
            //virifier si le client exist deja

            //ajouter  client a la base de donnes
            stmt = myconn.createStatement();
            
            sql = " INSERT INTO operation(ID_Operation, ID_pat, nom_medecin_prv, cause_medical) VALUES (null,1,'"+nom_med+"','"+cause_med+"')";
          int num =  stmt.executeUpdate(sql);
             if(num==1)
             {        return " l'Operation ajouté avec succès";
        }    else
             {   return "erreur : l'Operation ñ'est pas ajouter";
             }
        } catch (Exception ex) {
            
          return "erreur: " + ex.getMessage();
        }
    
       }
       
       public static  List<Operation> AfficherOperation() {
       List<Operation> op= new ArrayList<Operation>();
       Operation O = null;
        ResultSet rs = null;
        getConnection();
        Statement stmt = null;
        try {
            stmt = myconn.createStatement();
            String sql = "SELECT ID_Operation ,ID_pat,nom,prenom,date_n,sex,Tel,adress,nom_medecin_prv,cause_medical,etat_chu FROM operation,paitents WHERE operation.ID_pat=paitents.ID_pa ";
            rs = stmt.executeQuery(sql);
    while(rs.next())
        {
          
         O= new Operation(rs.getInt("ID_Operation"),rs.getString("nom_medecin_prv"),rs.getString("cause_medical"),rs.getString("etat_chu"),rs.getInt("ID_pat"),rs.getString("nom"),rs.getString("prenom"),rs.getString("date_n"),rs.getString("sex"),rs.getString("tel"),rs.getString("adress"))  ;
         op.add(O); 
        
        }
  
        } catch (Exception ex) {
            System.err.println("erreur" + ex.getMessage());
            return null;
        }

         return op ;
    }
       
       public static String AjouerComptRendu(int ID_op, String Comptrendu) {

           getConnection();
           Statement stmt = null;
           PreparedStatement ps = null;
           String sql;
        try {
 
            stmt = myconn.createStatement();
            
            sql = " Update operation set Compte_rendu='"+Comptrendu+"' where ID_Operation="+ID_op;
          int num =  stmt.executeUpdate(sql);
             if(num==1)
             {        return " le compte rendu ajouté avec succès";
        }    else
             {   return "erreur : l'le compte rendu n'est pas ajouter";
             }
        } catch (Exception ex) {
            
          return "erreur: " + ex.getMessage();
        }
    
       }
   
       
       
       
}
