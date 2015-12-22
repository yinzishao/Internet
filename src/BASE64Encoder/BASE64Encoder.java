/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BASE64Encoder;

/**
 *
 * @author Administrator
 */
public class BASE64Encoder {
    public static void main(String args[]){
String username="20131003506@gdufs.edu.cn";
String password= "182134";
username = new sun.misc.BASE64Encoder().encode(username.getBytes());
password = new sun.misc.BASE64Encoder().encode(password.getBytes());

System.out.println(username);
  System.out.println(password);  
}

}
