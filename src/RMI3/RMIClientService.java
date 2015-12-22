/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI3;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Administrator
 */
public interface RMIClientService extends Remote{   
   //该方法由服务器调用，服务器有新信息
   public void showMessageToClient(String msg)throws RemoteException;
}
