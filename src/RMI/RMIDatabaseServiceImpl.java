/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import com.mysql.jdbc.Driver;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Administrator
 */
public class RMIDatabaseServiceImpl  extends UnicastRemoteObject 
                     implements RMIDatabaseService {
     private static Connection con;
    static Statement stmt,stmtl;
    static ResultSet rs;
    public RMIDatabaseServiceImpl()throws RemoteException{ }
    
    @Override
    public String insert(String no,String name,int age, String sClass)
                       throws RemoteException{
       try{
           
        Class jdbcDriver=Class.forName("com.mysql.jdbc.Driver");     
        java.sql.DriverManager.registerDriver((Driver)jdbcDriver.newInstance());       
        String dbUrl ="jdbc:mysql://222.201.101.15：1099/STUDENTDB1";
        // String dbUrl ="jdbc:mysql://127.0.0.1:3306/STUDENTDB";   // root 123
        //String dbUrl ="jdbc:mysql://192.168.207.72:3306/STUDENTDB";
        String dbUser ="myuser";
        String dbPwd ="mysql";
        con = java.sql.DriverManager.getConnection(dbUrl,dbUser,dbPwd);
        stmt = con.createStatement();
       }
       catch(Exception ex){
           
       }
    
        return "";
        }
}
