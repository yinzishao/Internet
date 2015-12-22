/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class DBOperate12 {
    private static Connection con;
    static Statement stmt,stmtl;
    static ResultSet rs;
    private static DatabaseMetaData meta;
    private static ResultSet tables;
    private static ResultSetMetaData fields;
    private static int n;
    public static void main(String [] args) throws Exception{
         Class jdbcDriver=Class.forName("com.mysql.jdbc.Driver");     
        java.sql.DriverManager.registerDriver((Driver)jdbcDriver.newInstance());       
        String dbUrl ="jdbc:mysql://222.201.101.15:3306/MYSTUDENTDB";
        // String dbUrl ="jdbc:mysql://127.0.0.1:3306/STUDENTDB";   // root 123
        //String dbUrl ="jdbc:mysql://192.168.207.72:3306/STUDENTDB";
        String dbUser ="myroot";
        String dbPwd ="my999";
        con = java.sql.DriverManager.getConnection(dbUrl,dbUser,dbPwd);
        
        
//        meta=con.getMetaData();
//        tables=meta.getTables(null, null, null, new String[]{"TABLE"});
//        while(tables.next()){
//            String sno1 =tables.getString(1);
//            System.out.println(sno1);
//            String sno2 =tables.getString(2);
//            System.out.println(sno2);
//            String sno3 =tables.getString(3);
//            System.out.println(sno3);
//            String sno4 =tables.getString(4);
//            System.out.println(sno4);
//        }
        
        stmt = con.createStatement();
//        rs=stmt.executeQuery("select * from courses");
//        fields=rs.getMetaData();//会返回该表的字段信息
//        n=fields.getColumnCount();//会返回表中字段的数目
//        for(int i=1;i<=n;i++){
//           System.out.println( fields.getColumnLabel(i));//会返回表中第i个字段名
//        }
        
        String sName=new String("尹子韶".getBytes("GB2312"),"ISO-8859-1");
        String sClass=new String("软件一班".getBytes("GB2312"),"ISO-8859-1");
//        String sIP="192.168.207.72";
//        stmt.executeUpdate("insert into boyandgirls (YOURNO,YOURNAME,AGE,CLASS) " 
//             +"VALUES ('20131003506','"+sName+"',21,'"+sClass+"')");
        

    
//        stmt.executeUpdate("insert into STUDENTS (NO,NAME,AGE,CLASS) " 
//             +"VALUES ('20131003500','"+sName+"',21,'"+sClass+"')");
//         stmt.executeUpdate("insert into STUDENTS (NO,NAME,AGE,CLASS,IP) " 
//             +"VALUES ('20131003506','"+sName+"',21,'"+sClass+"', '"+sIP+"')");
        
        rs = stmt.executeQuery("SELECT YOURNO,YOURNAME,AGE,CLASS from boyandgirls");
        while (rs.next()){
            String sno2 =rs.getString(1);
            String sname2 =rs.getString(2);
            String s3 =rs.getString(3);
            String s4 =rs.getString(4);
            sname2 = new String(sname2.getBytes("ISO-8859-1"),"GB2312"); 
            if(s4!=null){
                s4 = new String(s4.getBytes("ISO-8859-1"),"GB2312"); 
            }
            
            System.out.println(sno2+"name:"+sname2+" age:"+s3+" class:"+s4);
            
//            if(sname2=="尹子韶"){
//                System.out.print(sno2+"name:"+sname2);
//            }
            
        }
        con.close();
//        stmt.close();
//        rs.close();
    }
    
}
