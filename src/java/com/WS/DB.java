/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.WS;

import com.login.MODEL.Billan;
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
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author SAAD
 */
public class DB {

    private static Connection myconn;

    public static Connection getConnection() {

        try {

            myconn = DriverManager.getConnection("jdbc:mysql://localhost/med", "root", "");

        } catch (Exception ex) {
            System.err.println("erreur" + ex.getMessage());

        }
        return myconn;
    }
    //-----------------------------------------------------------compte--------------------------

    public static User Login(String user, String pass) {
      User U = null;
        getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = myconn.createStatement();
            // String sql = "Select * from user where user='"+user+"' AND pass='"+pass+"'";
            String sql = "Select * from user WHERE user='" + user + "' and pass='" + pass + "'";
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                U=new User(rs.getInt("id"), rs.getString("user"),rs.getString("role"));
            } else {
                U=new User();
            }

            return U;

        } catch (Exception ex) {

            return new User();
        }

    }
    //-------------------------------- list des medcin

        public static List<Patients> ListPatints() {
        List U = new ArrayList<Patients>();
        getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = myconn.createStatement();
            // String sql = "Select * from user where user='"+user+"' AND pass='"+pass+"'";
            String sql = "Select * from paitents  ";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
             
                U.add(new Patients(rs.getInt("id_pa"), rs.getString("nom"), rs.getString("prenom"), rs.getString("date_n"), rs.getString("sex"), rs.getString("tel"), rs.getString("adress")));
            }

            return U;

        } catch (Exception ex) {

            return U;
        }

    }
    public static List<Medecins> ListMedecins() {
        List U = new ArrayList<Medecins>();
        getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = myconn.createStatement();
            // String sql = "Select * from user where user='"+user+"' AND pass='"+pass+"'";
            String sql = "Select * from medcin  ";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                U.add(new Medecins(rs.getInt("Id_med"), rs.getString("nom"), rs.getString("specialite"), rs.getString("nom_cabinet"), rs.getString("TEL")));
            }

            return U;

        } catch (Exception ex) {

            return U;
        }

    }

    public static List<String> ListNomMedecins() {
        List U = new ArrayList<String>();
        getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = myconn.createStatement();
            // String sql = "Select * from user where user='"+user+"' AND pass='"+pass+"'";
            String sql = "Select Nom from medcin  ";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                U.add(rs.getString("nom"));
            }

            return U;

        } catch (Exception ex) {

            return U;
        }

    }

    //-----------------------------------------------------------Agent------------------------
    public static String AjouerPatient(String nom, String prenom, String date, String sex, String tel, String adress) {

        getConnection();

        Statement stmt = null;
        PreparedStatement ps = null;
        String sql;
        try {
            //virifier si le client exist deja

            //ajouter  client a la base de donnes
            stmt = myconn.createStatement();
            sql = "INSERT INTO paitents VALUES(null,'" + nom + "','" + prenom + "','" + date + "','" + sex + "','" + tel + "','" + adress + "') ";
            int num = stmt.executeUpdate(sql);
            if (num == 1) {
                return "patient ajouté avec succès";
            } else {
                return "erreur : le patient ñ'est pas ajouter";
            }
        } catch (Exception ex) {

            return "erreur: " + ex.getMessage();
        }

    }

    public static String AjouerOperation(int ID_pa, String nom_med, String cause_med,int num_billan) {

        getConnection();

        Statement stmt = null;
        PreparedStatement ps = null;
        String sql;
        try {
            //virifier si le client exist deja

            //ajouter  client a la base de donnes
            stmt = myconn.createStatement();

            sql = " INSERT INTO operation(ID_Operation, ID_pat, nom_medecin_prv, cause_medical,num_billan) VALUES (null,"+ID_pa+",'" + nom_med + "','" + cause_med + "',"+num_billan+")";
            int num = stmt.executeUpdate(sql);
            if (num == 1) {
                return " l'Operation ajouté avec succès";
            } else {
                return "erreur : l'Operation ñ'est pas ajouter";
            }
        } catch (Exception ex) {

            return "erreur: " + ex.getMessage();
        }

    }

    public static List<Operation> AfficherOperation() {
        List<Operation> op = new ArrayList<Operation>();
        Operation O = null;
        ResultSet rs = null;
        getConnection();
        Statement stmt = null;
        try {
            stmt = myconn.createStatement();
            String sql = "SELECT ID_Operation ,ID_pat,nom,prenom,date_n,sex,Tel,adress,nom_medecin_prv,cause_medical,Etat_operation,medecin_operation,date_operation FROM operation,paitents WHERE operation.ID_pat=paitents.ID_pa ";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {

                O = new Operation(rs.getInt("ID_Operation"), rs.getString("nom_medecin_prv"), rs.getString("cause_medical"), rs.getString("Etat_operation"), rs.getInt("ID_pat"), rs.getString("nom"), rs.getString("prenom"), rs.getString("date_n"), rs.getString("sex"), rs.getString("tel"), rs.getString("adress"));
                O.setMedecin_operation(rs.getString("medecin_operation"));
                O.setDateOperation(rs.getString("date_operation"));
                op.add(O);

            }

        } catch (Exception ex) {
            System.err.println("erreur" + ex.getMessage());
            return null;
        }

        return op;
    }

    public static String AjouerComptRendu(int ID_op, String Comptrendu) {

        getConnection();
        Statement stmt = null;
        PreparedStatement ps = null;
        String sql;
        try {

            stmt = myconn.createStatement();

            sql = " Update operation set Compte_rendu='" + Comptrendu + "' where ID_Operation=" + ID_op;
            int num = stmt.executeUpdate(sql);
            if (num == 1) {
                return " le compte rendu ajouté avec succès";
            } else {
                return "erreur : l'le compte rendu n'est pas ajouter";
            }
        } catch (Exception ex) {

            return "erreur: " + ex.getMessage();
        }

    }

    public static List<Operation> listOperationEnattent() {
        List<Operation> op = new ArrayList<Operation>();
        Operation O = null;
        ResultSet rs = null;
        getConnection();
        Statement stmt = null;
        try {
            stmt = myconn.createStatement();
            String sql = "SELECT ID_Operation ,ID_pat,nom,prenom,date_n,sex,Tel,adress,nom_medecin_prv,cause_medical,Etat_operation,Compte_rendu,billan.billan,medecin_operation FROM paitents,  operation\n" +
"LEFT JOIN billan\n" +
"ON billan.num_billan=operation.num_billan  WHERE operation.ID_pat=paitents.ID_pa AND Etat_operation='en attente' ";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                O = new Operation();
                O.setId_operation(rs.getInt("ID_Operation"));
                O.setNom_medecin_prv(rs.getString("nom_medecin_prv"));
                O.setCause_medecal(rs.getString("cause_medical"));
                O.setCompte_rendu(rs.getString("Compte_rendu"));
                O.setEtat_chu(rs.getString("Etat_operation"));
                O.setId_pat( rs.getInt("ID_pat"));
                O.setNom(rs.getString("nom"));
                O.setPrenom(rs.getString("prenom"));
                O.setDate_n( rs.getString("date_n"));
                O.setSex(rs.getString("sex"));
                O.setTel(rs.getString("tel"));
                O.setAdress(rs.getString("adress"));
                op.add(O);
            }

        } catch (Exception ex) {
            System.err.println("erreur" + ex.getMessage());
            return null;
        }

        return op;
    }

     public static List<Operation> listTOUSOperation() {
        List<Operation> op = new ArrayList<Operation>();
        Operation O = null;
        ResultSet rs = null;
        getConnection();
        Statement stmt = null;
        try {
            stmt = myconn.createStatement();
            String sql = "SELECT ID_Operation ,ID_pat,nom,prenom,date_n,sex,Tel,adress,nom_medecin_prv,cause_medical,Etat_operation,Compte_rendu,billan.billan,medecin_operation,date_operation FROM paitents,  operation\n" +
"LEFT JOIN billan\n" +
"ON billan.num_billan=operation.num_billan  WHERE operation.ID_pat=paitents.ID_pa ";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                O = new Operation();
                O.setId_operation(rs.getInt("ID_Operation"));
                O.setNom_medecin_prv(rs.getString("nom_medecin_prv"));
                O.setCause_medecal(rs.getString("cause_medical"));
                O.setCompte_rendu(rs.getString("Compte_rendu"));
                O.setEtat_chu(rs.getString("Etat_operation"));
                O.setBillan(rs.getString("billan"));
                O.setMedecin_operation(rs.getString("medecin_operation"));
                 O.setDateOperation(rs.getString("date_operation"));
                O.setId_pat( rs.getInt("ID_pat"));
                O.setNom(rs.getString("nom"));
                O.setPrenom(rs.getString("prenom"));
                O.setDate_n( rs.getString("date_n"));
                O.setSex(rs.getString("sex"));
                O.setTel(rs.getString("tel"));
                O.setAdress(rs.getString("adress"));
                op.add(O);
            }

        } catch (Exception ex) {
            System.err.println("erreur" + ex.getMessage());
            return null;
        }

        return op;
    }
    public static Boolean DisponinibibiliteResource(int id) {
        boolean is_dispo = false;
        getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = myconn.createStatement();

            String sql = "SELECT count(*) AS nb FROM resource WHERE nb_LitOp>0 And nb_chambreOpra>0 AND nb_chambre_host>0 AND nb_Lit_host>0 AND id=" + id;
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                if (rs.getInt("nb") > 0) {
                    return true;
                } else {
                    return false;
                }

            } else {
                return false;
            }

        } catch (Exception ex) {

            return false;
        }

    }

    public static String DisponinibibiliteMedecin(String DATE) {

        getConnection();
        String sql = "";
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = myconn.createStatement();

            sql = "SELECT medcin.nom AS NAME  FROM medcin where medcin.nom not in(SELECT medcin.nom FROM `operation`, medcin where medcin.nom=operation.Medecin_operation  And Etat_operation='Valider'  and operation.date_operation ='" + DATE + "') limit 1";
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return rs.getString("NAME");
            } else {
                return "null";
            }

        } catch (Exception ex) {

            return "null";
        }

    }

    public static String GetDateOperation() {

        getConnection();
        String sql = "";
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = myconn.createStatement();
            boolean trouve = false;
            int nb_jour = 1;

            while (!trouve) {

                sql = "SELECT medcin.nom AS NAME ,DATE_ADD(CURRENT_DATE, INTERVAL " + nb_jour + " DAY) AS DATE FROM medcin where medcin.nom not in(SELECT medcin.nom FROM `operation`, medcin where medcin.nom=operation.Medecin_operation  And Etat_operation='Valider'  and operation.date_operation =DATE_ADD(CURRENT_DATE, INTERVAL " + nb_jour + " DAY)) limit 1";
                rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    return rs.getString("DATE");
                }
                nb_jour++;
            }

            return "null";

        } catch (Exception ex) {

            return "null";
        }

    }

    public static String ConfirmerOperation(int ID_op, String date, String nom_med) {

        getConnection();
        Statement stmt = null;
        PreparedStatement ps = null;
        String sql;
        try {

            stmt = myconn.createStatement();

            sql = " Update operation set date_operation='" + date + "',Medecin_operation='" + nom_med + "' ,Etat_operation='Valider' where ID_Operation=" + ID_op;
            int num = stmt.executeUpdate(sql);
            if (num == 1) {
                return "  Validation  avec succès";
            } else {
                return "erreur :  ne pas valider";
            }
        } catch (Exception ex) {

            return "erreur: " + ex.getMessage();
        }

    }

    
      public static String AjouerBillan( String Billan,int id_pat) {

        getConnection();
        Statement stmt = null;
        PreparedStatement ps = null;
        String sql;
        try {
            //virifier si le client exist deja

            //ajouter  client a la base de donnes
            stmt = myconn.createStatement();

            sql = " INSERT INTO billan VALUES (null,'" + Billan + "','"+id_pat+"')";
            int num = stmt.executeUpdate(sql);
            if (num == 1) {
                return " le billan ajouté avec succès";
            } else {
                return "erreur : le billan n'est pas ajouter";
            }
        } catch (Exception ex) {

            return "erreur: " + ex.getMessage();
        }

    }
    
      public static List<Billan> listeBillan() {
        List<Billan> op = new ArrayList<Billan>();
        Billan O = null;
        ResultSet rs = null;
        getConnection();
        Statement stmt = null;
        try {
            stmt = myconn.createStatement();
            String sql = " SELECT paitents.ID_pa,nom,prenom,date_n,sex,Tel,adress,num_billan,billan.billan AS B FROM paitents,billan WHERE billan.ID_pa=paitents.id_pa";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                O = new Billan(rs.getInt("ID_pa"), rs.getString("nom"), rs.getString("prenom"), rs.getString("date_n"), rs.getString("sex"), rs.getString("tel"), rs.getString("adress"),rs.getInt("num_billan"),rs.getString("B"));
                
                op.add(O);

            }

        } catch (Exception ex) {
            System.err.println("erreur" + ex.getMessage());
            return null;
        }

        return op;
    }
    
         public static String AllouerResource(int id) {
        boolean is_dispo = false;
        getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = myconn.createStatement();

            String sql = "Update  resource  set nb_LitOp=nb_LitOp-1 , nb_chambreOpra=nb_chambreOpra-1 , nb_chambre_host=nb_chambre_host-1 AND nb_Lit_host=nb_Lit_host-1 WHERE id=" + id;
            int num = stmt.executeUpdate(sql);
          if (num == 1) {
                return " les ressource allouée avec succès";
            } else {
                return "erreur : les ressource  n'est pas allouée";
            }

        } catch (Exception ex) {

            return ex.getMessage();
        }

    }
      
    public static void main(String[] args) {
       List<Operation> l= new ArrayList<Operation>();
     l=  listOperationEnattent();
       for(Operation op : l){
            System.out.println(op.getId_operation());
    
    }  

    }
    
}
