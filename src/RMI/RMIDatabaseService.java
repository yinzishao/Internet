/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Administrator
 */
public interface RMIDatabaseService extends Remote{
      //定义一个远程方法，在给定的数据库中插入一条记录，并返回插入的结果.
      public String insert(String no,String name,int age, 
                             String sClass) throws RemoteException;
  }
  


