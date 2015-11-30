/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jframe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
class MyFileWrite {
    PrintWriter pw;
    MyFileWrite(){
        String path ="yin.txt";
        File file = new File(path);
        try {
        	FileOutputStream  fops= new FileOutputStream(file,true);
            pw = new PrintWriter(fops);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MyFileWrite.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void append(String msg){
        pw.println(msg);
    }
    public void close(){
        pw.close();
    }
    
    public static void main(String [] args){
        MyFileWrite mfw = new MyFileWrite();
        mfw.append("ssss");
        mfw.close();
    }
}
