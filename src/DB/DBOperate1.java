/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class DBOperate1 {
    private static Connection con;
    static Statement stmt,stmtl;
    static ResultSet rs;
    public static void main(String [] args) throws Exception{
         Class jdbcDriver=Class.forName("com.mysql.jdbc.Driver");     
        java.sql.DriverManager.registerDriver((Driver)jdbcDriver.newInstance());       
        String dbUrl ="jdbc:mysql://222.201.101.15:3306/STUDENTDB1";
        // String dbUrl ="jdbc:mysql://127.0.0.1:3306/STUDENTDB";   // root 123
        //String dbUrl ="jdbc:mysql://192.168.207.72:3306/STUDENTDB";
        String dbUser ="myuser";
        String dbPwd ="mysql";
        con = java.sql.DriverManager.getConnection(dbUrl,dbUser,dbPwd);
        stmt = con.createStatement();
        String sName=new String("尹子韶".getBytes("GB2312"),"ISO-8859-1");
        String sClass=new String("软件一班".getBytes("GB2312"),"ISO-8859-1");
        String sIP="192.168.207.72";
//        stmt.executeUpdate("insert into STUDENTS (NO,NAME,AGE,CLASS) " 
//             +"VALUES ('20131003500','"+sName+"',21,'"+sClass+"')");
//         stmt.executeUpdate("insert into STUDENTS (NO,NAME,AGE,CLASS,IP) " 
//             +"VALUES ('20131003506','"+sName+"',21,'"+sClass+"', '"+sIP+"')");
        rs = stmt.executeQuery("SELECT NO,NAME,AGE,CLASS from Students");
        while (rs.next()){
            String sno2 =rs.getString(1);
            String sname2 =rs.getString(2);
            sname2 = new String(sname2.getBytes("ISO-8859-1"),"GB2312"); 
            System.out.print(sno2+"name:"+sname2);
            if(sname2=="尹子韶"){
                System.out.print(sno2+"name:"+sname2);
            }
            
        }
        con.close();
        stmt.close();
        rs.close();
    }
    
}
